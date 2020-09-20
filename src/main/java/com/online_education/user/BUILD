load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "user_lib",
    srcs = glob([
        "*.java",
        "command/*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "@maven//:com_amazonaws_aws_lambda_java_core",
        "@maven//:com_amazonaws_aws_lambda_java_events",
        "//:lombok",
        "//src/main/java/com/online_education/dagger:aws_resource_module",
        "//src/main/java/com/online_education/dagger:object_mapper_module",
        "//:dagger_with_errorprone",],
)

java_binary(
    name = "user",
    runtime_deps = [":user_lib"],
)
