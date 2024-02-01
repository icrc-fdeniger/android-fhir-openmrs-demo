# Purpose
A demo integration project ( No UI) between https://github.com/google/android-fhir and OpenMRS.

Will be used to:
- test integration between android-fhir and OpenMRS: create a patient, create a simple form, synchronize in a local databas
- test connection to OpenMRS using Keycloak or Azure Devops.

# Required configuration
create the file `app/openmrs.properties` whith these lines:

```env
openmrsUser=<a user>
openmrsPwd=<user's pwd>
openmrsUrl=http://<openmrsURL>/openmrs/ws/fhir2/R4/
```

# Other interesting resources to dig into
- https://github.com/opensrp/fhircore
