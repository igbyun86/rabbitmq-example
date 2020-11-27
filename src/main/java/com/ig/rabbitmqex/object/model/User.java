package com.ig.rabbitmqex.object.model;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String name;
    private int age;

    public User(String id, String name, int age) {
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

/*
    @Override
    public String toString() {
        return "User{" +
                "id='" + id  +
                "', name='" + name  +
                "', age='" + String.valueOf(age) +
                "'}";
    }
*/
}
