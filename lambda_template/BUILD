load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "${SERVICE_NAME}_lib",
    srcs = glob([
        "*.java",
        "*/*.java"
    ]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "//src/main/java/com/online_education/model",
        "//:dagger_with_errorprone",
        "//:log",
        "//src/main/java/com/online_education/server",
    ],
)

java_binary(
    name = "${SERVICE_NAME}",
    runtime_deps = ["${SERVICE_NAME}_lib"],
)