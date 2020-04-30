package com.hiwijaya.javabasic;

public class Classes {

    // Nested Class/Inner Class
    class NestedClass {
        void doSomething(){
            System.out.println("This is from inner class.");
        }
    }

    public static void main(String[] args) {
        Classes c = new Classes();

        // to creating object from nested class, it required to instantiate outer class first.
        NestedClass nc = c.new NestedClass();
        nc.doSomething();

        // Anonymous Class. It used for implemented an interface that only used once.
        AnonymousClass ac = new AnonymousClass() {
            public void doSomething() {
                System.out.println("This is from anonymous class.");
            }
        };
        ac.doSomething();

    }
}

// interface
interface AnonymousClass {
    void doSomething();
}
