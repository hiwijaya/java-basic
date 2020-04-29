package com.hiwijaya.javabasic;

public class Variables {

    // Instance Variable -> Bound with the object.
    // lives as long as the object does. If object is still alive, so are its instance variables.
    // The values are unique to each instance of a class.
    private String name;

    // Class Variable -> You want to have variables that are common to all objects.
    // Any object can change the value of a class variable.
    private static int size = 10;

    // Global Variable
    public static final double PI = 3.14;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        // Local Variable -> lives only within the method that declared the variable.
        int width = 20;

    }
}
