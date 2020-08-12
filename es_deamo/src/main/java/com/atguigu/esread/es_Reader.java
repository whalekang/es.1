package com.atguigu.esread;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import java.io.IOException;

public class es_Reader {
    public static void main(String[] args) throws IOException {
        JestClientFactory jestClientFactory = new JestClientFactory();

        HttpClientConfig httpClientConfig = new HttpClientConfig
                .Builder("http://hadoop105:9200")
                .build();

        jestClientFactory.setHttpClientConfig(httpClientConfig);
        JestClient jestClient = jestClientFactory.getObject();

        Search search = new Search.Builder("")
                .addIndex("test5")
                .addType("_doc")
                .build();

        SearchResult searchResult = jestClient.execute(search);

        Long total = searchResult.getTotal();
        System.out.println("攻击" +total +"条");
    }
}
