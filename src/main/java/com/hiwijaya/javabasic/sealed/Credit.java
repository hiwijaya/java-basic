package com.hiwijaya.javabasic.sealed;

public class Credit extends Card {

    @Override
    public void pay() {
        super.pay();
        System.out.println("Pay with credit card");
    }
}
