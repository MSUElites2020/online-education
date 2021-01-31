load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "aws_apache_interceptor",
    srcs = ["AWSRequestSigningApacheInterceptor.java"],
    deps = [
        "@maven//:org_apache_httpcomponents_httpclient",
        "@maven//:com_amazonaws_aws_java_sdk_core",
        "@maven//:org_apache_httpcomponents_httpcore",
    ],
    visibility = ["//visibility:public"],
)