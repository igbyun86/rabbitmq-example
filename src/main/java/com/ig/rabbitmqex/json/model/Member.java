package com.ig.rabbitmqex.json.model;

import java.beans.ConstructorProperties;

public class Member {

    private String id;
    private String name;
    private int age;

    @ConstructorProperties({"id", "name", "age"})
    public Member(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
