package org.icrc.fhir.demo

import android.content.Context
import androidx.work.WorkerParameters
import com.google.android.fhir.FhirEngine
import com.google.android.fhir.sync.ConflictResolver
import com.google.android.fhir.sync.DownloadWorkManager
import com.google.android.fhir.sync.FhirSyncWorker

data class FhirSyncWorkerData( val fhirEngine: FhirEngine, val downloadWorkManager:DownloadWorkManager,
                               val conflictResolver: ConflictResolver
)

class ICRCFhirSyncWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private var fhirSyncWorkerData: FhirSyncWorkerData
) :
    FhirSyncWorker(appContext, workerParams) {


    override fun getConflictResolver(): ConflictResolver {
        return fhirSyncWorkerData.conflictResolver
    }

    override fun getDownloadWorkManager(): DownloadWorkManager {
        return fhirSyncWorkerData.downloadWorkManager;
    }

    override fun getFhirEngine(): FhirEngine {
        return fhirSyncWorkerData.fhirEngine
    }
}