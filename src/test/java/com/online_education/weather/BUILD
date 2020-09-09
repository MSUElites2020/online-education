load("@rules_java//java:defs.bzl", "java_binary", "java_test")

java_test(
    name = "weather_tests",
    size = "small",
    srcs = glob(["*.java"]),
    test_class = "com.online_education.weather.WeatherEventLambdaTest",
    deps = [
        "@maven//:junit_junit",
        "@maven//:com_google_truth_truth",
        "@maven//:org_mockito_mockito_core",
        "//src/main/java/com/online_education/weather:weather_lib",
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
    ]
)
