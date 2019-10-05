package com.example.ssn;

import java.sql.Timestamp;

public class Product {

    private String name;

    public Product(String name, int id){
        this.name=name;
        this.id=id;
        this.timestamp = new Timestamp(System.currentTimeMillis());

    }

    public Product(String name, int id, Timestamp timestamp) {
        this.name = name;
        this.id = id;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    private int id;
    private Timestamp timestamp;



}
