load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "hello_world_lib",
    srcs = glob([
        "*.java",
        "*/*.java"
    ]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "//src/main/java/com/online_education/model",
        "//:dagger_with_errorprone",
    ],
)

java_binary(
    name = "hello_world",
    runtime_deps = ["hello_world_lib"],
)