load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "helloworld_lib",
    srcs = glob([
        "*.java",
        "*/*.java"
    ]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "//src/main/java/com/online_education/model",
        "//:dagger_with_errorprone",
        "//src/main/java/com/online_education/server",
    ],
)

java_binary(
    name = "helloworld",
    runtime_deps = ["helloworld_lib"],
)