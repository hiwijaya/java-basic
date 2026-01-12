package com.hiwijaya.javabasic.sealed;

public final class Cash implements Payment{
    @Override
    public void pay() {
        System.out.println("Paid with cash");
    }
}
