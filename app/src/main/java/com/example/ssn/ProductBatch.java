package com.example.ssn;

import java.sql.Timestamp;
import java.util.Random;

public class ProductBatch {
    private Timestamp shelf_life;
    private Product prodType;
    private int size;
    private int batchId;

    public ProductBatch(Product product, int size, Timestamp shelf_life){
        this.size = size;
        this.prodType = product;
        this.shelf_life = shelf_life;
        this.batchId = new Random().nextInt(10000);
    }


    public Timestamp getShelf_life() {
        return shelf_life;
    }


    /**
     * Defaults to 1 day product life
     * With empty list
     */
    public ProductBatch(Product product, int size){
        this.shelf_life = new Timestamp(System.currentTimeMillis()+10^3*3600);
    }
}
