package com.example.ssn;

import java.sql.Timestamp;
import java.util.List;

public class ProductBatch {
    private Timestamp shelf_life;
    private List<Product> list;

    public ProductBatch(List<Product> products, Timestamp shelf_life){
        list.addAll(products);
        this.shelf_life = shelf_life;
    }


    public Timestamp getShelf_life() {
        return shelf_life;
    }

    public List<Product> getList() {
        return list;
    }

    /**
     * Defaults to 1 day product life
     * With empty list
     */
    public ProductBatch(){
        this.shelf_life = new Timestamp(System.currentTimeMillis()+10^3*3600);
    }
}
