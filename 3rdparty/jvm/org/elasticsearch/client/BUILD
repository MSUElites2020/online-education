
java_library(
    name = "elasticsearch_rest_client",
    exports = [
        "//external:jar/org/elasticsearch/client/elasticsearch_rest_client"
    ],
    runtime_deps = [
        "//3rdparty/jvm/commons_codec:commons_codec",
        "//3rdparty/jvm/commons_logging:commons_logging",
        "//3rdparty/jvm/org/apache/httpcomponents:httpasyncclient",
        "//3rdparty/jvm/org/apache/httpcomponents:httpclient",
        "//3rdparty/jvm/org/apache/httpcomponents:httpcore",
        "//3rdparty/jvm/org/apache/httpcomponents:httpcore_nio"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "elasticsearch_rest_high_level_client",
    exports = [
        "//external:jar/org/elasticsearch/client/elasticsearch_rest_high_level_client"
    ],
    runtime_deps = [
        "//3rdparty/jvm/org/elasticsearch/plugin:aggs_matrix_stats_client",
        "//3rdparty/jvm/org/elasticsearch/plugin:lang_mustache_client",
        "//3rdparty/jvm/org/elasticsearch/plugin:mapper_extras_client",
        "//3rdparty/jvm/org/elasticsearch/plugin:parent_join_client",
        "//3rdparty/jvm/org/elasticsearch/plugin:rank_eval_client",
        "//3rdparty/jvm/org/elasticsearch:elasticsearch",
        ":elasticsearch_rest_client"
    ],
    visibility = [
        "//visibility:public"
    ]
)


