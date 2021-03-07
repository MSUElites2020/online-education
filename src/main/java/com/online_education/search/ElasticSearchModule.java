package com.online_education.search;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.http.AWSRequestSigningApacheInterceptor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

@Module
public class ElasticSearchModule {
  private static final String HOST_NAME =
      "search-msu-online-education-3-zzuqkmhpgzheba7j5svbg7bwgm.us-east-1.es.amazonaws.com";
  private static final int HOST_PORT = 443;
  private static final String SCHMEME = "https";
  private static final String SERVICE_NAME = "es";
  // TODO to provide region constant via dagger
  private static final String REGION = "us-east-1";
  private static final AWSCredentialsProvider AWS_CREDENTIALS_PROVIDER =
      new DefaultAWSCredentialsProviderChain();

  @Provides
  @Singleton
  RestHighLevelClient restHighLevelClient() {
    AWS4Signer signer = new AWS4Signer();
    signer.setServiceName(SERVICE_NAME);
    signer.setRegionName(REGION);

    RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost(HOST_NAME, HOST_PORT, SCHMEME));

    HttpRequestInterceptor interceptor =
        new AWSRequestSigningApacheInterceptor(SERVICE_NAME, signer, AWS_CREDENTIALS_PROVIDER);
    return new RestHighLevelClient(
        restClientBuilder.setHttpClientConfigCallback(
            httpAsyncClientBuilder -> httpAsyncClientBuilder.addInterceptorLast(interceptor)));
  }
}
