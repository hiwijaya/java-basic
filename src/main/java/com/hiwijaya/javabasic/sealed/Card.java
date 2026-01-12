package com.hiwijaya.javabasic.sealed;

public non-sealed class Card implements Payment {
    @Override
    public void pay() {
        System.out.println("Paid with card");
    }
}
