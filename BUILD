load("@dagger//:workspace_defs.bzl", "dagger_rules")
load("@rules_java//java:defs.bzl", "java_library")

dagger_rules()

# Dagger will build self injection with @CanIgnoreReturnValue which comes from com_google_errorprone_error_prone_annotations
java_library(
    name = "dagger_with_errorprone",
    visibility = ["//visibility:public"],
    exports = [
        "//:dagger",
        "@maven//:com_google_errorprone_error_prone_annotations",]
)
