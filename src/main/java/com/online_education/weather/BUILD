load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "weather_lib",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:org_projectlombok_lombok",],
)

java_binary(
    name = "weather",
    runtime_deps = [":weather_lib"],
)
