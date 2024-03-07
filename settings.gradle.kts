rootProject.name = "spring-boot-frameworks"

include(
    "telemetry",
    "error-handling",
    "authentication",
    "authorization"
)

project(":telemetry").name = "spring-boot-telemetry-framework"
project(":error-handling").name = "spring-boot-error-handling-framework"
project(":authentication").name = "spring-boot-authentication-framework"
project(":authorization").name = "spring-boot-authorization-framework"
