load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "user_lib",
    srcs = glob([
        "*.java",
        "*/*.java"
    ]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:com_amazonaws_aws_lambda_java_core",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "@maven//:com_amazonaws_aws_lambda_java_events",
        "//src/main/java/com/online_education/model",
        "//:dagger_with_errorprone",
        "//src/main/java/com/online_education/server",
        "//src/main/java/com/online_education/dagger:aws_resource_module",
        "//src/main/java/com/online_education/dagger:object_mapper_module",
        "//src/main/java/com/online_education/dao/student",
        "//:log",
        "//:lombok",
    ],
)

java_binary(
    name = "user",
    runtime_deps = ["user_lib"],
)
