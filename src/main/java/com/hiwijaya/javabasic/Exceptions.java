package com.hiwijaya.javabasic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exceptions {

    public void tryCatch(){
        try{
            String price = "10,000";
            System.out.println(Integer.parseInt(price));    // Will raise NumberFormatException.
        }
        catch (NumberFormatException ex){
            System.out.println("Handled by specific exception.");
            ex.printStackTrace();
        }
        catch (Exception ex){
            System.out.println("Handled by global exception.");
            ex.printStackTrace();
        }
        finally {
            System.out.println("This block will always executed if an error has raised.");
        }
    }

    // this method won't handle the exception and choose to throws to the method caller.
    public void irresponsibleMethod() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("file.txt");
    }

    public void customException(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Age is under 18");
        }
    }


    public static void main(String[] args) {
        Exceptions e = new Exceptions();
        e.tryCatch();

        try {
            e.irresponsibleMethod();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            e.customException(16);
        } catch (InvalidAgeException ex) {
            System.out.println("Error message: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}

// custom exception
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }

}
