load("//bazel:junit.bzl", "junit_tests")

junit_tests(
    name = "weather_tests",
    srcs = glob(["*Test.java"]),
    deps = [
        "@maven//:junit_junit",
        "@maven//:com_google_truth_truth",
        "@maven//:org_mockito_mockito_core",
        "//src/main/java/com/online_education/weather:weather_lib",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
    ]
)
