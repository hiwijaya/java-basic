package com.hiwijaya.javabasic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class Lambda {

   /*
    * Functional Interfaces
    * - Interface that ONLY HAVE ONE abstract method. It also can have default and static methods.
    * - It used for "passing code into a function"
    * - It also called as SAM (Single Abstract Method)
    * - Always use FI from java.util.function.* first before you want to create your own FI
    *
    */
    public void functionalInterfaces(){

        callFunctionalInterfaces(new MyFunctionalInterface<String>() {
            @Override
            public String execute(String s) {
                return s.toUpperCase();
            }
        });

    }

    public void callFunctionalInterfaces(MyFunctionalInterface<String> fi){
        String name = fi.execute("Happy Indra Wijaya");
        System.out.println(name);
        System.out.println(fi.getPi());
    }

    public void functionalInterfaceToLambda(){

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return Lambda.isNotNull(s);
//            }
//        };

//        Predicate<String> predicate = (s) -> Lambda.isNotNull(s);     // <-- Lambda

        Predicate<String> predicate = Lambda::isNotNull;                // <-- Method Reference
        System.out.println(predicate.test("Happy"));



//        Predicate<String> predicate2 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

//        Predicate<String> predicate2 = (s) -> s.isEmpty();

        Predicate<String> predicate2 = String::isEmpty;
        System.out.println(predicate2.test(""));



//        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>(){
//
//            @Override
//            public boolean test(String a, String b) {
//                return Lambda.isEquals(a, b);
//            }
//        };

//        BiPredicate<String, String> biPredicate = (a, b) -> Lambda.isEquals(a, b);

        BiPredicate<String, String> biPredicate = Lambda::isEquals;
        System.out.println(biPredicate.test("happy", "liam"));


//        String hello = "hello ";
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return hello.concat(s);
//            }
//        };

//        String hello = "hello ";
//        Function<String, String> function = (s) -> hello.concat(s);

        String hello = "hello ";
        Function<String, String> function = hello::concat;
        System.out.println(function.apply("Happy"));



//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

//        Consumer<String> consumer = (s) -> System.out.println(s);

        Consumer<String> consumer = System.out::println;



//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "Happy Indra Wijaya";
//            }
//        };

        Supplier<String> supplier = () -> "Happy Indra Wijaya";
        printLambda(supplier);
        printLambda(() -> "Happy Indra Wijaya");


        // and many more..  to find out please check java.util.function.*

    }

    public void lambdaInCollection(){

        List<String> list = Arrays.asList("Happy", "Indra", "Wijaya");

//        for(String value : list){               // <-- for-loop
//            System.out.println(value);
//        }

//        list.forEach(new Consumer<String>() {   // <-- forEach, new Java 8 features
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        list.forEach((value) -> System.out.println(value));     // <-- Lambda

        list.forEach(System.out::println);      // <-- method reference



        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "Happy");
        map.put("b", "Indra");
        map.put("c", "Wijaya");

//        for(Map.Entry<String, String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }

//        map.forEach(new BiConsumer<String, String>() {
//            @Override
//            public void accept(String key, String value) {
//                System.out.println(key + " - " + value);
//            }
//        });

//        map.forEach((key, value) -> System.out.println(key + " - " + value));

        map.forEach(Lambda::printEntry);

    }



    public static boolean isNotNull(String s){
        return s != null;
    }

    public static boolean isEquals(String a, String b){
        return a.equals(b);
    }

    public static void printEntry(String key, String value){
        System.out.println(key + " - " + value);
    }

    public void printLambda(Supplier<String> supplier){
        System.out.println(supplier.get());
    }



    public static void main(String[] args) {
        Lambda lambda = new Lambda();
//        lambda.functionalInterfaces();
//        lambda.functionalInterfaceToLambda();
        lambda.lambdaInCollection();
    }

}

@FunctionalInterface
interface MyFunctionalInterface<R> {

    R execute(R r);

    /*
    *  Java 8 Features
    * 'default' keyword allow interface to provide an implementation method
    * */
    default double getPi(){
        return 3.14;
    }

}