package com.hiwijaya.javabasic;


import com.hiwijaya.javabasic.mypackage.MyPackage;

public class Packages {

    public static void main(String[] args) {
        MyPackage myPackage = new MyPackage();
        String uppercase = myPackage.toUppercas("indra bakti");
        System.out.println(uppercase);
    }

}
