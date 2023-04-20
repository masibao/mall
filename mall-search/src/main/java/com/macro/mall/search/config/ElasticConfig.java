package com.macro.mall.search.config;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Configurable
public class ElasticConfig {

    @Value("${elasticsearch.cluster-nodes}")
    private String clusterNodes;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        String[] esHost = clusterNodes.split(",");
        return new RestHighLevelClient(RestClient.builder(Arrays.stream(esHost).map(this::builderHttpPost).toArray(HttpHost[]::new)));
    }

    private HttpHost builderHttpPost(String node){
        String [] nodes = node.split(":");
        return new HttpHost(nodes[0], Integer.parseInt(nodes[1]),"http");
    }
}
