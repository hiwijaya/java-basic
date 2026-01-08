package com.hiwijaya.javabasic;

public class Conditional {

    public void ifControl(int year) {

        if(year >= 1965 && year <= 1980){
            System.out.println("Gen X");
        }
        else if(year >= 1981 && year <= 1994){
            System.out.println("Millennials");
        }
        else if(year >= 1995 && year <= 2010){
            System.out.println("Gen Z");
        }
        else if(year > 2010){
            System.out.println("Gen Alpha");
        }
        else {
            System.out.println("You are fuckin fossil.");
        }
    }

    /*
    difference between if and switch is switch have 'domino effect'.
    If it finds true conditional once, it will fall-through(execute) the rest of case until it found 'break'.
     */
    public void switchControl(int n){
        switch (n){
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
            default:
                System.out.println("default executed");
        }
    }

    /**
     * Switch Expression (not just statement).
     * Introduced in Java 14.
     * {@code yield} keyword used to produce a value. Like {@code return}, but for switch block only.
     */
    public void updatedSwitchControl(int code){
        String result = switch (code) {
            case 200, 201 -> "OK";
            case 404 -> "NOT FOUND";
            case 500 -> {
                System.out.println("Server error detected");
                yield "INTERNAL SERVER ERROR";
            }
            default -> "UNKNOWN";
        };
        System.out.println(result);
    }

    public void ternaryOperator(String name){
        String greeting = (name.equals("happy")) ? "Hello, Happy!" : "Who are you?";
        System.out.println(greeting);
    }


    public static void main(String[] args) {
        Conditional c = new Conditional();
//        c.ifControl(1998);
//        c.switchControl(3);
        c.updatedSwitchControl(500);
//        c.ternaryOperator("happy");
    }

}
