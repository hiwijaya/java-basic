package com.hiwijaya.javabasic.sealed;

public class SealedExample {

    static void main() {
        Payment payment = new Cash();
        String paidWith = switch (payment){
            case Credit c -> "Credit Card";
            case Card c -> "Card";
            case Cash c -> "Cash";
        };

        System.out.println(paidWith);
    }
}
