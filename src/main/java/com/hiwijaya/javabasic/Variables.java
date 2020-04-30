package com.hiwijaya.javabasic;

import java.util.Arrays;

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

    public void passByValue(String value){
        value = "changing the value";
    }

    // pass by reference if the parameters is reference type like OBJECT or ARRAY.
    public void passByReference(String[] values){
        values[0] = "Changed the first value";
    }

    public static void main(String[] args) {

        // Local Variable -> lives only within the method that declared the variable.
        int width = 20;

        Variables v1;
        v1 = new Variables();
        v1.setName("Happy");
        System.out.println(v1.getName());

        // Reference Variable
        Variables v2 = v1;
        v2.setName("Liam");
        System.out.println(v2.getName());

        System.out.println(v1.getName());

        Variables v = new Variables();

        String value = "This value shouldn'\t be change even inside the method try to changed";
        v.passByValue(value);
        System.out.println(value);

        String[] values = new String[]{"first value", "second value"};
        System.out.println(Arrays.toString(values));
        v.passByReference(values);
        System.out.println(Arrays.toString(values));

    }
}
