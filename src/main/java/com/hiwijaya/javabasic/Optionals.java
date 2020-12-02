package com.hiwijaya.javabasic;

import java.util.Optional;

public class Optionals {

    public void basicOptional(){

        Optional<Product> emptyOptional = Optional.empty();

        Product product = new Product(1, "Spoon");
        Optional<Product> optional = Optional.of(product);  // of() will directly throw Exception. use ofNullable() instead

        if(optional.isPresent()){
            System.out.println("product isn't null: " + optional.get());
        }

        optional.ifPresent((p) -> System.out.println(p));   // the operation will only be executed if value is not null

    }

    public void nullCheck(){
        Product product = new Product(1,null);

//        String name = product.getName();
//        if(name == null){
//            name = "";
//        }

        String name = Optional.ofNullable(product.getName())
                .orElse("-");

        System.out.println(name);

    }

    public void ifLogic(){
        ProductService service = new ProductService();

//        Product product = service.findById(1);
//        if(product == null){
//            service.createNewProduct(1);
//        }

        Product product = Optional.ofNullable(service.findById(1))
                .orElseGet(() -> service.createNewProduct(1));

        System.out.println(product);

    }

    public void operationToNullValue(){
        Product product = new Product(1, null);

//        String name = product.getName();
//        if(name != null){
//            name = name.toUpperCase();
//        }
//        else{
//            name = "-";
//        }

        String name = Optional.ofNullable(product.getName())
                .map(n -> n.toUpperCase())      // the operation will only be executed if value is not null
                .orElse("-");

        System.out.println(name);

    }

    public void nestedIfChecking(){
        Product product = new Product(1, "Spoon");

//        String country = "Indonesia";
//        if(product.getManufacture() != null){
//            if(product.getManufacture().getCountry() != null){
//                country = product.getManufacture().getCountry();
//            }
//        }

        String country = Optional.ofNullable(product.getManufacture())
                .map(m -> m.getCountry())
                .orElse("Indonesia");

        System.out.println(country);

    }

    public void checkAndThrowException(){
        Product product = new Product(1, null);

//        String name = product.getName();
//        if(name == null){
//            throw new IllegalArgumentException("Name is null");
//        }

        String name = Optional.ofNullable(product.getName())
                .orElseThrow(() -> new IllegalArgumentException("Name is null"));

    }

    public void ifCheckDoSomething(){
        Product product = new Product(1, "Spoon");
        product.setManufacture(new Manufacture("indonesia"));

//        if(product.getManufacture() != null){
//            if(product.getManufacture().getCountry() != null){
//                System.out.println(product.getManufacture().getCountry().toUpperCase());
//            }
//        }

        Optional.ofNullable(product.getManufacture())
                .map(m -> m.getCountry())
                .ifPresent(c -> System.out.println(c.toUpperCase()));

    }

    public void ifFilter(){
        Product product = new Product(1, "Spoon");
        product.setManufacture(new Manufacture("Indonesia"));

//        Long cost = 0L;
//        if(product.getManufacture().getCountry().equals("Indonesia")){
//            cost = 10000L;
//        }
//        else {
//            cost = 200000L;
//        }

        Long cost = Optional.ofNullable(product)
                .filter(p -> p.getManufacture().getCountry().equals("Indonesia"))
                .map(p -> 10000L)
                .orElse(20000L);

        System.out.println(cost);

    }

    public void nestedIfFilter() {
        Product product = new Product(1, "Spoon");
        product.setManufacture(new Manufacture("Indonesia"));

//        Long cost = 0L;
//        if(product.getManufacture().getCountry().equals("Indonesia")){
//            cost = 10000L;
//        }
//        else if(product.getManufacture().getCountry().equals("China")){
//            cost= 8000L;
//        }
//        else {
//            cost = 200000L;
//        }

        Long cost = Optional.of(product).filter(p -> p.getManufacture().getCountry().equals("Indonesia"))
                .map(p -> 10000L).orElseGet(() -> Optional.of(product)
                        .filter(p -> p.getManufacture().getCountry().equals("China"))
                        .map(p -> 8000L)
                        .orElse(20000L));

        System.out.println(cost);
    }


    public static void main(String[] args) {
        Optionals o = new Optionals();
//        o.basicOptional();
//        o.nullCheck();
//        o.ifLogic();
//        o.operationToNullValue();
//        o.nestedIfChecking();
//        o.checkAndThrowException();
//        o.ifCheckDoSomething();
//        o.ifFilter();
        o.nestedIfFilter();

    }

}


