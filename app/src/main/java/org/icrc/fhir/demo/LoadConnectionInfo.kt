package org.icrc.fhir.demo

import android.content.Context
import com.google.android.fhir.*
import com.google.android.fhir.sync.HttpAuthenticationMethod
import com.google.android.fhir.sync.HttpAuthenticator
import com.google.android.fhir.sync.remote.HttpLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import java.io.File
import java.io.FileInputStream
import java.util.*

object LoadConnectionInfo {

    private val logger = KotlinLogging.logger {}

    internal fun getRetrofitHttpService(context: Context): FhirEngine {
        val openmrsFileProperties = File("./openmrs.properties").absoluteFile;
        if (!openmrsFileProperties.exists()) {
            throw IllegalAccessError("file ${openmrsFileProperties.path} can't be found");
        }
        val properties = Properties()
        FileInputStream(openmrsFileProperties).use {
            properties.load(it);
        }
        val openmrsUser: String = properties.getProperty("openmrsUser", "")
        val openmrsPwd: String = properties.getProperty("openmrsPwd", "")
        val openmrsUrl: String = properties.getProperty("openmrsUrl", "")
        var valid: Boolean = true;
        if (openmrsUser.isBlank()) {
            logger.error { "the property openmrsUser is not set in ${openmrsFileProperties.path}" }
            valid = false;
        }
        if (openmrsPwd.isBlank()) {
            logger.error { "the property openmrsPwd is not set in ${openmrsFileProperties.path}" }
            valid = false;
        }
        if (openmrsUrl.isBlank()) {
            logger.error { "the property openmrsUrl is not set in ${openmrsFileProperties.path}" }
            valid = false;
        }
        if (!valid) {
            throw IllegalAccessError("Some required properties are not set");
        } else {
            logger.info { "Can configure HttpService" }
        }

        val fhirEngineConfiguration = FhirEngineConfiguration(
            enableEncryptionIfSupported = false,
            databaseErrorStrategy = DatabaseErrorStrategy.UNSPECIFIED,
            testMode = true,
            serverConfiguration = ServerConfiguration(
                baseUrl = openmrsUrl,
                authenticator = {
                    HttpAuthenticationMethod.Basic(
                        username = openmrsUser,
                        password = openmrsPwd
                    )
                },
                httpLogger = HttpLogger(HttpLogger.Configuration(HttpLogger.Level.BODY)) {
                    logger.info { it }
                }
            )
        )
        FhirEngineProvider.init(fhirEngineConfiguration)
        logger.info { "Create FhirEngine" }
        return FhirEngineProvider.getInstance(context);

    }
}