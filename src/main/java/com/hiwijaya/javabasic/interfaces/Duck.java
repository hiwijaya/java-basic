package com.hiwijaya.javabasic.interfaces;

public class Duck implements Animal, Swimmable, Flyable {

    @Override
    public void eat() {
        System.out.println("Eat grains");
    }

    @Override
    public void walk() {
        System.out.println("with feet");
    }

    @Override
    public String makeSound() {
        return "kwek kwek";
    }

    @Override
    public void fly() {
        System.out.println("Can fly");
    }

    @Override
    public void swim() {
        System.out.println("Can swim");
    }

    static void main() {
        Duck duck = new Duck();
        duck.sleep();
        System.out.println("Duck have wings: " + Duck.haveWings);
    }
}
