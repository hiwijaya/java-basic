package com.hiwijaya.javabasic;

public class Methods extends OverridingMethod {

    // Constructor
    Methods(){
        System.out.println("This is Methods Constructor.");
    }

    // Method with return value (also static method).
    public static double getPi(){
        return 3.14;
    }

    // Overriding Method. Redefine the parent method.
    @Override
    public void greeting(String name) {
        //super.greeting(name);
        System.out.println("Hi, " + name);
    }

    // Void method
    public void calculateCircle(double radius){
        double area = Methods.getPi() * Math.pow(radius, 2);   // a = pi * r^2
        System.out.println("Area = " + String.valueOf(area));   // valueOf() -> convert to String
    }

    // Overloading Method. Methods with identical name but different variables.
    public void setAddress(String street, String city){
        this.setAddress(street, city, "[unknown zipcode]");
    }

    public void setAddress(String street, String city, String zipcode){
        System.out.println(street + ' ' + city + ' ' + zipcode);
    }

    public static void main(String[] args) {
        Methods m = new Methods();
        m.calculateCircle(4);
        m.setAddress("JL Purimas I", "Jakarta Timur");

        double pi = getPi();    // you can directly call static method only inside static method

        OverridingMethod om = new OverridingMethod();
        om.greeting("Happy");
        m.greeting("Liam");

    }

}

class OverridingMethod {

    public void greeting(String name){
        System.out.println("Hello, " + name);
    }

}
