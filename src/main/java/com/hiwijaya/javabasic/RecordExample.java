package com.hiwijaya.javabasic;

import java.util.Objects;

/**
 * Record keyword.
 * Introduced in Java 16. Special type of class used as a concise, immutable carrier for data.
 * They significantly reduce the boilerplate code required for data-only classes (often called POJOs or DTOs)
 * by automatically generating essential methods.
 * Automatically generates:
 * - Constructor
 * - equals(), hashCode(), toString()
 * - Getter methods
 */
record Person(String name, int age) {

    public Person {
        Objects.requireNonNull(name, "name is null");
        if (age < 17) throw new IllegalArgumentException("Under age");
    }

    public boolean isElderly(){
        return age >= 50;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class RecordExample {

    static void main() {
        Person person = new Person("John", 18);
        System.out.println(person.name() + " #" + person.age());
    }
}


