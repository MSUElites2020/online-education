load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "weather_lib",
    srcs = glob([
        "*.java",
        "command/*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "//:lombok",
        "//src/main/java/com/online_education/dagger:dynamodb_module",
        "//src/main/java/com/online_education/dagger:object_mapper_module",
        "//src/main/java/com/online_education/model",
        "//:dagger_with_errorprone",
        "//:log",
       ],
)

java_binary(
    name = "weather",
    runtime_deps = [":weather_lib"],
)
