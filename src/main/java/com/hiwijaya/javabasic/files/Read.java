package com.hiwijaya.javabasic.files;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Read {

    private static void readFile() {
        String path = "/files/food.txt";
        InputStream inputStream = Read.class.getResourceAsStream(path);

        // New and improved try-with-resources statement in Java 9
        try(inputStream) {
            if(inputStream == null){
                throw new RuntimeException("File not found");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    static void main() {
        readFile();
    }
}
