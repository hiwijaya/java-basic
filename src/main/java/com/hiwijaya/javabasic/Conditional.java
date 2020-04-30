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
    If it find true conditional once, it will fall-through(execute) the rest of case until it found 'break'.
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

    public void ternaryOperator(String name){
        String greeting = (name.equals("happy")) ? "Hello, Happy!" : "Who are you?";
        System.out.println(greeting);
    }


    public static void main(String[] args) {
        Conditional c = new Conditional();
        c.ifControl(1998);
        c.switchControl(3);
        c.ternaryOperator("happy");
    }

}
