package com.hiwijaya.javabasic;

import java.util.ArrayList;
import java.util.Arrays;

public class Collections {

    public void array(){
        // init an array within the values. | String[] teams = new String[5];
        String[] team = {"Avery Bradley", "Danny Green", "LeBron James", "Anthony Davis", "JaVale McGee"};

        // accessing an array with index
        String sf = team[2];
        System.out.println("Small Forward: " + sf);

        // changing array value
        team[0] = "Rajon Rondo";

        // iterating an array
        for(String player : team){
            System.out.println(player);
        }

        // Java.util.Arrays
        // 1. print an array
        System.out.println(Arrays.toString(team));

        // 2. create an ArrayList from array
        ArrayList<String> teamList = new ArrayList<String>(Arrays.asList(team));
        System.out.println(teamList);

        // 3.Check if an array contains a certain value
        boolean exist = Arrays.asList(team).contains("LeBron James");
        System.out.println("LeBron in the first team: " + exist);

        // 4. copyOf used for copy part of/entire array with new length (create new object array)
        String[] fullTeam = Arrays.copyOf(team, 7);
        System.out.println(Arrays.toString(fullTeam));

        // 5. copyOfRange copy an array based on index
        String[] bestPLayer = Arrays.copyOfRange(team, 1, 4);
        System.out.println("Best player: " + Arrays.toString(bestPLayer));

    }


    public static void main(String[] args) {
        Collections c = new Collections();
        c.array();

    }

}
