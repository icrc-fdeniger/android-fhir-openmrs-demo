package org.icrc.fhir.demo

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

class ICRCWorkerFactory(private val fhirSyncWorkerData: FhirSyncWorkerData) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return ICRCFhirSyncWorker(appContext, workerParameters, fhirSyncWorkerData)
    }
}