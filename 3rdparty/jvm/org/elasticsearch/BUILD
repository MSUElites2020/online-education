
java_library(
    name = "elasticsearch",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch"
    ],
    runtime_deps = [
        "//3rdparty/jvm/com/carrotsearch:hppc",
        "//3rdparty/jvm/com/tdunning:t_digest",
        "//3rdparty/jvm/joda_time:joda_time",
        "//3rdparty/jvm/org/apache/logging/log4j:log4j_api",
        "//3rdparty/jvm/org/apache/lucene:lucene_analyzers_common",
        "//3rdparty/jvm/org/apache/lucene:lucene_backward_codecs",
        "//3rdparty/jvm/org/apache/lucene:lucene_core",
        "//3rdparty/jvm/org/apache/lucene:lucene_grouping",
        "//3rdparty/jvm/org/apache/lucene:lucene_highlighter",
        "//3rdparty/jvm/org/apache/lucene:lucene_join",
        "//3rdparty/jvm/org/apache/lucene:lucene_memory",
        "//3rdparty/jvm/org/apache/lucene:lucene_misc",
        "//3rdparty/jvm/org/apache/lucene:lucene_queries",
        "//3rdparty/jvm/org/apache/lucene:lucene_queryparser",
        "//3rdparty/jvm/org/apache/lucene:lucene_sandbox",
        "//3rdparty/jvm/org/apache/lucene:lucene_spatial3d",
        "//3rdparty/jvm/org/apache/lucene:lucene_spatial_extras",
        "//3rdparty/jvm/org/apache/lucene:lucene_suggest",
        "//3rdparty/jvm/org/hdrhistogram:HdrHistogram",
        ":elasticsearch_cli",
        ":elasticsearch_core",
        ":elasticsearch_geo",
        ":elasticsearch_secure_sm",
        ":elasticsearch_x_content",
        ":jna"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "elasticsearch_cli",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch_cli"
    ],
    runtime_deps = [
        "//3rdparty/jvm/net/sf/jopt_simple:jopt_simple",
        ":elasticsearch_core"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "elasticsearch_core",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch_core"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "elasticsearch_geo",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch_geo"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "elasticsearch_secure_sm",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch_secure_sm"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "elasticsearch_x_content",
    exports = [
        "//external:jar/org/elasticsearch/elasticsearch_x_content"
    ],
    runtime_deps = [
        "//3rdparty/jvm/com/fasterxml/jackson/core:jackson_core",
        "//3rdparty/jvm/com/fasterxml/jackson/dataformat:jackson_dataformat_cbor",
        "//3rdparty/jvm/com/fasterxml/jackson/dataformat:jackson_dataformat_smile",
        "//3rdparty/jvm/com/fasterxml/jackson/dataformat:jackson_dataformat_yaml",
        "//3rdparty/jvm/org/yaml:snakeyaml",
        ":elasticsearch_core"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)



java_library(
    name = "jna",
    exports = [
        "//external:jar/org/elasticsearch/jna"
    ],
    visibility = [
        "//3rdparty/jvm:__subpackages__"
    ]
)


