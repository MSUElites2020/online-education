package com.online_education.dagger.AWSResourceModule;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

@Module
public class ElasticSearchModule {
  @Provides
  @Singleton
  RestHighLevelClient restHighLevelClient() {
    return new RestHighLevelClient(
        RestClient.builder(
            new HttpHost(
                "search-msu-online-education-2-tnjwcrvx7dbwbmolrw6za44fru.us-east-1.es.amazonaws.com", 443, "https")));
  }
}
