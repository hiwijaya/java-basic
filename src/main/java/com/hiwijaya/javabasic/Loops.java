package com.hiwijaya.javabasic;

public class Loops {

    public void forLoop(){
        int n = 10;
        for(int i=0; i<n; i++){
            System.out.println("Iteration-" + i);
        }
    }

    public void whileLoop(){
        boolean searching = true;

        int n = 0;
        while(searching){
            System.out.println("Searching..");
            if(n == 23){
                System.out.println("FOUNDED!");
                searching = false;
            }
            n++;
        }
    }

    public void doWhileLoop(){
        do{
            System.out.println("Current time divide by 3 is not 0");
        }
        while (System.currentTimeMillis() % 2 != 0);
    }

    public static void main(String[] args) {
        Loops l = new Loops();
        l.forLoop();
        l.whileLoop();
        l.doWhileLoop();
    }

}
