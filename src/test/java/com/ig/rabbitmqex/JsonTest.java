package com.ig.rabbitmqex;

import com.ig.rabbitmqex.json.JsonSender;
import com.ig.rabbitmqex.json.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JsonTest {

    @Autowired
    private JsonSender jsonSender;


    @Test
    public void objectToJsonConverterTest() {

        jsonSender.sendMember(new Member("id1", "tom", 20));
    }


    @Test
    public void mapToJsonConverterTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("hello", "world");
        map.put("kkk", "zzz");

        jsonSender.sendMap(map);
    }
}
