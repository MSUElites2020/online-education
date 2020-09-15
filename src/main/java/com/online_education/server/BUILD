load("@rules_java//java:defs.bzl", "java_library")

java_binary(
    name = "server",
    visibility = ["//visibility:public"],
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/java/com/online_education/model",
    ],
)