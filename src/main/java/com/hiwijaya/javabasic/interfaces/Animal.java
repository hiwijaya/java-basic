package com.hiwijaya.javabasic.interfaces;

public interface Animal {

    void eat();

    void walk();

    String makeSound();

    /**
     * Default Methods in Interfaces.
     * Introduced in Java 8. Add methods to interfaces without breaking implementations.
     */
    default void sleep() {
        System.out.println("sleep");
        this.sleepAtNight();
    }

    /**
     * Private Methods in Interfaces.
     * Introduced in Java 9. Share code between default methods.
     */
    private void sleepAtNight() {
        System.out.println("sleep at night");
    }

}
