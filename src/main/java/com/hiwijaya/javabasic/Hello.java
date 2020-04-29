package com.hiwijaya.javabasic;

public class Hello {

    public void hi(String name){
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.hi("Happy");
    }

}
