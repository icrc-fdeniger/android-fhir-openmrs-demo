package org.icrc.fhir.demo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.Data
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import com.google.android.fhir.FhirEngine
import com.google.android.fhir.LocalChange
import com.google.android.fhir.SearchResult
import com.google.android.fhir.search.Search
import com.google.android.fhir.sync.AcceptRemoteConflictResolver
import com.google.android.fhir.sync.ResourceSyncException
import com.google.android.fhir.sync.SyncJobStatus
import com.google.android.fhir.sync.SyncOperation
import com.google.android.fhir.sync.upload.LocalChangesFetchMode
import com.google.android.fhir.sync.upload.SyncUploadProgress
import com.google.android.fhir.sync.upload.UploadSyncResult
import com.google.common.truth.Truth
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.runBlocking
import org.apache.commons.lang3.time.DateUtils
import org.hl7.fhir.r4.model.Patient
import org.hl7.fhir.r4.model.ResourceType
import org.junit.Assert
import org.junit.Assume
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.Date

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class OpenMRSAccessTest {

    private val logger = KotlinLogging.logger {}
    private val context: Context = ApplicationProvider.getApplicationContext();
    private val fhirEngine: FhirEngine = LoadConnectionInfo.getRetrofitHttpService(context);


    @Before
    fun testFhirEngineIsCreated() {
        Assume.assumeNotNull(fhirEngine);
    }


    /**
     * in this suppose there is a patient in OpenMRS with  address-city=NAIROBI
     * See ICRCDownloadManagerImpl
     * Bug on Windows: https://issuetracker.google.com/issues/203087070
     */
    @Test
    fun testSynchro() {
        val fhirSyncWorkerData = FhirSyncWorkerData(fhirEngine, ICRCDownloadManagerImpl(), AcceptRemoteConflictResolver)
        val worker: ICRCFhirSyncWorker =
            TestListenableWorkerBuilder<ICRCFhirSyncWorker>(
                context,
                inputData = Data.Builder().putInt("max_retires", 2).build(),
                runAttemptCount = 2,
            )
                .setWorkerFactory(ICRCWorkerFactory(fhirSyncWorkerData))
                .build()

        var result: ListenableWorker.Result = runBlocking {
            logger.info { "start downloading" }
            worker.doWork()
        }
        Truth.assertThat(result).isInstanceOf(ListenableWorker.Result.Success()::class.java)
        val patients: List<SearchResult<Patient>> = runBlocking {
            fhirEngine.search(Search(ResourceType.Patient))
        }
        Assert.assertFalse(patients.isEmpty())
        val patient = patients[0].resource
        patient.setLanguage("fr")
        runBlocking {
            logger.info { "start updating" }
            fhirEngine.update(patient)
        };
        result = runBlocking {
            logger.info { "start uploading" }
            worker.doWork()
        }
        if(result is ListenableWorker.Result.Failure){
            logger.error {"can't upload data" }
            logger.error { result.outputData }
        }
        Truth.assertThat(result).isInstanceOf(ListenableWorker.Result.Success()::class.java)
    }

}