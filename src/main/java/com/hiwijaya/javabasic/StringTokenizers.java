package com.hiwijaya.javabasic;

import java.util.StringTokenizer;

/**
 * @author Happy Indra Wijaya
 */
public class StringTokenizers {

    public static void main(String[] args) {
        String value = "001-20201120-0987654321";

        StringTokenizer tokenizer = new StringTokenizer(value, "-");

        while (tokenizer.hasMoreElements()){
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}
