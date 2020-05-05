package com.hiwijaya.javabasic;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public void createStream(){

        // create an empty Stream (to prevent NUllPointerException)
        Stream<String> emptyStream = Stream.empty();
        System.out.println(emptyStream.count());

        // create Stream from Collections (List, Set)
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> streamList = list.stream();


    }

    public static void main(String[] args) {
        Streams s = new Streams();
        s.createStream();

    }

}

