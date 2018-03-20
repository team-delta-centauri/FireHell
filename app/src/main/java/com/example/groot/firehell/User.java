package com.example.groot.firehell;

/**
 * Created by groot on 17/3/18.
 */

public class User {
    String id;
    String name;

    public User(String id,String name) {
        this.name = name;
        this.id =id ;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
