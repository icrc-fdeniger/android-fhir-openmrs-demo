package org.icrc.fhir.demo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.work.Data
import androidx.work.testing.TestListenableWorkerBuilder
import com.google.android.fhir.FhirEngine
import com.google.android.fhir.search.Search
import com.google.android.fhir.sync.AcceptRemoteConflictResolver
import kotlinx.coroutines.runBlocking
import org.hl7.fhir.r4.model.Patient
import org.hl7.fhir.r4.model.ResourceType
import org.junit.Assume
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OpenMRSAccessAndroidTest {

    //    private val logger = KotlinLogging.logger {}
    private val context: Context = ApplicationProvider.getApplicationContext();
    private val fhirEngine: FhirEngine = LoadConnectionInfo.getRetrofitHttpService(context);
    private val executor: Executor = Executors.newSingleThreadExecutor()


    @Before
    fun testFhirEngineIsCreated() {
        Assume.assumeNotNull(fhirEngine);
    }

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
        runBlocking {
            worker.doWork()
            val patients=fhirEngine.search<Patient>(Search(ResourceType.Patient))
            Assume.assumeFalse(patients.isEmpty())
        }

    }

}