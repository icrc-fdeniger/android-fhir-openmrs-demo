package com.google.android.fhir.index

import kotlin.String
import kotlin.collections.List
import org.hl7.fhir.r4.model.Enumerations
import org.hl7.fhir.r4.model.Resource

private fun getBaseResourceSearchParamsList(resourceName: String): List<SearchParamDefinition> =
    buildList(capacity = 6) {
  add(SearchParamDefinition("_id", Enumerations.SearchParamType.TOKEN, """$resourceName.id"""))
  add(SearchParamDefinition("_lastUpdated", Enumerations.SearchParamType.DATE,
      """$resourceName.meta.lastUpdated"""))
  add(SearchParamDefinition("_profile", Enumerations.SearchParamType.URI,
      """$resourceName.meta.profile"""))
  add(SearchParamDefinition("_security", Enumerations.SearchParamType.TOKEN,
      """$resourceName.meta.security"""))
  add(SearchParamDefinition("_source", Enumerations.SearchParamType.URI,
      """$resourceName.meta.source"""))
  add(SearchParamDefinition("_tag", Enumerations.SearchParamType.TOKEN,
      """$resourceName.meta.tag"""))
}

private fun getAppointment(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("actor", Enumerations.SearchParamType.REFERENCE,
      "Appointment.participant.actor"))
  add(SearchParamDefinition("appointment-type", Enumerations.SearchParamType.TOKEN,
      "Appointment.appointmentType"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "Appointment.basedOn"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Appointment.start"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Appointment.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "Appointment.participant.actor.where(resolve() is Location)"))
  add(SearchParamDefinition("part-status", Enumerations.SearchParamType.TOKEN,
      "Appointment.participant.status"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Appointment.participant.actor.where(resolve() is Patient)"))
  add(SearchParamDefinition("practitioner", Enumerations.SearchParamType.REFERENCE,
      "Appointment.participant.actor.where(resolve() is Practitioner)"))
  add(SearchParamDefinition("reason-code", Enumerations.SearchParamType.TOKEN,
      "Appointment.reasonCode"))
  add(SearchParamDefinition("reason-reference", Enumerations.SearchParamType.REFERENCE,
      "Appointment.reasonReference"))
  add(SearchParamDefinition("service-category", Enumerations.SearchParamType.TOKEN,
      "Appointment.serviceCategory"))
  add(SearchParamDefinition("service-type", Enumerations.SearchParamType.TOKEN,
      "Appointment.serviceType"))
  add(SearchParamDefinition("slot", Enumerations.SearchParamType.REFERENCE, "Appointment.slot"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN,
      "Appointment.specialty"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Appointment.status"))
  add(SearchParamDefinition("supporting-info", Enumerations.SearchParamType.REFERENCE,
      "Appointment.supportingInformation"))
}

private fun getAccount(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Account.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Account.name"))
  add(SearchParamDefinition("owner", Enumerations.SearchParamType.REFERENCE, "Account.owner"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Account.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE, "Account.servicePeriod"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Account.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Account.subject"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Account.type"))
}

private fun getInvoice(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("account", Enumerations.SearchParamType.REFERENCE, "Invoice.account"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Invoice.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Invoice.identifier"))
  add(SearchParamDefinition("issuer", Enumerations.SearchParamType.REFERENCE, "Invoice.issuer"))
  add(SearchParamDefinition("participant", Enumerations.SearchParamType.REFERENCE,
      "Invoice.participant.actor"))
  add(SearchParamDefinition("participant-role", Enumerations.SearchParamType.TOKEN,
      "Invoice.participant.role"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Invoice.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("recipient", Enumerations.SearchParamType.REFERENCE,
      "Invoice.recipient"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Invoice.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Invoice.subject"))
  add(SearchParamDefinition("totalgross", Enumerations.SearchParamType.QUANTITY,
      "Invoice.totalGross"))
  add(SearchParamDefinition("totalnet", Enumerations.SearchParamType.QUANTITY, "Invoice.totalNet"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Invoice.type"))
}

private fun getEventDefinition(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "EventDefinition.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(EventDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "EventDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "EventDefinition.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "EventDefinition.relatedArtifact.where(type='depends-on').resource"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "EventDefinition.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "EventDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "EventDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EventDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "EventDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "EventDefinition.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "EventDefinition.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "EventDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "EventDefinition.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "EventDefinition.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "EventDefinition.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "EventDefinition.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "EventDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "EventDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "EventDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "EventDefinition.useContext"))
}

private fun getDocumentManifest(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DocumentManifest.masterIdentifier | DocumentManifest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "DocumentManifest.type"))
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.author"))
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE,
      "DocumentManifest.created"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "DocumentManifest.description"))
  add(SearchParamDefinition("item", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.content"))
  add(SearchParamDefinition("recipient", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.recipient"))
  add(SearchParamDefinition("related-id", Enumerations.SearchParamType.TOKEN,
      "DocumentManifest.related.identifier"))
  add(SearchParamDefinition("related-ref", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.related.ref"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.URI, "DocumentManifest.source"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "DocumentManifest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "DocumentManifest.subject"))
}

private fun getMessageDefinition(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(MessageDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "MessageDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "MessageDefinition.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "MessageDefinition.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "MessageDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "MessageDefinition.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "MessageDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "MessageDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "MessageDefinition.useContext"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.identifier"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.category"))
  add(SearchParamDefinition("event", Enumerations.SearchParamType.TOKEN, "MessageDefinition.event"))
  add(SearchParamDefinition("focus", Enumerations.SearchParamType.TOKEN,
      "MessageDefinition.focus.code"))
  add(SearchParamDefinition("parent", Enumerations.SearchParamType.REFERENCE,
      "MessageDefinition.parent"))
}

private fun getGoal(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Goal.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Goal.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("achievement-status", Enumerations.SearchParamType.TOKEN,
      "Goal.achievementStatus"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Goal.category"))
  add(SearchParamDefinition("lifecycle-status", Enumerations.SearchParamType.TOKEN,
      "Goal.lifecycleStatus"))
  add(SearchParamDefinition("start-date", Enumerations.SearchParamType.DATE,
      "(Goal.start as date)"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Goal.subject"))
  add(SearchParamDefinition("target-date", Enumerations.SearchParamType.DATE,
      "(Goal.target.due as date)"))
}

private fun getMedicinalProductPackaged(): List<SearchParamDefinition> = buildList(capacity = 2) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductPackaged.identifier"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductPackaged.subject"))
}

private fun getEndpoint(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("connection-type", Enumerations.SearchParamType.TOKEN,
      "Endpoint.connectionType"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Endpoint.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Endpoint.name"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "Endpoint.managingOrganization"))
  add(SearchParamDefinition("payload-type", Enumerations.SearchParamType.TOKEN,
      "Endpoint.payloadType"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Endpoint.status"))
}

private fun getEnrollmentRequest(): List<SearchParamDefinition> = buildList(capacity = 4) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EnrollmentRequest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "EnrollmentRequest.candidate"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "EnrollmentRequest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "EnrollmentRequest.candidate"))
}

private fun getConsent(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Consent.dateTime"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Consent.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE, "Consent.patient"))
  add(SearchParamDefinition("action", Enumerations.SearchParamType.TOKEN,
      "Consent.provision.action"))
  add(SearchParamDefinition("actor", Enumerations.SearchParamType.REFERENCE,
      "Consent.provision.actor.reference"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Consent.category"))
  add(SearchParamDefinition("consentor", Enumerations.SearchParamType.REFERENCE,
      "Consent.performer"))
  add(SearchParamDefinition("data", Enumerations.SearchParamType.REFERENCE,
      "Consent.provision.data.reference"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "Consent.organization"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE,
      "Consent.provision.period"))
  add(SearchParamDefinition("purpose", Enumerations.SearchParamType.TOKEN,
      "Consent.provision.purpose"))
  add(SearchParamDefinition("scope", Enumerations.SearchParamType.TOKEN, "Consent.scope"))
  add(SearchParamDefinition("security-label", Enumerations.SearchParamType.TOKEN,
      "Consent.provision.securityLabel"))
  add(SearchParamDefinition("source-reference", Enumerations.SearchParamType.REFERENCE,
      "Consent.source"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Consent.status"))
}

private fun getMedication(): List<SearchParamDefinition> = buildList(capacity = 9) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Medication.code"))
  add(SearchParamDefinition("expiration-date", Enumerations.SearchParamType.DATE,
      "Medication.batch.expirationDate"))
  add(SearchParamDefinition("form", Enumerations.SearchParamType.TOKEN, "Medication.form"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Medication.identifier"))
  add(SearchParamDefinition("ingredient", Enumerations.SearchParamType.REFERENCE,
      "(Medication.ingredient.item as Reference)"))
  add(SearchParamDefinition("ingredient-code", Enumerations.SearchParamType.TOKEN,
      "(Medication.ingredient.item as CodeableConcept)"))
  add(SearchParamDefinition("lot-number", Enumerations.SearchParamType.TOKEN,
      "Medication.batch.lotNumber"))
  add(SearchParamDefinition("manufacturer", Enumerations.SearchParamType.REFERENCE,
      "Medication.manufacturer"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Medication.status"))
}

private fun getCapabilityStatement(): List<SearchParamDefinition> = buildList(capacity = 23) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(CapabilityStatement.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "CapabilityStatement.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "CapabilityStatement.description"))
  add(SearchParamDefinition("fhirversion", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.version"))
  add(SearchParamDefinition("format", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.format"))
  add(SearchParamDefinition("guide", Enumerations.SearchParamType.REFERENCE,
      "CapabilityStatement.implementationGuide"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.jurisdiction"))
  add(SearchParamDefinition("mode", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.rest.mode"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "CapabilityStatement.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "CapabilityStatement.publisher"))
  add(SearchParamDefinition("resource", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.rest.resource.type"))
  add(SearchParamDefinition("resource-profile", Enumerations.SearchParamType.REFERENCE,
      "CapabilityStatement.rest.resource.profile"))
  add(SearchParamDefinition("security-service", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.rest.security.service"))
  add(SearchParamDefinition("software", Enumerations.SearchParamType.STRING,
      "CapabilityStatement.software.name"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.status"))
  add(SearchParamDefinition("supported-profile", Enumerations.SearchParamType.REFERENCE,
      "CapabilityStatement.rest.resource.supportedProfile"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "CapabilityStatement.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "CapabilityStatement.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "CapabilityStatement.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "CapabilityStatement.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "CapabilityStatement.useContext"))
}

private fun getMeasure(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "Measure.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(Measure.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Measure.useContext.value as Quantity) | (Measure.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "Measure.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Measure.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "Measure.relatedArtifact.where(type='depends-on').resource | Measure.library"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "Measure.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "Measure.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "Measure.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Measure.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "Measure.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Measure.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "Measure.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING, "Measure.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Measure.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "Measure.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "Measure.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "Measure.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Measure.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "Measure.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Measure.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "Measure.useContext"))
}

private fun getResearchSubject(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ResearchSubject.period"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ResearchSubject.identifier"))
  add(SearchParamDefinition("individual", Enumerations.SearchParamType.REFERENCE,
      "ResearchSubject.individual"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ResearchSubject.individual"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ResearchSubject.status"))
  add(SearchParamDefinition("study", Enumerations.SearchParamType.REFERENCE,
      "ResearchSubject.study"))
}

private fun getSubscription(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("contact", Enumerations.SearchParamType.TOKEN, "Subscription.contact"))
  add(SearchParamDefinition("criteria", Enumerations.SearchParamType.STRING,
      "Subscription.criteria"))
  add(SearchParamDefinition("payload", Enumerations.SearchParamType.TOKEN,
      "Subscription.channel.payload"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Subscription.status"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN,
      "Subscription.channel.type"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI,
      "Subscription.channel.endpoint"))
}

private fun getDocumentReference(): List<SearchParamDefinition> = buildList(capacity = 25) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.masterIdentifier | DocumentReference.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "DocumentReference.type"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.context.encounter"))
  add(SearchParamDefinition("authenticator", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.authenticator"))
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.author"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.category"))
  add(SearchParamDefinition("contenttype", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.content.attachment.contentType"))
  add(SearchParamDefinition("custodian", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.custodian"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "DocumentReference.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "DocumentReference.description"))
  add(SearchParamDefinition("event", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.context.event"))
  add(SearchParamDefinition("facility", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.context.facilityType"))
  add(SearchParamDefinition("format", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.content.format"))
  add(SearchParamDefinition("language", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.content.attachment.language"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.URI,
      "DocumentReference.content.attachment.url"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE,
      "DocumentReference.context.period"))
  add(SearchParamDefinition("related", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.context.related"))
  add(SearchParamDefinition("relatesto", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.relatesTo.target"))
  add(SearchParamDefinition("relation", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.relatesTo.code"))
  add(SearchParamDefinition("security-label", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.securityLabel"))
  add(SearchParamDefinition("setting", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.context.practiceSetting"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "DocumentReference.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "DocumentReference.subject"))
  add(SearchParamDefinition("relationship", Enumerations.SearchParamType.COMPOSITE,
      "DocumentReference.relatesTo"))
}

private fun getGraphDefinition(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(GraphDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "GraphDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "GraphDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "GraphDefinition.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "GraphDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "GraphDefinition.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "GraphDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "GraphDefinition.status"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "GraphDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "GraphDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "GraphDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "GraphDefinition.useContext"))
  add(SearchParamDefinition("start", Enumerations.SearchParamType.TOKEN, "GraphDefinition.start"))
}

private fun getCoverageEligibilityResponse(): List<SearchParamDefinition> = buildList(capacity =
    9) {
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE,
      "CoverageEligibilityResponse.created"))
  add(SearchParamDefinition("disposition", Enumerations.SearchParamType.STRING,
      "CoverageEligibilityResponse.disposition"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CoverageEligibilityResponse.identifier"))
  add(SearchParamDefinition("insurer", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityResponse.insurer"))
  add(SearchParamDefinition("outcome", Enumerations.SearchParamType.TOKEN,
      "CoverageEligibilityResponse.outcome"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityResponse.patient"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityResponse.request"))
  add(SearchParamDefinition("requestor", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityResponse.requestor"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "CoverageEligibilityResponse.status"))
}

private fun getMeasureReport(): List<SearchParamDefinition> = buildList(capacity = 9) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "MeasureReport.date"))
  add(SearchParamDefinition("evaluated-resource", Enumerations.SearchParamType.REFERENCE,
      "MeasureReport.evaluatedResource"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MeasureReport.identifier"))
  add(SearchParamDefinition("measure", Enumerations.SearchParamType.REFERENCE,
      "MeasureReport.measure"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MeasureReport.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE, "MeasureReport.period"))
  add(SearchParamDefinition("reporter", Enumerations.SearchParamType.REFERENCE,
      "MeasureReport.reporter"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "MeasureReport.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MeasureReport.subject"))
}

private fun getPractitionerRole(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.telecom.where(system='email')"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.telecom.where(system='phone')"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.telecom"))
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.active"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "PractitionerRole.period"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "PractitionerRole.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "PractitionerRole.location"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "PractitionerRole.organization"))
  add(SearchParamDefinition("practitioner", Enumerations.SearchParamType.REFERENCE,
      "PractitionerRole.practitioner"))
  add(SearchParamDefinition("role", Enumerations.SearchParamType.TOKEN, "PractitionerRole.code"))
  add(SearchParamDefinition("service", Enumerations.SearchParamType.REFERENCE,
      "PractitionerRole.healthcareService"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN,
      "PractitionerRole.specialty"))
}

private fun getServiceRequest(): List<SearchParamDefinition> = buildList(capacity = 21) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "ServiceRequest.code"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.encounter"))
  add(SearchParamDefinition("authored", Enumerations.SearchParamType.DATE,
      "ServiceRequest.authoredOn"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.basedOn"))
  add(SearchParamDefinition("body-site", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.bodySite"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.category"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "ServiceRequest.instantiatesUri"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN, "ServiceRequest.intent"))
  add(SearchParamDefinition("occurrence", Enumerations.SearchParamType.DATE,
      "ServiceRequest.occurrence"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.performer"))
  add(SearchParamDefinition("performer-type", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.performerType"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.priority"))
  add(SearchParamDefinition("replaces", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.replaces"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.requester"))
  add(SearchParamDefinition("requisition", Enumerations.SearchParamType.TOKEN,
      "ServiceRequest.requisition"))
  add(SearchParamDefinition("specimen", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.specimen"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ServiceRequest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "ServiceRequest.subject"))
}

private fun getRelatedPerson(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING,
      "RelatedPerson.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "RelatedPerson.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "RelatedPerson.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "RelatedPerson.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "RelatedPerson.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "RelatedPerson.address.use"))
  add(SearchParamDefinition("birthdate", Enumerations.SearchParamType.DATE,
      "RelatedPerson.birthDate"))
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "RelatedPerson.telecom.where(system='email')"))
  add(SearchParamDefinition("gender", Enumerations.SearchParamType.TOKEN, "RelatedPerson.gender"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "RelatedPerson.telecom.where(system='phone')"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "RelatedPerson.name"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN, "RelatedPerson.telecom"))
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN, "RelatedPerson.active"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "RelatedPerson.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "RelatedPerson.name"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "RelatedPerson.patient"))
  add(SearchParamDefinition("relationship", Enumerations.SearchParamType.TOKEN,
      "RelatedPerson.relationship"))
}

private fun getSupplyRequest(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "SupplyRequest.authoredOn"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "SupplyRequest.identifier"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "SupplyRequest.category"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE,
      "SupplyRequest.requester"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "SupplyRequest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "SupplyRequest.deliverTo"))
  add(SearchParamDefinition("supplier", Enumerations.SearchParamType.REFERENCE,
      "SupplyRequest.supplier"))
}

private fun getPractitioner(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING, "Practitioner.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "Practitioner.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "Practitioner.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "Practitioner.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "Practitioner.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "Practitioner.address.use"))
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "Practitioner.telecom.where(system='email')"))
  add(SearchParamDefinition("family", Enumerations.SearchParamType.STRING,
      "Practitioner.name.family"))
  add(SearchParamDefinition("gender", Enumerations.SearchParamType.TOKEN, "Practitioner.gender"))
  add(SearchParamDefinition("given", Enumerations.SearchParamType.STRING,
      "Practitioner.name.given"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "Practitioner.telecom.where(system='phone')"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "Practitioner.name"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN, "Practitioner.telecom"))
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN, "Practitioner.active"))
  add(SearchParamDefinition("communication", Enumerations.SearchParamType.TOKEN,
      "Practitioner.communication"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Practitioner.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Practitioner.name"))
}

private fun getVerificationResult(): List<SearchParamDefinition> = buildList(capacity = 1) {
  add(SearchParamDefinition("target", Enumerations.SearchParamType.REFERENCE,
      "VerificationResult.target"))
}

private fun getBodyStructure(): List<SearchParamDefinition> = buildList(capacity = 4) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "BodyStructure.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.TOKEN,
      "BodyStructure.location"))
  add(SearchParamDefinition("morphology", Enumerations.SearchParamType.TOKEN,
      "BodyStructure.morphology"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "BodyStructure.patient"))
}

private fun getSlot(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("appointment-type", Enumerations.SearchParamType.TOKEN,
      "Slot.appointmentType"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Slot.identifier"))
  add(SearchParamDefinition("schedule", Enumerations.SearchParamType.REFERENCE, "Slot.schedule"))
  add(SearchParamDefinition("service-category", Enumerations.SearchParamType.TOKEN,
      "Slot.serviceCategory"))
  add(SearchParamDefinition("service-type", Enumerations.SearchParamType.TOKEN, "Slot.serviceType"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN, "Slot.specialty"))
  add(SearchParamDefinition("start", Enumerations.SearchParamType.DATE, "Slot.start"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Slot.status"))
}

private fun getContract(): List<SearchParamDefinition> = buildList(capacity = 10) {
  add(SearchParamDefinition("authority", Enumerations.SearchParamType.REFERENCE,
      "Contract.authority"))
  add(SearchParamDefinition("domain", Enumerations.SearchParamType.REFERENCE, "Contract.domain"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Contract.identifier"))
  add(SearchParamDefinition("instantiates", Enumerations.SearchParamType.URI,
      "Contract.instantiatesUri"))
  add(SearchParamDefinition("issued", Enumerations.SearchParamType.DATE, "Contract.issued"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Contract.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("signer", Enumerations.SearchParamType.REFERENCE,
      "Contract.signer.party"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Contract.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Contract.subject"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Contract.url"))
}

private fun getPerson(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING, "Person.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "Person.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "Person.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "Person.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "Person.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "Person.address.use"))
  add(SearchParamDefinition("birthdate", Enumerations.SearchParamType.DATE, "Person.birthDate"))
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "Person.telecom.where(system='email')"))
  add(SearchParamDefinition("gender", Enumerations.SearchParamType.TOKEN, "Person.gender"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "Person.telecom.where(system='phone')"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "Person.name"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN, "Person.telecom"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Person.identifier"))
  add(SearchParamDefinition("link", Enumerations.SearchParamType.REFERENCE, "Person.link.target"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Person.name"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "Person.managingOrganization"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Person.link.target.where(resolve() is Patient)"))
  add(SearchParamDefinition("practitioner", Enumerations.SearchParamType.REFERENCE,
      "Person.link.target.where(resolve() is Practitioner)"))
  add(SearchParamDefinition("relatedperson", Enumerations.SearchParamType.REFERENCE,
      "Person.link.target.where(resolve() is RelatedPerson)"))
}

private fun getRiskAssessment(): List<SearchParamDefinition> = buildList(capacity = 10) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "(RiskAssessment.occurrence as dateTime)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "RiskAssessment.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "RiskAssessment.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "RiskAssessment.encounter"))
  add(SearchParamDefinition("condition", Enumerations.SearchParamType.REFERENCE,
      "RiskAssessment.condition"))
  add(SearchParamDefinition("method", Enumerations.SearchParamType.TOKEN, "RiskAssessment.method"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "RiskAssessment.performer"))
  add(SearchParamDefinition("probability", Enumerations.SearchParamType.NUMBER,
      "RiskAssessment.prediction.probability"))
  add(SearchParamDefinition("risk", Enumerations.SearchParamType.TOKEN,
      "RiskAssessment.prediction.qualitativeRisk"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "RiskAssessment.subject"))
}

private fun getGroup(): List<SearchParamDefinition> = buildList(capacity = 10) {
  add(SearchParamDefinition("actual", Enumerations.SearchParamType.TOKEN, "Group.actual"))
  add(SearchParamDefinition("characteristic", Enumerations.SearchParamType.TOKEN,
      "Group.characteristic.code"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Group.code"))
  add(SearchParamDefinition("exclude", Enumerations.SearchParamType.TOKEN,
      "Group.characteristic.exclude"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Group.identifier"))
  add(SearchParamDefinition("managing-entity", Enumerations.SearchParamType.REFERENCE,
      "Group.managingEntity"))
  add(SearchParamDefinition("member", Enumerations.SearchParamType.REFERENCE,
      "Group.member.entity"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Group.type"))
  add(SearchParamDefinition("value", Enumerations.SearchParamType.TOKEN,
      "(Group.characteristic.value as CodeableConcept) | (Group.characteristic.value as boolean)"))
  add(SearchParamDefinition("characteristic-value", Enumerations.SearchParamType.COMPOSITE,
      "Group.characteristic"))
}

private fun getPaymentNotice(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE, "PaymentNotice.created"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "PaymentNotice.identifier"))
  add(SearchParamDefinition("payment-status", Enumerations.SearchParamType.TOKEN,
      "PaymentNotice.paymentStatus"))
  add(SearchParamDefinition("provider", Enumerations.SearchParamType.REFERENCE,
      "PaymentNotice.provider"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "PaymentNotice.request"))
  add(SearchParamDefinition("response", Enumerations.SearchParamType.REFERENCE,
      "PaymentNotice.response"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "PaymentNotice.status"))
}

private fun getResearchDefinition(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "ResearchDefinition.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ResearchDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ResearchDefinition.useContext.value as Quantity) | (ResearchDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ResearchDefinition.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "ResearchDefinition.relatedArtifact.where(type='depends-on').resource | ResearchDefinition.library"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "ResearchDefinition.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ResearchDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "ResearchDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "ResearchDefinition.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "ResearchDefinition.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ResearchDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "ResearchDefinition.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "ResearchDefinition.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ResearchDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ResearchDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ResearchDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ResearchDefinition.useContext"))
}

private fun getOrganization(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN, "Organization.active"))
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING, "Organization.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "Organization.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "Organization.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "Organization.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "Organization.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "Organization.address.use"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "Organization.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Organization.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "Organization.name | Organization.alias"))
  add(SearchParamDefinition("partof", Enumerations.SearchParamType.REFERENCE,
      "Organization.partOf"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "Organization.name"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Organization.type"))
}

private fun getCareTeam(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "CareTeam.period"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CareTeam.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "CareTeam.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "CareTeam.category"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "CareTeam.encounter"))
  add(SearchParamDefinition("participant", Enumerations.SearchParamType.REFERENCE,
      "CareTeam.participant.member"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "CareTeam.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "CareTeam.subject"))
}

private fun getImplementationGuide(): List<SearchParamDefinition> = buildList(capacity = 18) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ImplementationGuide.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ImplementationGuide.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ImplementationGuide.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ImplementationGuide.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ImplementationGuide.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "ImplementationGuide.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ImplementationGuide.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ImplementationGuide.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "ImplementationGuide.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ImplementationGuide.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ImplementationGuide.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ImplementationGuide.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ImplementationGuide.useContext"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "ImplementationGuide.dependsOn.uri"))
  add(SearchParamDefinition("experimental", Enumerations.SearchParamType.TOKEN,
      "ImplementationGuide.experimental"))
  add(SearchParamDefinition("global", Enumerations.SearchParamType.REFERENCE,
      "ImplementationGuide.global.profile"))
  add(SearchParamDefinition("resource", Enumerations.SearchParamType.REFERENCE,
      "ImplementationGuide.definition.resource.reference"))
}

private fun getImagingStudy(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("basedon", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.basedOn"))
  add(SearchParamDefinition("bodysite", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.series.bodySite"))
  add(SearchParamDefinition("dicom-class", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.series.instance.sopClass"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.encounter"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.endpoint | ImagingStudy.series.endpoint"))
  add(SearchParamDefinition("instance", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.series.instance.uid"))
  add(SearchParamDefinition("interpreter", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.interpreter"))
  add(SearchParamDefinition("modality", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.series.modality"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.series.performer.actor"))
  add(SearchParamDefinition("reason", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.reasonCode"))
  add(SearchParamDefinition("referrer", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.referrer"))
  add(SearchParamDefinition("series", Enumerations.SearchParamType.TOKEN,
      "ImagingStudy.series.uid"))
  add(SearchParamDefinition("started", Enumerations.SearchParamType.DATE, "ImagingStudy.started"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ImagingStudy.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "ImagingStudy.subject"))
}

private fun getFamilyMemberHistory(): List<SearchParamDefinition> = buildList(capacity = 9) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "FamilyMemberHistory.condition.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "FamilyMemberHistory.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "FamilyMemberHistory.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "FamilyMemberHistory.patient"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "FamilyMemberHistory.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "FamilyMemberHistory.instantiatesUri"))
  add(SearchParamDefinition("relationship", Enumerations.SearchParamType.TOKEN,
      "FamilyMemberHistory.relationship"))
  add(SearchParamDefinition("sex", Enumerations.SearchParamType.TOKEN, "FamilyMemberHistory.sex"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "FamilyMemberHistory.status"))
}

private fun getChargeItem(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("account", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.account"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "ChargeItem.code"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.context"))
  add(SearchParamDefinition("entered-date", Enumerations.SearchParamType.DATE,
      "ChargeItem.enteredDate"))
  add(SearchParamDefinition("enterer", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.enterer"))
  add(SearchParamDefinition("factor-override", Enumerations.SearchParamType.NUMBER,
      "ChargeItem.factorOverride"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ChargeItem.identifier"))
  add(SearchParamDefinition("occurrence", Enumerations.SearchParamType.DATE,
      "ChargeItem.occurrence"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("performer-actor", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.performer.actor"))
  add(SearchParamDefinition("performer-function", Enumerations.SearchParamType.TOKEN,
      "ChargeItem.performer.function"))
  add(SearchParamDefinition("performing-organization", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.performingOrganization"))
  add(SearchParamDefinition("price-override", Enumerations.SearchParamType.QUANTITY,
      "ChargeItem.priceOverride"))
  add(SearchParamDefinition("quantity", Enumerations.SearchParamType.QUANTITY,
      "ChargeItem.quantity"))
  add(SearchParamDefinition("requesting-organization", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.requestingOrganization"))
  add(SearchParamDefinition("service", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.service"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "ChargeItem.subject"))
}

private fun getResearchElementDefinition(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "ResearchElementDefinition.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ResearchElementDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ResearchElementDefinition.useContext.value as Quantity) | (ResearchElementDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "ResearchElementDefinition.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "ResearchElementDefinition.relatedArtifact.where(type='depends-on').resource | ResearchElementDefinition.library"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "ResearchElementDefinition.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ResearchElementDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "ResearchElementDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "ResearchElementDefinition.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "ResearchElementDefinition.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ResearchElementDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "ResearchElementDefinition.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "ResearchElementDefinition.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI,
      "ResearchElementDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ResearchElementDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ResearchElementDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ResearchElementDefinition.useContext"))
}

private fun getEncounter(): List<SearchParamDefinition> = buildList(capacity = 23) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Encounter.period"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Encounter.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Encounter.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Encounter.type"))
  add(SearchParamDefinition("account", Enumerations.SearchParamType.REFERENCE, "Encounter.account"))
  add(SearchParamDefinition("appointment", Enumerations.SearchParamType.REFERENCE,
      "Encounter.appointment"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "Encounter.basedOn"))
  add(SearchParamDefinition("class", Enumerations.SearchParamType.TOKEN, "Encounter.class"))
  add(SearchParamDefinition("diagnosis", Enumerations.SearchParamType.REFERENCE,
      "Encounter.diagnosis.condition"))
  add(SearchParamDefinition("episode-of-care", Enumerations.SearchParamType.REFERENCE,
      "Encounter.episodeOfCare"))
  add(SearchParamDefinition("length", Enumerations.SearchParamType.QUANTITY, "Encounter.length"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "Encounter.location.location"))
  add(SearchParamDefinition("location-period", Enumerations.SearchParamType.DATE,
      "Encounter.location.period"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE, "Encounter.partOf"))
  add(SearchParamDefinition("participant", Enumerations.SearchParamType.REFERENCE,
      "Encounter.participant.individual"))
  add(SearchParamDefinition("participant-type", Enumerations.SearchParamType.TOKEN,
      "Encounter.participant.type"))
  add(SearchParamDefinition("practitioner", Enumerations.SearchParamType.REFERENCE,
      "Encounter.participant.individual.where(resolve() is Practitioner)"))
  add(SearchParamDefinition("reason-code", Enumerations.SearchParamType.TOKEN,
      "Encounter.reasonCode"))
  add(SearchParamDefinition("reason-reference", Enumerations.SearchParamType.REFERENCE,
      "Encounter.reasonReference"))
  add(SearchParamDefinition("service-provider", Enumerations.SearchParamType.REFERENCE,
      "Encounter.serviceProvider"))
  add(SearchParamDefinition("special-arrangement", Enumerations.SearchParamType.TOKEN,
      "Encounter.hospitalization.specialArrangement"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Encounter.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Encounter.subject"))
}

private fun getSubstance(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Substance.category"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "Substance.code | (Substance.ingredient.substance as CodeableConcept)"))
  add(SearchParamDefinition("container-identifier", Enumerations.SearchParamType.TOKEN,
      "Substance.instance.identifier"))
  add(SearchParamDefinition("expiry", Enumerations.SearchParamType.DATE,
      "Substance.instance.expiry"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Substance.identifier"))
  add(SearchParamDefinition("quantity", Enumerations.SearchParamType.QUANTITY,
      "Substance.instance.quantity"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Substance.status"))
  add(SearchParamDefinition("substance-reference", Enumerations.SearchParamType.REFERENCE,
      "(Substance.ingredient.substance as Reference)"))
}

private fun getSubstanceSpecification(): List<SearchParamDefinition> = buildList(capacity = 1) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "SubstanceSpecification.code.code"))
}

private fun getSearchParameter(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(SearchParameter.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "SearchParameter.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "SearchParameter.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "SearchParameter.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "SearchParameter.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "SearchParameter.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "SearchParameter.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "SearchParameter.status"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "SearchParameter.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "SearchParameter.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "SearchParameter.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "SearchParameter.useContext"))
  add(SearchParamDefinition("base", Enumerations.SearchParamType.TOKEN, "SearchParameter.base"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "SearchParameter.code"))
  add(SearchParamDefinition("component", Enumerations.SearchParamType.REFERENCE,
      "SearchParameter.component.definition"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "SearchParameter.derivedFrom"))
  add(SearchParamDefinition("target", Enumerations.SearchParamType.TOKEN, "SearchParameter.target"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "SearchParameter.type"))
}

private fun getActivityDefinition(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "ActivityDefinition.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ActivityDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ActivityDefinition.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "ActivityDefinition.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ActivityDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "ActivityDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "ActivityDefinition.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "ActivityDefinition.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ActivityDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "ActivityDefinition.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "ActivityDefinition.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ActivityDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ActivityDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ActivityDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ActivityDefinition.useContext"))
}

private fun getCommunication(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "Communication.basedOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "Communication.category"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Communication.encounter"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Communication.identifier"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "Communication.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "Communication.instantiatesUri"))
  add(SearchParamDefinition("medium", Enumerations.SearchParamType.TOKEN, "Communication.medium"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE,
      "Communication.partOf"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Communication.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("received", Enumerations.SearchParamType.DATE,
      "Communication.received"))
  add(SearchParamDefinition("recipient", Enumerations.SearchParamType.REFERENCE,
      "Communication.recipient"))
  add(SearchParamDefinition("sender", Enumerations.SearchParamType.REFERENCE,
      "Communication.sender"))
  add(SearchParamDefinition("sent", Enumerations.SearchParamType.DATE, "Communication.sent"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Communication.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "Communication.subject"))
}

private fun getInsurancePlan(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING,
      "InsurancePlan.contact.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "InsurancePlan.contact.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "InsurancePlan.contact.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "InsurancePlan.contact.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "InsurancePlan.contact.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "InsurancePlan.contact.address.use"))
  add(SearchParamDefinition("administered-by", Enumerations.SearchParamType.REFERENCE,
      "InsurancePlan.administeredBy"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "InsurancePlan.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "InsurancePlan.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "name | alias"))
  add(SearchParamDefinition("owned-by", Enumerations.SearchParamType.REFERENCE,
      "InsurancePlan.ownedBy"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "InsurancePlan.name"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "InsurancePlan.status"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "InsurancePlan.type"))
}

private fun getLinkage(): List<SearchParamDefinition> = buildList(capacity = 3) {
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE, "Linkage.author"))
  add(SearchParamDefinition("item", Enumerations.SearchParamType.REFERENCE,
      "Linkage.item.resource"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "Linkage.item.resource"))
}

private fun getImmunizationEvaluation(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "ImmunizationEvaluation.date"))
  add(SearchParamDefinition("dose-status", Enumerations.SearchParamType.TOKEN,
      "ImmunizationEvaluation.doseStatus"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ImmunizationEvaluation.identifier"))
  add(SearchParamDefinition("immunization-event", Enumerations.SearchParamType.REFERENCE,
      "ImmunizationEvaluation.immunizationEvent"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ImmunizationEvaluation.patient"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ImmunizationEvaluation.status"))
  add(SearchParamDefinition("target-disease", Enumerations.SearchParamType.TOKEN,
      "ImmunizationEvaluation.targetDisease"))
}

private fun getDeviceUseStatement(): List<SearchParamDefinition> = buildList(capacity = 4) {
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DeviceUseStatement.subject"))
  add(SearchParamDefinition("device", Enumerations.SearchParamType.REFERENCE,
      "DeviceUseStatement.device"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DeviceUseStatement.identifier"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "DeviceUseStatement.subject"))
}

private fun getRequestGroup(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.author"))
  add(SearchParamDefinition("authored", Enumerations.SearchParamType.DATE,
      "RequestGroup.authoredOn"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "RequestGroup.code"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.encounter"))
  add(SearchParamDefinition("group-identifier", Enumerations.SearchParamType.TOKEN,
      "RequestGroup.groupIdentifier"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "RequestGroup.identifier"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "RequestGroup.instantiatesUri"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN, "RequestGroup.intent"))
  add(SearchParamDefinition("participant", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.action.participant"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN,
      "RequestGroup.priority"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "RequestGroup.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "RequestGroup.subject"))
}

private fun getDeviceRequest(): List<SearchParamDefinition> = buildList(capacity = 18) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "(DeviceRequest.code as CodeableConcept)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DeviceRequest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.encounter"))
  add(SearchParamDefinition("authored-on", Enumerations.SearchParamType.DATE,
      "DeviceRequest.authoredOn"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.basedOn"))
  add(SearchParamDefinition("device", Enumerations.SearchParamType.REFERENCE,
      "(DeviceRequest.code as Reference)"))
  add(SearchParamDefinition("event-date", Enumerations.SearchParamType.DATE,
      "(DeviceRequest.occurrence as dateTime) | (DeviceRequest.occurrence as Period)"))
  add(SearchParamDefinition("group-identifier", Enumerations.SearchParamType.TOKEN,
      "DeviceRequest.groupIdentifier"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "DeviceRequest.instantiatesUri"))
  add(SearchParamDefinition("insurance", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.insurance"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN, "DeviceRequest.intent"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.performer"))
  add(SearchParamDefinition("prior-request", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.priorRequest"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.requester"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "DeviceRequest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "DeviceRequest.subject"))
}

private fun getMessageHeader(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.author"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "MessageHeader.response.code"))
  add(SearchParamDefinition("destination", Enumerations.SearchParamType.STRING,
      "MessageHeader.destination.name"))
  add(SearchParamDefinition("destination-uri", Enumerations.SearchParamType.URI,
      "MessageHeader.destination.endpoint"))
  add(SearchParamDefinition("enterer", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.enterer"))
  add(SearchParamDefinition("event", Enumerations.SearchParamType.TOKEN, "MessageHeader.event"))
  add(SearchParamDefinition("focus", Enumerations.SearchParamType.REFERENCE, "MessageHeader.focus"))
  add(SearchParamDefinition("receiver", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.destination.receiver"))
  add(SearchParamDefinition("response-id", Enumerations.SearchParamType.TOKEN,
      "MessageHeader.response.identifier"))
  add(SearchParamDefinition("responsible", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.responsible"))
  add(SearchParamDefinition("sender", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.sender"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.STRING,
      "MessageHeader.source.name"))
  add(SearchParamDefinition("source-uri", Enumerations.SearchParamType.URI,
      "MessageHeader.source.endpoint"))
  add(SearchParamDefinition("target", Enumerations.SearchParamType.REFERENCE,
      "MessageHeader.destination.target"))
}

private fun getImmunizationRecommendation(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "ImmunizationRecommendation.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ImmunizationRecommendation.identifier"))
  add(SearchParamDefinition("information", Enumerations.SearchParamType.REFERENCE,
      "ImmunizationRecommendation.recommendation.supportingPatientInformation"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ImmunizationRecommendation.patient"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ImmunizationRecommendation.recommendation.forecastStatus"))
  add(SearchParamDefinition("support", Enumerations.SearchParamType.REFERENCE,
      "ImmunizationRecommendation.recommendation.supportingImmunization"))
  add(SearchParamDefinition("target-disease", Enumerations.SearchParamType.TOKEN,
      "ImmunizationRecommendation.recommendation.targetDisease"))
  add(SearchParamDefinition("vaccine-type", Enumerations.SearchParamType.TOKEN,
      "ImmunizationRecommendation.recommendation.vaccineCode"))
}

private fun getProvenance(): List<SearchParamDefinition> = buildList(capacity = 10) {
  add(SearchParamDefinition("agent", Enumerations.SearchParamType.REFERENCE,
      "Provenance.agent.who"))
  add(SearchParamDefinition("agent-role", Enumerations.SearchParamType.TOKEN,
      "Provenance.agent.role"))
  add(SearchParamDefinition("agent-type", Enumerations.SearchParamType.TOKEN,
      "Provenance.agent.type"))
  add(SearchParamDefinition("entity", Enumerations.SearchParamType.REFERENCE,
      "Provenance.entity.what"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "Provenance.location"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Provenance.target.where(resolve() is Patient)"))
  add(SearchParamDefinition("recorded", Enumerations.SearchParamType.DATE, "Provenance.recorded"))
  add(SearchParamDefinition("signature-type", Enumerations.SearchParamType.TOKEN,
      "Provenance.signature.type"))
  add(SearchParamDefinition("target", Enumerations.SearchParamType.REFERENCE, "Provenance.target"))
  add(SearchParamDefinition("when", Enumerations.SearchParamType.DATE,
      "(Provenance.occurred as dateTime)"))
}

private fun getTask(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("authored-on", Enumerations.SearchParamType.DATE, "Task.authoredOn"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE, "Task.basedOn"))
  add(SearchParamDefinition("business-status", Enumerations.SearchParamType.TOKEN,
      "Task.businessStatus"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Task.code"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE, "Task.encounter"))
  add(SearchParamDefinition("focus", Enumerations.SearchParamType.REFERENCE, "Task.focus"))
  add(SearchParamDefinition("group-identifier", Enumerations.SearchParamType.TOKEN,
      "Task.groupIdentifier"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Task.identifier"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN, "Task.intent"))
  add(SearchParamDefinition("modified", Enumerations.SearchParamType.DATE, "Task.lastModified"))
  add(SearchParamDefinition("owner", Enumerations.SearchParamType.REFERENCE, "Task.owner"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE, "Task.partOf"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Task.for.where(resolve() is Patient)"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.TOKEN, "Task.performerType"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE, "Task.executionPeriod"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN, "Task.priority"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE, "Task.requester"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Task.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Task.for"))
}

private fun getQuestionnaire(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Questionnaire.item.code"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(Questionnaire.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "Questionnaire.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Questionnaire.date"))
  add(SearchParamDefinition("definition", Enumerations.SearchParamType.URI,
      "Questionnaire.item.definition"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "Questionnaire.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "Questionnaire.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Questionnaire.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "Questionnaire.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Questionnaire.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "Questionnaire.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Questionnaire.status"))
  add(SearchParamDefinition("subject-type", Enumerations.SearchParamType.TOKEN,
      "Questionnaire.subjectType"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "Questionnaire.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Questionnaire.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "Questionnaire.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Questionnaire.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "Questionnaire.useContext"))
}

private fun getExplanationOfBenefit(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("care-team", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.careTeam.provider"))
  add(SearchParamDefinition("claim", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.claim"))
  add(SearchParamDefinition("coverage", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.insurance.coverage"))
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE,
      "ExplanationOfBenefit.created"))
  add(SearchParamDefinition("detail-udi", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.item.detail.udi"))
  add(SearchParamDefinition("disposition", Enumerations.SearchParamType.STRING,
      "ExplanationOfBenefit.disposition"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.item.encounter"))
  add(SearchParamDefinition("enterer", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.enterer"))
  add(SearchParamDefinition("facility", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.facility"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ExplanationOfBenefit.identifier"))
  add(SearchParamDefinition("item-udi", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.item.udi"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.patient"))
  add(SearchParamDefinition("payee", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.payee.party"))
  add(SearchParamDefinition("procedure-udi", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.procedure.udi"))
  add(SearchParamDefinition("provider", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.provider"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ExplanationOfBenefit.status"))
  add(SearchParamDefinition("subdetail-udi", Enumerations.SearchParamType.REFERENCE,
      "ExplanationOfBenefit.item.detail.subDetail.udi"))
}

private fun getMedicinalProductPharmaceutical(): List<SearchParamDefinition> = buildList(capacity =
    3) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductPharmaceutical.identifier"))
  add(SearchParamDefinition("route", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductPharmaceutical.routeOfAdministration.code"))
  add(SearchParamDefinition("target-species", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductPharmaceutical.routeOfAdministration.targetSpecies.code"))
}

private fun getResearchStudy(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "ResearchStudy.category"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ResearchStudy.period"))
  add(SearchParamDefinition("focus", Enumerations.SearchParamType.TOKEN, "ResearchStudy.focus"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ResearchStudy.identifier"))
  add(SearchParamDefinition("keyword", Enumerations.SearchParamType.TOKEN, "ResearchStudy.keyword"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.TOKEN,
      "ResearchStudy.location"))
  add(SearchParamDefinition("partof", Enumerations.SearchParamType.REFERENCE,
      "ResearchStudy.partOf"))
  add(SearchParamDefinition("principalinvestigator", Enumerations.SearchParamType.REFERENCE,
      "ResearchStudy.principalInvestigator"))
  add(SearchParamDefinition("protocol", Enumerations.SearchParamType.REFERENCE,
      "ResearchStudy.protocol"))
  add(SearchParamDefinition("site", Enumerations.SearchParamType.REFERENCE, "ResearchStudy.site"))
  add(SearchParamDefinition("sponsor", Enumerations.SearchParamType.REFERENCE,
      "ResearchStudy.sponsor"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ResearchStudy.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "ResearchStudy.title"))
}

private fun getSpecimen(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("accession", Enumerations.SearchParamType.TOKEN,
      "Specimen.accessionIdentifier"))
  add(SearchParamDefinition("bodysite", Enumerations.SearchParamType.TOKEN,
      "Specimen.collection.bodySite"))
  add(SearchParamDefinition("collected", Enumerations.SearchParamType.DATE,
      "Specimen.collection.collected"))
  add(SearchParamDefinition("collector", Enumerations.SearchParamType.REFERENCE,
      "Specimen.collection.collector"))
  add(SearchParamDefinition("container", Enumerations.SearchParamType.TOKEN,
      "Specimen.container.type"))
  add(SearchParamDefinition("container-id", Enumerations.SearchParamType.TOKEN,
      "Specimen.container.identifier"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Specimen.identifier"))
  add(SearchParamDefinition("parent", Enumerations.SearchParamType.REFERENCE, "Specimen.parent"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Specimen.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Specimen.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Specimen.subject"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Specimen.type"))
}

private fun getAllergyIntolerance(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("asserter", Enumerations.SearchParamType.REFERENCE,
      "AllergyIntolerance.asserter"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.category"))
  add(SearchParamDefinition("clinical-status", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.clinicalStatus"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.code | AllergyIntolerance.reaction.substance"))
  add(SearchParamDefinition("criticality", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.criticality"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "AllergyIntolerance.recordedDate"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.identifier"))
  add(SearchParamDefinition("last-date", Enumerations.SearchParamType.DATE,
      "AllergyIntolerance.lastOccurrence"))
  add(SearchParamDefinition("manifestation", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.reaction.manifestation"))
  add(SearchParamDefinition("onset", Enumerations.SearchParamType.DATE,
      "AllergyIntolerance.reaction.onset"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "AllergyIntolerance.patient"))
  add(SearchParamDefinition("recorder", Enumerations.SearchParamType.REFERENCE,
      "AllergyIntolerance.recorder"))
  add(SearchParamDefinition("route", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.reaction.exposureRoute"))
  add(SearchParamDefinition("severity", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.reaction.severity"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "AllergyIntolerance.type"))
  add(SearchParamDefinition("verification-status", Enumerations.SearchParamType.TOKEN,
      "AllergyIntolerance.verificationStatus"))
}

private fun getCarePlan(): List<SearchParamDefinition> = buildList(capacity = 20) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "CarePlan.period"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CarePlan.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("activity-code", Enumerations.SearchParamType.TOKEN,
      "CarePlan.activity.detail.code"))
  add(SearchParamDefinition("activity-date", Enumerations.SearchParamType.DATE,
      "CarePlan.activity.detail.scheduled"))
  add(SearchParamDefinition("activity-reference", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.activity.reference"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE, "CarePlan.basedOn"))
  add(SearchParamDefinition("care-team", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.careTeam"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "CarePlan.category"))
  add(SearchParamDefinition("condition", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.addresses"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.encounter"))
  add(SearchParamDefinition("goal", Enumerations.SearchParamType.REFERENCE, "CarePlan.goal"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "CarePlan.instantiatesUri"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN, "CarePlan.intent"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE, "CarePlan.partOf"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.activity.detail.performer"))
  add(SearchParamDefinition("replaces", Enumerations.SearchParamType.REFERENCE,
      "CarePlan.replaces"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "CarePlan.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "CarePlan.subject"))
}

private fun getStructureDefinition(): List<SearchParamDefinition> = buildList(capacity = 26) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(StructureDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "StructureDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "StructureDefinition.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "StructureDefinition.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "StructureDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "StructureDefinition.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "StructureDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "StructureDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "StructureDefinition.useContext"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.identifier"))
  add(SearchParamDefinition("abstract", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.abstract"))
  add(SearchParamDefinition("base", Enumerations.SearchParamType.REFERENCE,
      "StructureDefinition.baseDefinition"))
  add(SearchParamDefinition("base-path", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.snapshot.element.base.path | StructureDefinition.differential.element.base.path"))
  add(SearchParamDefinition("derivation", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.derivation"))
  add(SearchParamDefinition("experimental", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.experimental"))
  add(SearchParamDefinition("ext-context", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.context.type"))
  add(SearchParamDefinition("keyword", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.keyword"))
  add(SearchParamDefinition("kind", Enumerations.SearchParamType.TOKEN, "StructureDefinition.kind"))
  add(SearchParamDefinition("path", Enumerations.SearchParamType.TOKEN,
      "StructureDefinition.snapshot.element.path | StructureDefinition.differential.element.path"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.URI, "StructureDefinition.type"))
  add(SearchParamDefinition("valueset", Enumerations.SearchParamType.REFERENCE,
      "StructureDefinition.snapshot.element.binding.valueSet"))
}

private fun getEpisodeOfCare(): List<SearchParamDefinition> = buildList(capacity = 9) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "EpisodeOfCare.period"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EpisodeOfCare.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "EpisodeOfCare.patient"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "EpisodeOfCare.type"))
  add(SearchParamDefinition("care-manager", Enumerations.SearchParamType.REFERENCE,
      "EpisodeOfCare.careManager.where(resolve() is Practitioner)"))
  add(SearchParamDefinition("condition", Enumerations.SearchParamType.REFERENCE,
      "EpisodeOfCare.diagnosis.condition"))
  add(SearchParamDefinition("incoming-referral", Enumerations.SearchParamType.REFERENCE,
      "EpisodeOfCare.referralRequest"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "EpisodeOfCare.managingOrganization"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "EpisodeOfCare.status"))
}

private fun getChargeItemDefinition(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ChargeItemDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ChargeItemDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ChargeItemDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ChargeItemDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "ChargeItemDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ChargeItemDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ChargeItemDefinition.jurisdiction"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ChargeItemDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ChargeItemDefinition.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "ChargeItemDefinition.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ChargeItemDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ChargeItemDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ChargeItemDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ChargeItemDefinition.useContext"))
}

private fun getProcedure(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Procedure.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Procedure.performed"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Procedure.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Procedure.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Procedure.encounter"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "Procedure.basedOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Procedure.category"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "Procedure.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "Procedure.instantiatesUri"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "Procedure.location"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE, "Procedure.partOf"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "Procedure.performer.actor"))
  add(SearchParamDefinition("reason-code", Enumerations.SearchParamType.TOKEN,
      "Procedure.reasonCode"))
  add(SearchParamDefinition("reason-reference", Enumerations.SearchParamType.REFERENCE,
      "Procedure.reasonReference"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Procedure.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Procedure.subject"))
}

private fun getList(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "List.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "List.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "List.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "List.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE, "List.encounter"))
  add(SearchParamDefinition("empty-reason", Enumerations.SearchParamType.TOKEN, "List.emptyReason"))
  add(SearchParamDefinition("item", Enumerations.SearchParamType.REFERENCE, "List.entry.item"))
  add(SearchParamDefinition("notes", Enumerations.SearchParamType.STRING, "List.note.text"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE, "List.source"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "List.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "List.subject"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "List.title"))
}

private fun getConceptMap(): List<SearchParamDefinition> = buildList(capacity = 26) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ConceptMap.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ConceptMap.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ConceptMap.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ConceptMap.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ConceptMap.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "ConceptMap.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ConceptMap.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ConceptMap.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "ConceptMap.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ConceptMap.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "ConceptMap.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ConceptMap.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ConceptMap.useContext"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ConceptMap.identifier"))
  add(SearchParamDefinition("dependson", Enumerations.SearchParamType.URI,
      "ConceptMap.group.element.target.dependsOn.property"))
  add(SearchParamDefinition("other", Enumerations.SearchParamType.REFERENCE,
      "ConceptMap.group.unmapped.url"))
  add(SearchParamDefinition("product", Enumerations.SearchParamType.URI,
      "ConceptMap.group.element.target.product.property"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "(ConceptMap.source as canonical)"))
  add(SearchParamDefinition("source-code", Enumerations.SearchParamType.TOKEN,
      "ConceptMap.group.element.code"))
  add(SearchParamDefinition("source-system", Enumerations.SearchParamType.URI,
      "ConceptMap.group.source"))
  add(SearchParamDefinition("source-uri", Enumerations.SearchParamType.REFERENCE,
      "(ConceptMap.source as uri)"))
  add(SearchParamDefinition("target", Enumerations.SearchParamType.REFERENCE,
      "(ConceptMap.target as canonical)"))
  add(SearchParamDefinition("target-code", Enumerations.SearchParamType.TOKEN,
      "ConceptMap.group.element.target.code"))
  add(SearchParamDefinition("target-system", Enumerations.SearchParamType.URI,
      "ConceptMap.group.target"))
  add(SearchParamDefinition("target-uri", Enumerations.SearchParamType.REFERENCE,
      "(ConceptMap.target as uri)"))
}

private fun getOperationDefinition(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(OperationDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "OperationDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "OperationDefinition.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "OperationDefinition.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "OperationDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "OperationDefinition.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "OperationDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "OperationDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "OperationDefinition.useContext"))
  add(SearchParamDefinition("base", Enumerations.SearchParamType.REFERENCE,
      "OperationDefinition.base"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "OperationDefinition.code"))
  add(SearchParamDefinition("input-profile", Enumerations.SearchParamType.REFERENCE,
      "OperationDefinition.inputProfile"))
  add(SearchParamDefinition("instance", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.instance"))
  add(SearchParamDefinition("kind", Enumerations.SearchParamType.TOKEN, "OperationDefinition.kind"))
  add(SearchParamDefinition("output-profile", Enumerations.SearchParamType.REFERENCE,
      "OperationDefinition.outputProfile"))
  add(SearchParamDefinition("system", Enumerations.SearchParamType.TOKEN,
      "OperationDefinition.system"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "OperationDefinition.type"))
}

private fun getValueSet(): List<SearchParamDefinition> = buildList(capacity = 18) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ValueSet.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ValueSet.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ValueSet.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "ValueSet.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ValueSet.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "ValueSet.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING, "ValueSet.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ValueSet.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "ValueSet.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ValueSet.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "ValueSet.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ValueSet.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ValueSet.useContext"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ValueSet.identifier"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "ValueSet.expansion.contains.code | ValueSet.compose.include.concept.code"))
  add(SearchParamDefinition("expansion", Enumerations.SearchParamType.URI,
      "ValueSet.expansion.identifier"))
  add(SearchParamDefinition("reference", Enumerations.SearchParamType.URI,
      "ValueSet.compose.include.system"))
}

private fun getMedicationRequest(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "(MedicationRequest.medication as CodeableConcept)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("medication", Enumerations.SearchParamType.REFERENCE,
      "(MedicationRequest.medication as Reference)"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.status"))
  add(SearchParamDefinition("authoredon", Enumerations.SearchParamType.DATE,
      "MedicationRequest.authoredOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.category"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "MedicationRequest.dosageInstruction.timing.event"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.encounter"))
  add(SearchParamDefinition("intended-dispenser", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.dispenseRequest.performer"))
  add(SearchParamDefinition("intended-performer", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.performer"))
  add(SearchParamDefinition("intended-performertype", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.performerType"))
  add(SearchParamDefinition("intent", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.intent"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN,
      "MedicationRequest.priority"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.requester"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicationRequest.subject"))
}

private fun getImmunization(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Immunization.occurrence"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Immunization.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Immunization.patient"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "Immunization.location"))
  add(SearchParamDefinition("lot-number", Enumerations.SearchParamType.STRING,
      "Immunization.lotNumber"))
  add(SearchParamDefinition("manufacturer", Enumerations.SearchParamType.REFERENCE,
      "Immunization.manufacturer"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "Immunization.performer.actor"))
  add(SearchParamDefinition("reaction", Enumerations.SearchParamType.REFERENCE,
      "Immunization.reaction.detail"))
  add(SearchParamDefinition("reaction-date", Enumerations.SearchParamType.DATE,
      "Immunization.reaction.date"))
  add(SearchParamDefinition("reason-code", Enumerations.SearchParamType.TOKEN,
      "Immunization.reasonCode"))
  add(SearchParamDefinition("reason-reference", Enumerations.SearchParamType.REFERENCE,
      "Immunization.reasonReference"))
  add(SearchParamDefinition("series", Enumerations.SearchParamType.STRING,
      "Immunization.protocolApplied.series"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Immunization.status"))
  add(SearchParamDefinition("status-reason", Enumerations.SearchParamType.TOKEN,
      "Immunization.statusReason"))
  add(SearchParamDefinition("target-disease", Enumerations.SearchParamType.TOKEN,
      "Immunization.protocolApplied.targetDisease"))
  add(SearchParamDefinition("vaccine-code", Enumerations.SearchParamType.TOKEN,
      "Immunization.vaccineCode"))
}

private fun getEffectEvidenceSynthesis(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(EffectEvidenceSynthesis.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(EffectEvidenceSynthesis.useContext.value as Quantity) | (EffectEvidenceSynthesis.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "EffectEvidenceSynthesis.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "EffectEvidenceSynthesis.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "EffectEvidenceSynthesis.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "EffectEvidenceSynthesis.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EffectEvidenceSynthesis.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "EffectEvidenceSynthesis.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "EffectEvidenceSynthesis.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "EffectEvidenceSynthesis.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "EffectEvidenceSynthesis.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "EffectEvidenceSynthesis.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "EffectEvidenceSynthesis.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "EffectEvidenceSynthesis.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "EffectEvidenceSynthesis.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "EffectEvidenceSynthesis.useContext"))
}

private fun getDevice(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("device-name", Enumerations.SearchParamType.STRING,
      "Device.deviceName.name | Device.type.coding.display | Device.type.text"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Device.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE, "Device.location"))
  add(SearchParamDefinition("manufacturer", Enumerations.SearchParamType.STRING,
      "Device.manufacturer"))
  add(SearchParamDefinition("model", Enumerations.SearchParamType.STRING, "Device.modelNumber"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE, "Device.owner"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE, "Device.patient"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Device.status"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Device.type"))
  add(SearchParamDefinition("udi-carrier", Enumerations.SearchParamType.STRING,
      "Device.udiCarrier.carrierHRF"))
  add(SearchParamDefinition("udi-di", Enumerations.SearchParamType.STRING,
      "Device.udiCarrier.deviceIdentifier"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Device.url"))
}

private fun getVisionPrescription(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "VisionPrescription.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "VisionPrescription.patient"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "VisionPrescription.encounter"))
  add(SearchParamDefinition("datewritten", Enumerations.SearchParamType.DATE,
      "VisionPrescription.dateWritten"))
  add(SearchParamDefinition("prescriber", Enumerations.SearchParamType.REFERENCE,
      "VisionPrescription.prescriber"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "VisionPrescription.status"))
}

private fun getResource(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("_id", Enumerations.SearchParamType.TOKEN, "Resource.id"))
  add(SearchParamDefinition("_lastUpdated", Enumerations.SearchParamType.DATE,
      "Resource.meta.lastUpdated"))
  add(SearchParamDefinition("_profile", Enumerations.SearchParamType.URI, "Resource.meta.profile"))
  add(SearchParamDefinition("_security", Enumerations.SearchParamType.TOKEN,
      "Resource.meta.security"))
  add(SearchParamDefinition("_source", Enumerations.SearchParamType.URI, "Resource.meta.source"))
  add(SearchParamDefinition("_tag", Enumerations.SearchParamType.TOKEN, "Resource.meta.tag"))
}

private fun getMedia(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE, "Media.basedOn"))
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE, "Media.created"))
  add(SearchParamDefinition("device", Enumerations.SearchParamType.REFERENCE, "Media.device"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE, "Media.encounter"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Media.identifier"))
  add(SearchParamDefinition("modality", Enumerations.SearchParamType.TOKEN, "Media.modality"))
  add(SearchParamDefinition("operator", Enumerations.SearchParamType.REFERENCE, "Media.operator"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Media.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("site", Enumerations.SearchParamType.TOKEN, "Media.bodySite"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Media.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Media.subject"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Media.type"))
  add(SearchParamDefinition("view", Enumerations.SearchParamType.TOKEN, "Media.view"))
}

private fun getMedicinalProductContraindication(): List<SearchParamDefinition> = buildList(capacity
    = 1) {
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductContraindication.subject"))
}

private fun getEvidenceVariable(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "EvidenceVariable.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(EvidenceVariable.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "EvidenceVariable.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "EvidenceVariable.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "EvidenceVariable.relatedArtifact.where(type='depends-on').resource"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "EvidenceVariable.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "EvidenceVariable.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "EvidenceVariable.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EvidenceVariable.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "EvidenceVariable.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "EvidenceVariable.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "EvidenceVariable.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "EvidenceVariable.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "EvidenceVariable.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "EvidenceVariable.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "EvidenceVariable.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "EvidenceVariable.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "EvidenceVariable.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "EvidenceVariable.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "EvidenceVariable.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "EvidenceVariable.useContext"))
}

private fun getMolecularSequence(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("chromosome", Enumerations.SearchParamType.TOKEN,
      "MolecularSequence.referenceSeq.chromosome"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MolecularSequence.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MolecularSequence.patient"))
  add(SearchParamDefinition("referenceseqid", Enumerations.SearchParamType.TOKEN,
      "MolecularSequence.referenceSeq.referenceSeqId"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "MolecularSequence.type"))
  add(SearchParamDefinition("variant-end", Enumerations.SearchParamType.NUMBER,
      "MolecularSequence.variant.end"))
  add(SearchParamDefinition("variant-start", Enumerations.SearchParamType.NUMBER,
      "MolecularSequence.variant.start"))
  add(SearchParamDefinition("window-end", Enumerations.SearchParamType.NUMBER,
      "MolecularSequence.referenceSeq.windowEnd"))
  add(SearchParamDefinition("window-start", Enumerations.SearchParamType.NUMBER,
      "MolecularSequence.referenceSeq.windowStart"))
  add(SearchParamDefinition("chromosome-variant-coordinate", Enumerations.SearchParamType.COMPOSITE,
      "MolecularSequence.variant"))
  add(SearchParamDefinition("chromosome-window-coordinate", Enumerations.SearchParamType.COMPOSITE,
      "MolecularSequence.referenceSeq"))
  add(SearchParamDefinition("referenceseqid-variant-coordinate",
      Enumerations.SearchParamType.COMPOSITE, "MolecularSequence.variant"))
  add(SearchParamDefinition("referenceseqid-window-coordinate",
      Enumerations.SearchParamType.COMPOSITE, "MolecularSequence.referenceSeq"))
}

private fun getMedicinalProduct(): List<SearchParamDefinition> = buildList(capacity = 3) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicinalProduct.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "MedicinalProduct.name.productName"))
  add(SearchParamDefinition("name-language", Enumerations.SearchParamType.TOKEN,
      "MedicinalProduct.name.countryLanguage.language"))
}

private fun getDeviceMetric(): List<SearchParamDefinition> = buildList(capacity = 5) {
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "DeviceMetric.category"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DeviceMetric.identifier"))
  add(SearchParamDefinition("parent", Enumerations.SearchParamType.REFERENCE,
      "DeviceMetric.parent"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "DeviceMetric.source"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "DeviceMetric.type"))
}

private fun getFlag(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Flag.period"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Flag.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE, "Flag.encounter"))
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE, "Flag.author"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Flag.identifier"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Flag.subject"))
}

private fun getCodeSystem(): List<SearchParamDefinition> = buildList(capacity = 20) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(CodeSystem.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "CodeSystem.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "CodeSystem.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "CodeSystem.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "CodeSystem.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "CodeSystem.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "CodeSystem.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "CodeSystem.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "CodeSystem.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "CodeSystem.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "CodeSystem.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "CodeSystem.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "CodeSystem.useContext"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "CodeSystem.concept.code"))
  add(SearchParamDefinition("content-mode", Enumerations.SearchParamType.TOKEN,
      "CodeSystem.content"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CodeSystem.identifier"))
  add(SearchParamDefinition("language", Enumerations.SearchParamType.TOKEN,
      "CodeSystem.concept.designation.language"))
  add(SearchParamDefinition("supplements", Enumerations.SearchParamType.REFERENCE,
      "CodeSystem.supplements"))
  add(SearchParamDefinition("system", Enumerations.SearchParamType.URI, "CodeSystem.url"))
}

private fun getRiskEvidenceSynthesis(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(RiskEvidenceSynthesis.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(RiskEvidenceSynthesis.useContext.value as Quantity) | (RiskEvidenceSynthesis.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "RiskEvidenceSynthesis.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "RiskEvidenceSynthesis.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "RiskEvidenceSynthesis.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "RiskEvidenceSynthesis.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "RiskEvidenceSynthesis.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "RiskEvidenceSynthesis.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "RiskEvidenceSynthesis.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "RiskEvidenceSynthesis.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "RiskEvidenceSynthesis.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "RiskEvidenceSynthesis.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "RiskEvidenceSynthesis.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "RiskEvidenceSynthesis.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "RiskEvidenceSynthesis.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "RiskEvidenceSynthesis.useContext"))
}

private fun getAppointmentResponse(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("actor", Enumerations.SearchParamType.REFERENCE,
      "AppointmentResponse.actor"))
  add(SearchParamDefinition("appointment", Enumerations.SearchParamType.REFERENCE,
      "AppointmentResponse.appointment"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "AppointmentResponse.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "AppointmentResponse.actor.where(resolve() is Location)"))
  add(SearchParamDefinition("part-status", Enumerations.SearchParamType.TOKEN,
      "AppointmentResponse.participantStatus"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "AppointmentResponse.actor.where(resolve() is Patient)"))
  add(SearchParamDefinition("practitioner", Enumerations.SearchParamType.REFERENCE,
      "AppointmentResponse.actor.where(resolve() is Practitioner)"))
}

private fun getStructureMap(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(StructureMap.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "StructureMap.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "StructureMap.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "StructureMap.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "StructureMap.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "StructureMap.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "StructureMap.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "StructureMap.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "StructureMap.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "StructureMap.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "StructureMap.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "StructureMap.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "StructureMap.useContext"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "StructureMap.identifier"))
}

private fun getAdverseEvent(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("actuality", Enumerations.SearchParamType.TOKEN,
      "AdverseEvent.actuality"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "AdverseEvent.category"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "AdverseEvent.date"))
  add(SearchParamDefinition("event", Enumerations.SearchParamType.TOKEN, "AdverseEvent.event"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "AdverseEvent.location"))
  add(SearchParamDefinition("recorder", Enumerations.SearchParamType.REFERENCE,
      "AdverseEvent.recorder"))
  add(SearchParamDefinition("resultingcondition", Enumerations.SearchParamType.REFERENCE,
      "AdverseEvent.resultingCondition"))
  add(SearchParamDefinition("seriousness", Enumerations.SearchParamType.TOKEN,
      "AdverseEvent.seriousness"))
  add(SearchParamDefinition("severity", Enumerations.SearchParamType.TOKEN,
      "AdverseEvent.severity"))
  add(SearchParamDefinition("study", Enumerations.SearchParamType.REFERENCE, "AdverseEvent.study"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "AdverseEvent.subject"))
  add(SearchParamDefinition("substance", Enumerations.SearchParamType.REFERENCE,
      "AdverseEvent.suspectEntity.instance"))
}

private fun getGuidanceResponse(): List<SearchParamDefinition> = buildList(capacity = 4) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "GuidanceResponse.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "GuidanceResponse.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.TOKEN,
      "GuidanceResponse.requestIdentifier"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "GuidanceResponse.subject"))
}

private fun getObservation(): List<SearchParamDefinition> = buildList(capacity = 38) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Observation.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Observation.effective"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Observation.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Observation.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Observation.encounter"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "Observation.basedOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Observation.category"))
  add(SearchParamDefinition("combo-code", Enumerations.SearchParamType.TOKEN,
      "Observation.code | Observation.component.code"))
  add(SearchParamDefinition("combo-data-absent-reason", Enumerations.SearchParamType.TOKEN,
      "Observation.dataAbsentReason | Observation.component.dataAbsentReason"))
  add(SearchParamDefinition("combo-value-concept", Enumerations.SearchParamType.TOKEN,
      "(Observation.value as CodeableConcept) | (Observation.component.value as CodeableConcept)"))
  add(SearchParamDefinition("combo-value-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Observation.value as Quantity) | (Observation.value as SampledData) | (Observation.component.value as Quantity) | (Observation.component.value as SampledData)"))
  add(SearchParamDefinition("component-code", Enumerations.SearchParamType.TOKEN,
      "Observation.component.code"))
  add(SearchParamDefinition("component-data-absent-reason", Enumerations.SearchParamType.TOKEN,
      "Observation.component.dataAbsentReason"))
  add(SearchParamDefinition("component-value-concept", Enumerations.SearchParamType.TOKEN,
      "(Observation.component.value as CodeableConcept)"))
  add(SearchParamDefinition("component-value-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Observation.component.value as Quantity) | (Observation.component.value as SampledData)"))
  add(SearchParamDefinition("data-absent-reason", Enumerations.SearchParamType.TOKEN,
      "Observation.dataAbsentReason"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "Observation.derivedFrom"))
  add(SearchParamDefinition("device", Enumerations.SearchParamType.REFERENCE, "Observation.device"))
  add(SearchParamDefinition("focus", Enumerations.SearchParamType.REFERENCE, "Observation.focus"))
  add(SearchParamDefinition("has-member", Enumerations.SearchParamType.REFERENCE,
      "Observation.hasMember"))
  add(SearchParamDefinition("method", Enumerations.SearchParamType.TOKEN, "Observation.method"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE,
      "Observation.partOf"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "Observation.performer"))
  add(SearchParamDefinition("specimen", Enumerations.SearchParamType.REFERENCE,
      "Observation.specimen"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Observation.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "Observation.subject"))
  add(SearchParamDefinition("value-concept", Enumerations.SearchParamType.TOKEN,
      "(Observation.value as CodeableConcept)"))
  add(SearchParamDefinition("value-date", Enumerations.SearchParamType.DATE,
      "(Observation.value as dateTime) | (Observation.value as Period)"))
  add(SearchParamDefinition("value-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Observation.value as Quantity) | (Observation.value as SampledData)"))
  add(SearchParamDefinition("value-string", Enumerations.SearchParamType.STRING,
      "(Observation.value as string) | (Observation.value as CodeableConcept).text"))
  add(SearchParamDefinition("code-value-concept", Enumerations.SearchParamType.COMPOSITE,
      "Observation"))
  add(SearchParamDefinition("code-value-date", Enumerations.SearchParamType.COMPOSITE,
      "Observation"))
  add(SearchParamDefinition("code-value-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Observation"))
  add(SearchParamDefinition("code-value-string", Enumerations.SearchParamType.COMPOSITE,
      "Observation"))
  add(SearchParamDefinition("combo-code-value-concept", Enumerations.SearchParamType.COMPOSITE,
      "Observation | Observation.component"))
  add(SearchParamDefinition("combo-code-value-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Observation | Observation.component"))
  add(SearchParamDefinition("component-code-value-concept", Enumerations.SearchParamType.COMPOSITE,
      "Observation.component"))
  add(SearchParamDefinition("component-code-value-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Observation.component"))
}

private fun getMedicationAdministration(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "(MedicationAdministration.medication as CodeableConcept)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicationAdministration.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.context"))
  add(SearchParamDefinition("device", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.device"))
  add(SearchParamDefinition("effective-time", Enumerations.SearchParamType.DATE,
      "MedicationAdministration.effective"))
  add(SearchParamDefinition("medication", Enumerations.SearchParamType.REFERENCE,
      "(MedicationAdministration.medication as Reference)"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.performer.actor"))
  add(SearchParamDefinition("reason-given", Enumerations.SearchParamType.TOKEN,
      "MedicationAdministration.reasonCode"))
  add(SearchParamDefinition("reason-not-given", Enumerations.SearchParamType.TOKEN,
      "MedicationAdministration.statusReason"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.request"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicationAdministration.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicationAdministration.subject"))
}

private fun getEnrollmentResponse(): List<SearchParamDefinition> = buildList(capacity = 3) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "EnrollmentResponse.identifier"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "EnrollmentResponse.request"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "EnrollmentResponse.status"))
}

private fun getLibrary(): List<SearchParamDefinition> = buildList(capacity = 24) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "Library.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("content-type", Enumerations.SearchParamType.TOKEN,
      "Library.content.contentType"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(Library.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Library.useContext.value as Quantity) | (Library.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "Library.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Library.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "Library.relatedArtifact.where(type='depends-on').resource"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "Library.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "Library.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "Library.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Library.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "Library.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Library.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "Library.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING, "Library.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Library.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "Library.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "Library.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "Library.topic"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Library.type"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Library.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "Library.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Library.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "Library.useContext"))
}

private fun getMedicinalProductInteraction(): List<SearchParamDefinition> = buildList(capacity =
    1) {
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductInteraction.subject"))
}

private fun getMedicationStatement(): List<SearchParamDefinition> = buildList(capacity = 11) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "(MedicationStatement.medication as CodeableConcept)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicationStatement.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MedicationStatement.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("medication", Enumerations.SearchParamType.REFERENCE,
      "(MedicationStatement.medication as Reference)"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicationStatement.status"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "MedicationStatement.category"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.REFERENCE,
      "MedicationStatement.context"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "MedicationStatement.effective"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE,
      "MedicationStatement.partOf"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "MedicationStatement.informationSource"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicationStatement.subject"))
}

private fun getCommunicationRequest(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("authored", Enumerations.SearchParamType.DATE,
      "CommunicationRequest.authoredOn"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.basedOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.category"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.encounter"))
  add(SearchParamDefinition("group-identifier", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.groupIdentifier"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.identifier"))
  add(SearchParamDefinition("medium", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.medium"))
  add(SearchParamDefinition("occurrence", Enumerations.SearchParamType.DATE,
      "(CommunicationRequest.occurrence as dateTime)"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.priority"))
  add(SearchParamDefinition("recipient", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.recipient"))
  add(SearchParamDefinition("replaces", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.replaces"))
  add(SearchParamDefinition("requester", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.requester"))
  add(SearchParamDefinition("sender", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.sender"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "CommunicationRequest.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "CommunicationRequest.subject"))
}

private fun getTestScript(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(TestScript.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "TestScript.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "TestScript.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "TestScript.description"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "TestScript.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "TestScript.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "TestScript.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "TestScript.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "TestScript.status"))
  add(SearchParamDefinition("testscript-capability", Enumerations.SearchParamType.STRING,
      "TestScript.metadata.capability.description"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "TestScript.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "TestScript.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "TestScript.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "TestScript.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "TestScript.useContext"))
}

private fun getBasic(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE, "Basic.author"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Basic.code"))
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE, "Basic.created"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Basic.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Basic.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Basic.subject"))
}

private fun getTestReport(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "TestReport.identifier"))
  add(SearchParamDefinition("issued", Enumerations.SearchParamType.DATE, "TestReport.issued"))
  add(SearchParamDefinition("participant", Enumerations.SearchParamType.URI,
      "TestReport.participant.uri"))
  add(SearchParamDefinition("result", Enumerations.SearchParamType.TOKEN, "TestReport.result"))
  add(SearchParamDefinition("tester", Enumerations.SearchParamType.STRING, "TestReport.tester"))
  add(SearchParamDefinition("testscript", Enumerations.SearchParamType.REFERENCE,
      "TestReport.testScript"))
}

private fun getClaimResponse(): List<SearchParamDefinition> = buildList(capacity = 11) {
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE, "ClaimResponse.created"))
  add(SearchParamDefinition("disposition", Enumerations.SearchParamType.STRING,
      "ClaimResponse.disposition"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ClaimResponse.identifier"))
  add(SearchParamDefinition("insurer", Enumerations.SearchParamType.REFERENCE,
      "ClaimResponse.insurer"))
  add(SearchParamDefinition("outcome", Enumerations.SearchParamType.TOKEN, "ClaimResponse.outcome"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ClaimResponse.patient"))
  add(SearchParamDefinition("payment-date", Enumerations.SearchParamType.DATE,
      "ClaimResponse.payment.date"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "ClaimResponse.request"))
  add(SearchParamDefinition("requestor", Enumerations.SearchParamType.REFERENCE,
      "ClaimResponse.requestor"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ClaimResponse.status"))
  add(SearchParamDefinition("use", Enumerations.SearchParamType.TOKEN, "ClaimResponse.use"))
}

private fun getMedicationDispense(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "(MedicationDispense.medication as CodeableConcept)"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicationDispense.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("medication", Enumerations.SearchParamType.REFERENCE,
      "(MedicationDispense.medication as Reference)"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicationDispense.status"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.context"))
  add(SearchParamDefinition("destination", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.destination"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.performer.actor"))
  add(SearchParamDefinition("prescription", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.authorizingPrescription"))
  add(SearchParamDefinition("receiver", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.receiver"))
  add(SearchParamDefinition("responsibleparty", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.substitution.responsibleParty"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicationDispense.subject"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "MedicationDispense.type"))
  add(SearchParamDefinition("whenhandedover", Enumerations.SearchParamType.DATE,
      "MedicationDispense.whenHandedOver"))
  add(SearchParamDefinition("whenprepared", Enumerations.SearchParamType.DATE,
      "MedicationDispense.whenPrepared"))
}

private fun getDiagnosticReport(): List<SearchParamDefinition> = buildList(capacity = 16) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "DiagnosticReport.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "DiagnosticReport.effective"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DiagnosticReport.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.encounter"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.basedOn"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN,
      "DiagnosticReport.category"))
  add(SearchParamDefinition("conclusion", Enumerations.SearchParamType.TOKEN,
      "DiagnosticReport.conclusionCode"))
  add(SearchParamDefinition("issued", Enumerations.SearchParamType.DATE, "DiagnosticReport.issued"))
  add(SearchParamDefinition("media", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.media.link"))
  add(SearchParamDefinition("performer", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.performer"))
  add(SearchParamDefinition("result", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.result"))
  add(SearchParamDefinition("results-interpreter", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.resultsInterpreter"))
  add(SearchParamDefinition("specimen", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.specimen"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "DiagnosticReport.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "DiagnosticReport.subject"))
}

private fun getOrganizationAffiliation(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.active"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "OrganizationAffiliation.period"))
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.telecom.where(system='email')"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.location"))
  add(SearchParamDefinition("network", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.network"))
  add(SearchParamDefinition("participating-organization", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.participatingOrganization"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.telecom.where(system='phone')"))
  add(SearchParamDefinition("primary-organization", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.organization"))
  add(SearchParamDefinition("role", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.code"))
  add(SearchParamDefinition("service", Enumerations.SearchParamType.REFERENCE,
      "OrganizationAffiliation.healthcareService"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.specialty"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN,
      "OrganizationAffiliation.telecom"))
}

private fun getHealthcareService(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.active"))
  add(SearchParamDefinition("characteristic", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.characteristic"))
  add(SearchParamDefinition("coverage-area", Enumerations.SearchParamType.REFERENCE,
      "HealthcareService.coverageArea"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "HealthcareService.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.identifier"))
  add(SearchParamDefinition("location", Enumerations.SearchParamType.REFERENCE,
      "HealthcareService.location"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "HealthcareService.name"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "HealthcareService.providedBy"))
  add(SearchParamDefinition("program", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.program"))
  add(SearchParamDefinition("service-category", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.category"))
  add(SearchParamDefinition("service-type", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.type"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN,
      "HealthcareService.specialty"))
}

private fun getMedicinalProductIndication(): List<SearchParamDefinition> = buildList(capacity = 1) {
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductIndication.subject"))
}

private fun getNutritionOrder(): List<SearchParamDefinition> = buildList(capacity = 12) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "NutritionOrder.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "NutritionOrder.patient"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "NutritionOrder.encounter"))
  add(SearchParamDefinition("additive", Enumerations.SearchParamType.TOKEN,
      "NutritionOrder.enteralFormula.additiveType"))
  add(SearchParamDefinition("datetime", Enumerations.SearchParamType.DATE,
      "NutritionOrder.dateTime"))
  add(SearchParamDefinition("formula", Enumerations.SearchParamType.TOKEN,
      "NutritionOrder.enteralFormula.baseFormulaType"))
  add(SearchParamDefinition("instantiates-canonical", Enumerations.SearchParamType.REFERENCE,
      "NutritionOrder.instantiatesCanonical"))
  add(SearchParamDefinition("instantiates-uri", Enumerations.SearchParamType.URI,
      "NutritionOrder.instantiatesUri"))
  add(SearchParamDefinition("oraldiet", Enumerations.SearchParamType.TOKEN,
      "NutritionOrder.oralDiet.type"))
  add(SearchParamDefinition("provider", Enumerations.SearchParamType.REFERENCE,
      "NutritionOrder.orderer"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "NutritionOrder.status"))
  add(SearchParamDefinition("supplement", Enumerations.SearchParamType.TOKEN,
      "NutritionOrder.supplement.type"))
}

private fun getTerminologyCapabilities(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(TerminologyCapabilities.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "TerminologyCapabilities.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "TerminologyCapabilities.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "TerminologyCapabilities.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "TerminologyCapabilities.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "TerminologyCapabilities.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "TerminologyCapabilities.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "TerminologyCapabilities.status"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING,
      "TerminologyCapabilities.title"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "TerminologyCapabilities.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "TerminologyCapabilities.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "TerminologyCapabilities.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "TerminologyCapabilities.useContext"))
}

private fun getEvidence(): List<SearchParamDefinition> = buildList(capacity = 22) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "Evidence.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(Evidence.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "Evidence.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Evidence.date"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "Evidence.relatedArtifact.where(type='depends-on').resource"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "Evidence.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "Evidence.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "Evidence.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Evidence.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "Evidence.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Evidence.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "Evidence.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING, "Evidence.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Evidence.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "Evidence.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "Evidence.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "Evidence.topic"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "Evidence.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN, "Evidence.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "Evidence.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "Evidence.useContext"))
}

private fun getAuditEvent(): List<SearchParamDefinition> = buildList(capacity = 18) {
  add(SearchParamDefinition("action", Enumerations.SearchParamType.TOKEN, "AuditEvent.action"))
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING,
      "AuditEvent.agent.network.address"))
  add(SearchParamDefinition("agent", Enumerations.SearchParamType.REFERENCE,
      "AuditEvent.agent.who"))
  add(SearchParamDefinition("agent-name", Enumerations.SearchParamType.STRING,
      "AuditEvent.agent.name"))
  add(SearchParamDefinition("agent-role", Enumerations.SearchParamType.TOKEN,
      "AuditEvent.agent.role"))
  add(SearchParamDefinition("altid", Enumerations.SearchParamType.TOKEN, "AuditEvent.agent.altId"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "AuditEvent.recorded"))
  add(SearchParamDefinition("entity", Enumerations.SearchParamType.REFERENCE,
      "AuditEvent.entity.what"))
  add(SearchParamDefinition("entity-name", Enumerations.SearchParamType.STRING,
      "AuditEvent.entity.name"))
  add(SearchParamDefinition("entity-role", Enumerations.SearchParamType.TOKEN,
      "AuditEvent.entity.role"))
  add(SearchParamDefinition("entity-type", Enumerations.SearchParamType.TOKEN,
      "AuditEvent.entity.type"))
  add(SearchParamDefinition("outcome", Enumerations.SearchParamType.TOKEN, "AuditEvent.outcome"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "AuditEvent.agent.who.where(resolve() is Patient) | AuditEvent.entity.what.where(resolve() is Patient)"))
  add(SearchParamDefinition("policy", Enumerations.SearchParamType.URI, "AuditEvent.agent.policy"))
  add(SearchParamDefinition("site", Enumerations.SearchParamType.TOKEN, "AuditEvent.source.site"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "AuditEvent.source.observer"))
  add(SearchParamDefinition("subtype", Enumerations.SearchParamType.TOKEN, "AuditEvent.subtype"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "AuditEvent.type"))
}

private fun getPaymentReconciliation(): List<SearchParamDefinition> = buildList(capacity = 8) {
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE,
      "PaymentReconciliation.created"))
  add(SearchParamDefinition("disposition", Enumerations.SearchParamType.STRING,
      "PaymentReconciliation.disposition"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "PaymentReconciliation.identifier"))
  add(SearchParamDefinition("outcome", Enumerations.SearchParamType.TOKEN,
      "PaymentReconciliation.outcome"))
  add(SearchParamDefinition("payment-issuer", Enumerations.SearchParamType.REFERENCE,
      "PaymentReconciliation.paymentIssuer"))
  add(SearchParamDefinition("request", Enumerations.SearchParamType.REFERENCE,
      "PaymentReconciliation.request"))
  add(SearchParamDefinition("requestor", Enumerations.SearchParamType.REFERENCE,
      "PaymentReconciliation.requestor"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "PaymentReconciliation.status"))
}

private fun getCondition(): List<SearchParamDefinition> = buildList(capacity = 21) {
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "Condition.code"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Condition.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Condition.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("abatement-age", Enumerations.SearchParamType.QUANTITY,
      "Condition.abatement.as(Age) | Condition.abatement.as(Range)"))
  add(SearchParamDefinition("abatement-date", Enumerations.SearchParamType.DATE,
      "Condition.abatement.as(dateTime) | Condition.abatement.as(Period)"))
  add(SearchParamDefinition("abatement-string", Enumerations.SearchParamType.STRING,
      "Condition.abatement.as(string)"))
  add(SearchParamDefinition("asserter", Enumerations.SearchParamType.REFERENCE,
      "Condition.asserter"))
  add(SearchParamDefinition("body-site", Enumerations.SearchParamType.TOKEN, "Condition.bodySite"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Condition.category"))
  add(SearchParamDefinition("clinical-status", Enumerations.SearchParamType.TOKEN,
      "Condition.clinicalStatus"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Condition.encounter"))
  add(SearchParamDefinition("evidence", Enumerations.SearchParamType.TOKEN,
      "Condition.evidence.code"))
  add(SearchParamDefinition("evidence-detail", Enumerations.SearchParamType.REFERENCE,
      "Condition.evidence.detail"))
  add(SearchParamDefinition("onset-age", Enumerations.SearchParamType.QUANTITY,
      "Condition.onset.as(Age) | Condition.onset.as(Range)"))
  add(SearchParamDefinition("onset-date", Enumerations.SearchParamType.DATE,
      "Condition.onset.as(dateTime) | Condition.onset.as(Period)"))
  add(SearchParamDefinition("onset-info", Enumerations.SearchParamType.STRING,
      "Condition.onset.as(string)"))
  add(SearchParamDefinition("recorded-date", Enumerations.SearchParamType.DATE,
      "Condition.recordedDate"))
  add(SearchParamDefinition("severity", Enumerations.SearchParamType.TOKEN, "Condition.severity"))
  add(SearchParamDefinition("stage", Enumerations.SearchParamType.TOKEN, "Condition.stage.summary"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE, "Condition.subject"))
  add(SearchParamDefinition("verification-status", Enumerations.SearchParamType.TOKEN,
      "Condition.verificationStatus"))
}

private fun getSpecimenDefinition(): List<SearchParamDefinition> = buildList(capacity = 3) {
  add(SearchParamDefinition("container", Enumerations.SearchParamType.TOKEN,
      "SpecimenDefinition.typeTested.container.type"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "SpecimenDefinition.identifier"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN,
      "SpecimenDefinition.typeCollected"))
}

private fun getComposition(): List<SearchParamDefinition> = buildList(capacity = 18) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Composition.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Composition.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Composition.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Composition.type"))
  add(SearchParamDefinition("attester", Enumerations.SearchParamType.REFERENCE,
      "Composition.attester.party"))
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE, "Composition.author"))
  add(SearchParamDefinition("category", Enumerations.SearchParamType.TOKEN, "Composition.category"))
  add(SearchParamDefinition("confidentiality", Enumerations.SearchParamType.TOKEN,
      "Composition.confidentiality"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "Composition.event.code"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Composition.encounter"))
  add(SearchParamDefinition("entry", Enumerations.SearchParamType.REFERENCE,
      "Composition.section.entry"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE,
      "Composition.event.period"))
  add(SearchParamDefinition("related-id", Enumerations.SearchParamType.TOKEN,
      "(Composition.relatesTo.target as Identifier)"))
  add(SearchParamDefinition("related-ref", Enumerations.SearchParamType.REFERENCE,
      "(Composition.relatesTo.target as Reference)"))
  add(SearchParamDefinition("section", Enumerations.SearchParamType.TOKEN,
      "Composition.section.code"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Composition.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "Composition.subject"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "Composition.title"))
}

private fun getDetectedIssue(): List<SearchParamDefinition> = buildList(capacity = 6) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DetectedIssue.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "DetectedIssue.patient"))
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "DetectedIssue.author"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "DetectedIssue.code"))
  add(SearchParamDefinition("identified", Enumerations.SearchParamType.DATE,
      "DetectedIssue.identified"))
  add(SearchParamDefinition("implicated", Enumerations.SearchParamType.REFERENCE,
      "DetectedIssue.implicated"))
}

private fun getBundle(): List<SearchParamDefinition> = buildList(capacity = 5) {
  add(SearchParamDefinition("composition", Enumerations.SearchParamType.REFERENCE,
      "Bundle.entry[0].resource"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Bundle.identifier"))
  add(SearchParamDefinition("message", Enumerations.SearchParamType.REFERENCE,
      "Bundle.entry[0].resource"))
  add(SearchParamDefinition("timestamp", Enumerations.SearchParamType.DATE, "Bundle.timestamp"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Bundle.type"))
}

private fun getCompartmentDefinition(): List<SearchParamDefinition> = buildList(capacity = 14) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(CompartmentDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "CompartmentDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE,
      "CompartmentDefinition.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "CompartmentDefinition.description"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "CompartmentDefinition.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "CompartmentDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "CompartmentDefinition.status"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "CompartmentDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "CompartmentDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "CompartmentDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "CompartmentDefinition.useContext"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN,
      "CompartmentDefinition.code"))
  add(SearchParamDefinition("resource", Enumerations.SearchParamType.TOKEN,
      "CompartmentDefinition.resource.code"))
}

private fun getMedicationKnowledge(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("classification", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.medicineClassification.classification"))
  add(SearchParamDefinition("classification-type", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.medicineClassification.type"))
  add(SearchParamDefinition("code", Enumerations.SearchParamType.TOKEN, "MedicationKnowledge.code"))
  add(SearchParamDefinition("doseform", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.doseForm"))
  add(SearchParamDefinition("ingredient", Enumerations.SearchParamType.REFERENCE,
      "(MedicationKnowledge.ingredient.item as Reference)"))
  add(SearchParamDefinition("ingredient-code", Enumerations.SearchParamType.TOKEN,
      "(MedicationKnowledge.ingredient.item as CodeableConcept)"))
  add(SearchParamDefinition("manufacturer", Enumerations.SearchParamType.REFERENCE,
      "MedicationKnowledge.manufacturer"))
  add(SearchParamDefinition("monitoring-program-name", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.monitoringProgram.name"))
  add(SearchParamDefinition("monitoring-program-type", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.monitoringProgram.type"))
  add(SearchParamDefinition("monograph", Enumerations.SearchParamType.REFERENCE,
      "MedicationKnowledge.monograph.source"))
  add(SearchParamDefinition("monograph-type", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.monograph.type"))
  add(SearchParamDefinition("source-cost", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.cost.source"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicationKnowledge.status"))
}

private fun getPatient(): List<SearchParamDefinition> = buildList(capacity = 23) {
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN, "Patient.active"))
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING, "Patient.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "Patient.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "Patient.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "Patient.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "Patient.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "Patient.address.use"))
  add(SearchParamDefinition("birthdate", Enumerations.SearchParamType.DATE, "Patient.birthDate"))
  add(SearchParamDefinition("death-date", Enumerations.SearchParamType.DATE,
      "(Patient.deceased as dateTime)"))
  add(SearchParamDefinition("deceased", Enumerations.SearchParamType.TOKEN,
      "Patient.deceased.exists() and Patient.deceased != false"))
  add(SearchParamDefinition("email", Enumerations.SearchParamType.TOKEN,
      "Patient.telecom.where(system='email')"))
  add(SearchParamDefinition("family", Enumerations.SearchParamType.STRING, "Patient.name.family"))
  add(SearchParamDefinition("gender", Enumerations.SearchParamType.TOKEN, "Patient.gender"))
  add(SearchParamDefinition("general-practitioner", Enumerations.SearchParamType.REFERENCE,
      "Patient.generalPractitioner"))
  add(SearchParamDefinition("given", Enumerations.SearchParamType.STRING, "Patient.name.given"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Patient.identifier"))
  add(SearchParamDefinition("language", Enumerations.SearchParamType.TOKEN,
      "Patient.communication.language"))
  add(SearchParamDefinition("link", Enumerations.SearchParamType.REFERENCE, "Patient.link.other"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "Patient.name"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "Patient.managingOrganization"))
  add(SearchParamDefinition("phone", Enumerations.SearchParamType.TOKEN,
      "Patient.telecom.where(system='phone')"))
  add(SearchParamDefinition("phonetic", Enumerations.SearchParamType.STRING, "Patient.name"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN, "Patient.telecom"))
}

private fun getCoverage(): List<SearchParamDefinition> = buildList(capacity = 11) {
  add(SearchParamDefinition("beneficiary", Enumerations.SearchParamType.REFERENCE,
      "Coverage.beneficiary"))
  add(SearchParamDefinition("class-type", Enumerations.SearchParamType.TOKEN,
      "Coverage.class.type"))
  add(SearchParamDefinition("class-value", Enumerations.SearchParamType.STRING,
      "Coverage.class.value"))
  add(SearchParamDefinition("dependent", Enumerations.SearchParamType.STRING, "Coverage.dependent"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Coverage.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "Coverage.beneficiary"))
  add(SearchParamDefinition("payor", Enumerations.SearchParamType.REFERENCE, "Coverage.payor"))
  add(SearchParamDefinition("policy-holder", Enumerations.SearchParamType.REFERENCE,
      "Coverage.policyHolder"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Coverage.status"))
  add(SearchParamDefinition("subscriber", Enumerations.SearchParamType.REFERENCE,
      "Coverage.subscriber"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Coverage.type"))
}

private fun getQuestionnaireResponse(): List<SearchParamDefinition> = buildList(capacity = 11) {
  add(SearchParamDefinition("author", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.author"))
  add(SearchParamDefinition("authored", Enumerations.SearchParamType.DATE,
      "QuestionnaireResponse.authored"))
  add(SearchParamDefinition("based-on", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.basedOn"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.encounter"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "QuestionnaireResponse.identifier"))
  add(SearchParamDefinition("part-of", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.partOf"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("questionnaire", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.questionnaire"))
  add(SearchParamDefinition("source", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.source"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "QuestionnaireResponse.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "QuestionnaireResponse.subject"))
}

private fun getCoverageEligibilityRequest(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE,
      "CoverageEligibilityRequest.created"))
  add(SearchParamDefinition("enterer", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityRequest.enterer"))
  add(SearchParamDefinition("facility", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityRequest.facility"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "CoverageEligibilityRequest.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityRequest.patient"))
  add(SearchParamDefinition("provider", Enumerations.SearchParamType.REFERENCE,
      "CoverageEligibilityRequest.provider"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "CoverageEligibilityRequest.status"))
}

private fun getNamingSystem(): List<SearchParamDefinition> = buildList(capacity = 19) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(NamingSystem.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "NamingSystem.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "NamingSystem.date"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "NamingSystem.description"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "NamingSystem.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "NamingSystem.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "NamingSystem.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "NamingSystem.status"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "NamingSystem.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "NamingSystem.useContext"))
  add(SearchParamDefinition("contact", Enumerations.SearchParamType.STRING,
      "NamingSystem.contact.name"))
  add(SearchParamDefinition("id-type", Enumerations.SearchParamType.TOKEN,
      "NamingSystem.uniqueId.type"))
  add(SearchParamDefinition("kind", Enumerations.SearchParamType.TOKEN, "NamingSystem.kind"))
  add(SearchParamDefinition("period", Enumerations.SearchParamType.DATE,
      "NamingSystem.uniqueId.period"))
  add(SearchParamDefinition("responsible", Enumerations.SearchParamType.STRING,
      "NamingSystem.responsible"))
  add(SearchParamDefinition("telecom", Enumerations.SearchParamType.TOKEN,
      "NamingSystem.contact.telecom"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "NamingSystem.type"))
  add(SearchParamDefinition("value", Enumerations.SearchParamType.STRING,
      "NamingSystem.uniqueId.value"))
}

private fun getMedicinalProductUndesirableEffect(): List<SearchParamDefinition> = buildList(capacity
    = 1) {
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductUndesirableEffect.subject"))
}

private fun getExampleScenario(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(ExampleScenario.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "ExampleScenario.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ExampleScenario.date"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ExampleScenario.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "ExampleScenario.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "ExampleScenario.name"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "ExampleScenario.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "ExampleScenario.status"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "ExampleScenario.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "ExampleScenario.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "ExampleScenario.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "ExampleScenario.useContext"))
}

private fun getSupplyDelivery(): List<SearchParamDefinition> = buildList(capacity = 5) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "SupplyDelivery.identifier"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "SupplyDelivery.patient"))
  add(SearchParamDefinition("receiver", Enumerations.SearchParamType.REFERENCE,
      "SupplyDelivery.receiver"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "SupplyDelivery.status"))
  add(SearchParamDefinition("supplier", Enumerations.SearchParamType.REFERENCE,
      "SupplyDelivery.supplier"))
}

private fun getSchedule(): List<SearchParamDefinition> = buildList(capacity = 7) {
  add(SearchParamDefinition("active", Enumerations.SearchParamType.TOKEN, "Schedule.active"))
  add(SearchParamDefinition("actor", Enumerations.SearchParamType.REFERENCE, "Schedule.actor"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "Schedule.planningHorizon"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Schedule.identifier"))
  add(SearchParamDefinition("service-category", Enumerations.SearchParamType.TOKEN,
      "Schedule.serviceCategory"))
  add(SearchParamDefinition("service-type", Enumerations.SearchParamType.TOKEN,
      "Schedule.serviceType"))
  add(SearchParamDefinition("specialty", Enumerations.SearchParamType.TOKEN, "Schedule.specialty"))
}

private fun getClinicalImpression(): List<SearchParamDefinition> = buildList(capacity = 13) {
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "ClinicalImpression.date"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.subject.where(resolve() is Patient)"))
  add(SearchParamDefinition("assessor", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.assessor"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.encounter"))
  add(SearchParamDefinition("finding-code", Enumerations.SearchParamType.TOKEN,
      "ClinicalImpression.finding.itemCodeableConcept"))
  add(SearchParamDefinition("finding-ref", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.finding.itemReference"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "ClinicalImpression.identifier"))
  add(SearchParamDefinition("investigation", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.investigation.item"))
  add(SearchParamDefinition("previous", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.previous"))
  add(SearchParamDefinition("problem", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.problem"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "ClinicalImpression.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.subject"))
  add(SearchParamDefinition("supporting-info", Enumerations.SearchParamType.REFERENCE,
      "ClinicalImpression.supportingInfo"))
}

private fun getDeviceDefinition(): List<SearchParamDefinition> = buildList(capacity = 3) {
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "DeviceDefinition.identifier"))
  add(SearchParamDefinition("parent", Enumerations.SearchParamType.REFERENCE,
      "DeviceDefinition.parentDevice"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "DeviceDefinition.type"))
}

private fun getPlanDefinition(): List<SearchParamDefinition> = buildList(capacity = 24) {
  add(SearchParamDefinition("composed-of", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.relatedArtifact.where(type='composed-of').resource"))
  add(SearchParamDefinition("context", Enumerations.SearchParamType.TOKEN,
      "(PlanDefinition.useContext.value as CodeableConcept)"))
  add(SearchParamDefinition("context-quantity", Enumerations.SearchParamType.QUANTITY,
      "(PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range)"))
  add(SearchParamDefinition("context-type", Enumerations.SearchParamType.TOKEN,
      "PlanDefinition.useContext.code"))
  add(SearchParamDefinition("date", Enumerations.SearchParamType.DATE, "PlanDefinition.date"))
  add(SearchParamDefinition("definition", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.action.definition"))
  add(SearchParamDefinition("depends-on", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library"))
  add(SearchParamDefinition("derived-from", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.relatedArtifact.where(type='derived-from').resource"))
  add(SearchParamDefinition("description", Enumerations.SearchParamType.STRING,
      "PlanDefinition.description"))
  add(SearchParamDefinition("effective", Enumerations.SearchParamType.DATE,
      "PlanDefinition.effectivePeriod"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "PlanDefinition.identifier"))
  add(SearchParamDefinition("jurisdiction", Enumerations.SearchParamType.TOKEN,
      "PlanDefinition.jurisdiction"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING, "PlanDefinition.name"))
  add(SearchParamDefinition("predecessor", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.relatedArtifact.where(type='predecessor').resource"))
  add(SearchParamDefinition("publisher", Enumerations.SearchParamType.STRING,
      "PlanDefinition.publisher"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "PlanDefinition.status"))
  add(SearchParamDefinition("successor", Enumerations.SearchParamType.REFERENCE,
      "PlanDefinition.relatedArtifact.where(type='successor').resource"))
  add(SearchParamDefinition("title", Enumerations.SearchParamType.STRING, "PlanDefinition.title"))
  add(SearchParamDefinition("topic", Enumerations.SearchParamType.TOKEN, "PlanDefinition.topic"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "PlanDefinition.type"))
  add(SearchParamDefinition("url", Enumerations.SearchParamType.URI, "PlanDefinition.url"))
  add(SearchParamDefinition("version", Enumerations.SearchParamType.TOKEN,
      "PlanDefinition.version"))
  add(SearchParamDefinition("context-type-quantity", Enumerations.SearchParamType.COMPOSITE,
      "PlanDefinition.useContext"))
  add(SearchParamDefinition("context-type-value", Enumerations.SearchParamType.COMPOSITE,
      "PlanDefinition.useContext"))
}

private fun getMedicinalProductAuthorization(): List<SearchParamDefinition> = buildList(capacity =
    5) {
  add(SearchParamDefinition("country", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductAuthorization.country"))
  add(SearchParamDefinition("holder", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductAuthorization.holder"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductAuthorization.identifier"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN,
      "MedicinalProductAuthorization.status"))
  add(SearchParamDefinition("subject", Enumerations.SearchParamType.REFERENCE,
      "MedicinalProductAuthorization.subject"))
}

private fun getClaim(): List<SearchParamDefinition> = buildList(capacity = 17) {
  add(SearchParamDefinition("care-team", Enumerations.SearchParamType.REFERENCE,
      "Claim.careTeam.provider"))
  add(SearchParamDefinition("created", Enumerations.SearchParamType.DATE, "Claim.created"))
  add(SearchParamDefinition("detail-udi", Enumerations.SearchParamType.REFERENCE,
      "Claim.item.detail.udi"))
  add(SearchParamDefinition("encounter", Enumerations.SearchParamType.REFERENCE,
      "Claim.item.encounter"))
  add(SearchParamDefinition("enterer", Enumerations.SearchParamType.REFERENCE, "Claim.enterer"))
  add(SearchParamDefinition("facility", Enumerations.SearchParamType.REFERENCE, "Claim.facility"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN, "Claim.identifier"))
  add(SearchParamDefinition("insurer", Enumerations.SearchParamType.REFERENCE, "Claim.insurer"))
  add(SearchParamDefinition("item-udi", Enumerations.SearchParamType.REFERENCE, "Claim.item.udi"))
  add(SearchParamDefinition("patient", Enumerations.SearchParamType.REFERENCE, "Claim.patient"))
  add(SearchParamDefinition("payee", Enumerations.SearchParamType.REFERENCE, "Claim.payee.party"))
  add(SearchParamDefinition("priority", Enumerations.SearchParamType.TOKEN, "Claim.priority"))
  add(SearchParamDefinition("procedure-udi", Enumerations.SearchParamType.REFERENCE,
      "Claim.procedure.udi"))
  add(SearchParamDefinition("provider", Enumerations.SearchParamType.REFERENCE, "Claim.provider"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Claim.status"))
  add(SearchParamDefinition("subdetail-udi", Enumerations.SearchParamType.REFERENCE,
      "Claim.item.detail.subDetail.udi"))
  add(SearchParamDefinition("use", Enumerations.SearchParamType.TOKEN, "Claim.use"))
}

private fun getLocation(): List<SearchParamDefinition> = buildList(capacity = 15) {
  add(SearchParamDefinition("address", Enumerations.SearchParamType.STRING, "Location.address"))
  add(SearchParamDefinition("address-city", Enumerations.SearchParamType.STRING,
      "Location.address.city"))
  add(SearchParamDefinition("address-country", Enumerations.SearchParamType.STRING,
      "Location.address.country"))
  add(SearchParamDefinition("address-postalcode", Enumerations.SearchParamType.STRING,
      "Location.address.postalCode"))
  add(SearchParamDefinition("address-state", Enumerations.SearchParamType.STRING,
      "Location.address.state"))
  add(SearchParamDefinition("address-use", Enumerations.SearchParamType.TOKEN,
      "Location.address.use"))
  add(SearchParamDefinition("endpoint", Enumerations.SearchParamType.REFERENCE,
      "Location.endpoint"))
  add(SearchParamDefinition("identifier", Enumerations.SearchParamType.TOKEN,
      "Location.identifier"))
  add(SearchParamDefinition("name", Enumerations.SearchParamType.STRING,
      "Location.name | Location.alias"))
  add(SearchParamDefinition("near", Enumerations.SearchParamType.SPECIAL, "Location.position"))
  add(SearchParamDefinition("operational-status", Enumerations.SearchParamType.TOKEN,
      "Location.operationalStatus"))
  add(SearchParamDefinition("organization", Enumerations.SearchParamType.REFERENCE,
      "Location.managingOrganization"))
  add(SearchParamDefinition("partof", Enumerations.SearchParamType.REFERENCE, "Location.partOf"))
  add(SearchParamDefinition("status", Enumerations.SearchParamType.TOKEN, "Location.status"))
  add(SearchParamDefinition("type", Enumerations.SearchParamType.TOKEN, "Location.type"))
}

/**
 * This File is Generated from com.google.android.fhir.codegen.SearchParameterRepositoryGenerator
 * all changes to this file must be made through the aforementioned file only
 */
internal fun getSearchParamList(resource: Resource): List<SearchParamDefinition> {
  val resourceSearchParams = when (resource.fhirType()) {
    "Appointment" -> getAppointment()
    "Account" -> getAccount()
    "Invoice" -> getInvoice()
    "EventDefinition" -> getEventDefinition()
    "DocumentManifest" -> getDocumentManifest()
    "MessageDefinition" -> getMessageDefinition()
    "Goal" -> getGoal()
    "MedicinalProductPackaged" -> getMedicinalProductPackaged()
    "Endpoint" -> getEndpoint()
    "EnrollmentRequest" -> getEnrollmentRequest()
    "Consent" -> getConsent()
    "Medication" -> getMedication()
    "CapabilityStatement" -> getCapabilityStatement()
    "Measure" -> getMeasure()
    "ResearchSubject" -> getResearchSubject()
    "Subscription" -> getSubscription()
    "DocumentReference" -> getDocumentReference()
    "GraphDefinition" -> getGraphDefinition()
    "CoverageEligibilityResponse" -> getCoverageEligibilityResponse()
    "MeasureReport" -> getMeasureReport()
    "PractitionerRole" -> getPractitionerRole()
    "ServiceRequest" -> getServiceRequest()
    "RelatedPerson" -> getRelatedPerson()
    "SupplyRequest" -> getSupplyRequest()
    "Practitioner" -> getPractitioner()
    "VerificationResult" -> getVerificationResult()
    "BodyStructure" -> getBodyStructure()
    "Slot" -> getSlot()
    "Contract" -> getContract()
    "Person" -> getPerson()
    "RiskAssessment" -> getRiskAssessment()
    "Group" -> getGroup()
    "PaymentNotice" -> getPaymentNotice()
    "ResearchDefinition" -> getResearchDefinition()
    "Organization" -> getOrganization()
    "CareTeam" -> getCareTeam()
    "ImplementationGuide" -> getImplementationGuide()
    "ImagingStudy" -> getImagingStudy()
    "FamilyMemberHistory" -> getFamilyMemberHistory()
    "ChargeItem" -> getChargeItem()
    "ResearchElementDefinition" -> getResearchElementDefinition()
    "Encounter" -> getEncounter()
    "Substance" -> getSubstance()
    "SubstanceSpecification" -> getSubstanceSpecification()
    "SearchParameter" -> getSearchParameter()
    "ActivityDefinition" -> getActivityDefinition()
    "Communication" -> getCommunication()
    "InsurancePlan" -> getInsurancePlan()
    "Linkage" -> getLinkage()
    "ImmunizationEvaluation" -> getImmunizationEvaluation()
    "DeviceUseStatement" -> getDeviceUseStatement()
    "RequestGroup" -> getRequestGroup()
    "DeviceRequest" -> getDeviceRequest()
    "MessageHeader" -> getMessageHeader()
    "ImmunizationRecommendation" -> getImmunizationRecommendation()
    "Provenance" -> getProvenance()
    "Task" -> getTask()
    "Questionnaire" -> getQuestionnaire()
    "ExplanationOfBenefit" -> getExplanationOfBenefit()
    "MedicinalProductPharmaceutical" -> getMedicinalProductPharmaceutical()
    "ResearchStudy" -> getResearchStudy()
    "Specimen" -> getSpecimen()
    "AllergyIntolerance" -> getAllergyIntolerance()
    "CarePlan" -> getCarePlan()
    "StructureDefinition" -> getStructureDefinition()
    "EpisodeOfCare" -> getEpisodeOfCare()
    "ChargeItemDefinition" -> getChargeItemDefinition()
    "Procedure" -> getProcedure()
    "List" -> getList()
    "ConceptMap" -> getConceptMap()
    "OperationDefinition" -> getOperationDefinition()
    "ValueSet" -> getValueSet()
    "MedicationRequest" -> getMedicationRequest()
    "Immunization" -> getImmunization()
    "EffectEvidenceSynthesis" -> getEffectEvidenceSynthesis()
    "Device" -> getDevice()
    "VisionPrescription" -> getVisionPrescription()
    "Resource" -> getResource()
    "Media" -> getMedia()
    "MedicinalProductContraindication" -> getMedicinalProductContraindication()
    "EvidenceVariable" -> getEvidenceVariable()
    "MolecularSequence" -> getMolecularSequence()
    "MedicinalProduct" -> getMedicinalProduct()
    "DeviceMetric" -> getDeviceMetric()
    "Flag" -> getFlag()
    "CodeSystem" -> getCodeSystem()
    "RiskEvidenceSynthesis" -> getRiskEvidenceSynthesis()
    "AppointmentResponse" -> getAppointmentResponse()
    "StructureMap" -> getStructureMap()
    "AdverseEvent" -> getAdverseEvent()
    "GuidanceResponse" -> getGuidanceResponse()
    "Observation" -> getObservation()
    "MedicationAdministration" -> getMedicationAdministration()
    "EnrollmentResponse" -> getEnrollmentResponse()
    "Library" -> getLibrary()
    "MedicinalProductInteraction" -> getMedicinalProductInteraction()
    "MedicationStatement" -> getMedicationStatement()
    "CommunicationRequest" -> getCommunicationRequest()
    "TestScript" -> getTestScript()
    "Basic" -> getBasic()
    "TestReport" -> getTestReport()
    "ClaimResponse" -> getClaimResponse()
    "MedicationDispense" -> getMedicationDispense()
    "DiagnosticReport" -> getDiagnosticReport()
    "OrganizationAffiliation" -> getOrganizationAffiliation()
    "HealthcareService" -> getHealthcareService()
    "MedicinalProductIndication" -> getMedicinalProductIndication()
    "NutritionOrder" -> getNutritionOrder()
    "TerminologyCapabilities" -> getTerminologyCapabilities()
    "Evidence" -> getEvidence()
    "AuditEvent" -> getAuditEvent()
    "PaymentReconciliation" -> getPaymentReconciliation()
    "Condition" -> getCondition()
    "SpecimenDefinition" -> getSpecimenDefinition()
    "Composition" -> getComposition()
    "DetectedIssue" -> getDetectedIssue()
    "Bundle" -> getBundle()
    "CompartmentDefinition" -> getCompartmentDefinition()
    "MedicationKnowledge" -> getMedicationKnowledge()
    "Patient" -> getPatient()
    "Coverage" -> getCoverage()
    "QuestionnaireResponse" -> getQuestionnaireResponse()
    "CoverageEligibilityRequest" -> getCoverageEligibilityRequest()
    "NamingSystem" -> getNamingSystem()
    "MedicinalProductUndesirableEffect" -> getMedicinalProductUndesirableEffect()
    "ExampleScenario" -> getExampleScenario()
    "SupplyDelivery" -> getSupplyDelivery()
    "Schedule" -> getSchedule()
    "ClinicalImpression" -> getClinicalImpression()
    "DeviceDefinition" -> getDeviceDefinition()
    "PlanDefinition" -> getPlanDefinition()
    "MedicinalProductAuthorization" -> getMedicinalProductAuthorization()
    "Claim" -> getClaim()
    "Location" -> getLocation()
    else -> emptyList()
  }
  return resourceSearchParams + getBaseResourceSearchParamsList(resource.fhirType())
}
