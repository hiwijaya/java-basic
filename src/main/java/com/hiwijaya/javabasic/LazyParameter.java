package com.hiwijaya.javabasic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LazyParameter {

    private static ProductService productService = new ProductService();

    // the problem is when we pass method in parameter, it will directly (eager) executed that method.
//    public static Product findOrCreate(String id, Product newProduct){
//        Product product = productService.findById(id);
//        if(product != null){
//            return product;
//        }
//        else{
//            return newProduct;
//        }
//    }

    // with this form, the method will only executed after get() is called
    public static Product findOrCreate(int id, Supplier<Product> newProduct){
        Product product = productService.findById(id);
        if(product != null){
            return product;
        }
        else{
            return newProduct.get();
        }
    }

    public static void main(String[] args) {

        Product product1 = findOrCreate(1, () -> productService.createNewProduct(1));
        System.out.println(product1);

        Product product2 = findOrCreate(2, () -> productService.createNewProduct(2));
        System.out.println(product2);

        Product product1Existed = findOrCreate(1, () -> productService.createNewProduct(1));
        System.out.println(product1Existed);

    }

}

class ProductService {

    private Map<Integer, Product> database = new HashMap<>();

    public Product findById(int id){
        return database.get(id);
    }

    public Product createNewProduct(int id){
        System.out.println("Creating new product");
        Product product = new Product(id, null);
        database.put(id, product);
        return product;
    }

}





