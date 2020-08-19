load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "com.weather-lib",
    srcs = glob(["*.java"]),
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "@maven//:com_fasterxml_jackson_core_jackson_databind"],
)

java_binary(
    name = "com.weather",
    runtime_deps = [":weather-lib"],
)
