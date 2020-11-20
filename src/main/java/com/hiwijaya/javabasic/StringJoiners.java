package com.hiwijaya.javabasic;

import java.util.StringJoiner;

/**
 * @author Happy Indra Wijaya
 */
public class StringJoiners {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("_", "[", "]");
        joiner.add("happy");
        joiner.add("indra");
        joiner.add("wijaya");

        String joined = joiner.toString();
        System.out.println(joined);
    }
}
