package com.hiwijaya.javabasic.sealed;

public class SealedExample {

    static void main() {
        Payment payment = new Cash();
        String paidWith = switch (payment){
            case Credit _ -> "Credit Card";     // use _ for unused variables (Java 21)
            case Card _ -> "Card";
            case Cash _ -> "Cash";
        };

        System.out.println(paidWith);
    }
}
