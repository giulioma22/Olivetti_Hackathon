package com.example.ssn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static List<Product> getProductTypes(){

        List<Product> prods = new ArrayList<>();
        prods.add(new Product("Baguette", new Random().nextInt()));
        prods.add(new Product("Flat Bread", new Random().nextInt()));
        prods.add( new Product("Brioche", new Random().nextInt()));
        prods.add(new Product("Polenta", new Random().nextInt()));
        prods.add(new Product("Panini", new Random().nextInt()));

        return prods;
    }


    public static List<ProductBatch> getProductBatches(){
        List<ProductBatch> batches = new ArrayList<>();

        for(int i=0;i<3; i++){
            for(Product p : getProductTypes()){
                batches.add(new ProductBatch(p, (new Random()).nextInt(15)));
            }
        }

        return batches;
    }


}
