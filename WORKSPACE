load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.5"

RULES_JVM_EXTERNAL_SHA = "249e8129914be6d987ca57754516be35a14ea866c616041ff0cd32ea94d2f3a1"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

DAGGER_TAG = "2.28.1"
DAGGER_SHA = "9e69ab2f9a47e0f74e71fe49098bea908c528aa02fa0c5995334447b310d0cdd"
http_archive(
    name = "dagger",
    strip_prefix = "dagger-dagger-%s" % DAGGER_TAG,
    sha256 = DAGGER_SHA,
    urls = ["https://github.com/google/dagger/archive/dagger-%s.zip" % DAGGER_TAG],
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
# dagger setup steps https://github.com/google/dagger
load("@dagger//:workspace_defs.bzl", "DAGGER_ARTIFACTS", "DAGGER_REPOSITORIES")

maven_install(
    artifacts = DAGGER_ARTIFACTS + [
        "junit:junit:4.12",
        "com.google.guava:guava:28.0-jre",
        "com.amazonaws:aws-java-sdk-core:1.11.837",
        "com.amazonaws:aws-java-sdk-dynamodb:1.11.837",
        "com.amazonaws:aws-lambda-java-core:1.2.1",
        "com.fasterxml.jackson.core:jackson-databind:2.11.2",
        "org.mockito:mockito-core:3.5.10",
        "com.google.truth:truth:1.0.1",
        "org.projectlombok:lombok:1.18.12",
        "com.google.errorprone:error_prone_annotations:2.4.0",
        "org.slf4j:slf4j-api:1.7.30",
        "org.slf4j:slf4j-jdk14:2.0.0-alpha1",
    ],
    fetch_sources = True,
    repositories = DAGGER_REPOSITORIES + [
        "http://uk.maven.org/maven2",
        "https://jcenter.bintray.com/",
    ],
)
