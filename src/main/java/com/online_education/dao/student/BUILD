load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "student",
    visibility = ["//visibility:public"],
    srcs = glob(["*.java"]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "//:dagger_with_errorprone",
        "//:lombok",
    ],
)