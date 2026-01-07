package com.hiwijaya.javabasic;

import java.util.ArrayList;

/**
 * Local Variable Inference (var).
 * Introduced in Java 10. Type inference is used in var keyword in which it detects automatically
 * the datatype of a variable based on the surrounding context.
 * - var can be used to declare local variable only.
 * - var can't be used without explicit initialization.
 * - it can't be null.
 *
 */
public class Var {

    static void main() {
        var list = new ArrayList<String>();
        list.add("noodle");
        list.add("ramen");
        list.add("spaghetti");

        list.forEach(System.out::println);
    }
}
