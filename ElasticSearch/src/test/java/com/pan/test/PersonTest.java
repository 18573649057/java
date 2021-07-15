package com.pan.test;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class PersonTest {
    @Autowired
    private RestHighLevelClient client;

    //添加索引
    @Test
    void addIndex() throws IOException {
        IndicesClient client = this.client.indices();
        CreateIndexRequest indexrequest = new CreateIndexRequest("panpan2");
        CreateIndexResponse response = client.create(indexrequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());

    }

    @Test
    public void queryIndex() throws IOException {
        IndicesClient indices = client.indices();

        GetIndexRequest getReqeust = new GetIndexRequest("panpan");
        GetIndexResponse response = indices.get(getReqeust, RequestOptions.DEFAULT);


        //获取结果
        Map<String, MappingMetaData> mappings = response.getMappings();
        for (String key : mappings.keySet()) {
            System.out.println(key + ":" + mappings.get(key).getSourceAsMap());

        }

    }

    //删除索引
    @Test
    public void delete() throws IOException {
        IndicesClient indices = client.indices();

        DeleteIndexRequest deletequest = new DeleteIndexRequest("panpan");
        AcknowledgedResponse response = indices.delete(deletequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());

    }


    //判断索引
    @Test
    public void exist() throws IOException {
        IndicesClient indices = client.indices();
        GetIndexRequest getrequest = new GetIndexRequest("panpan2");
        boolean b = indices.exists(getrequest, RequestOptions.DEFAULT);
        System.out.println(b);

    }

    //添加数据
    @Test
    public void addDoc() throws IOException {

        HashMap map = new HashMap();
        map.put("name","pzl");
        map.put("age",18);
        map.put("address","信阳");

        IndexRequest indextrequest = new IndexRequest("pzl").id("1").source(map);
        IndexResponse index = client.index(indextrequest, RequestOptions.DEFAULT);
        System.out.println(index.getId());
    }
}
