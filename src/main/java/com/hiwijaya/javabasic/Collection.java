package com.hiwijaya.javabasic;

import java.util.*;


public class Collection {

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

    // ArrayList is like an array but the size is more flexible
    // + fast random read access
    public void arrayList(){

        Player player1 = new Player(23, "LeBron James");
        Player player2 = new Player(3, "Anthony Davis");
        Player player3 = new Player(9, "Rajon Rondo");
        Player player4 = new Player(4, "Alex Caruso");
        Player player5 = new Player(14, "Danny Green");

        // create an ArrayList object
        // <...> is Generics
        ArrayList<Player> players = new ArrayList<>();

        // add new item
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(1, player4);
        players.add(player5);

        // get item with index
        Player mvp = players.get(1);
        System.out.println(mvp.getName());

        // remove item
//        players.remove(2);
//        players.remove(player3);
        System.out.println(Arrays.toString(players.toArray()));

        // get length/size
        int size = players.size();
        System.out.println(size);

        // sorting wth implement comparable
        Collections.sort(players);

        // iterating with for-loop
        for(Player p : players){
            System.out.println(p.getName() + " #" + p.getNumber());
        }

    }

    // + fast when insert and remove
    public void linkedList() {

        Player player1 = new Player(23, "LeBron James");
        Player player2 = new Player(3, "Anthony Davis");
        Player player3 = new Player(9, "Rajon Rondo");
        Player player4 = new Player(4, "Alex Caruso");
        Player player5 = new Player(14, "Danny Green");

        LinkedList<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        players.addFirst(player5);
        players.addLast(player4);
        System.out.println(Arrays.toString(players.toArray()));

        players.removeFirst();
        System.out.println(Arrays.toString(players.toArray()));

    }

    // Map is collection with key-value pair
    public void map(){
        Player player1 = new Player(23, "LeBron James");
        Player player2 = new Player(3, "Anthony Davis");
        Player player3 = new Player(9, "Rajon Rondo");

        // create Map object with String as key, Player as value defined in Generic
        Map<String, Player> players = new HashMap<>();
        players.put("PG", player3);
        players.put("SF", player1);
        players.put("PF", player2);

        // get value by key
        Player sf = players.get("SF");
        System.out.println(sf);

        // get all keys
        Set<String> keys = players.keySet();
        System.out.println(keys);

        // iterating all values
        Iterator<String> i =keys.iterator();
        while (i.hasNext()){
            String key = i.next();
            Player p = players.get(key);
            System.out.println(p);
        }
    }

    // set is a UNIQUE collection.
    // to implement unique, you must override equals() and hashcode()
    public void set(){
        Player player1 = new Player(23, "LeBron James");
        Player player2 = new Player(3, "Anthony Davis");
        Player playerA = new Player(23, "LeBron James");

        // HashSet is UNORDERED | use TreeMap/TreeSet if you want ORDERED list
        Set<Player> players = new HashSet<>();
        players.add(player1);
        players.add(player2);
        players.add(playerA);   // detect as duplicate. Value will be ignored

        // Default Set in Java doesn't provide "get" function

        Iterator<Player> i = players.iterator();
        while (i.hasNext()){
            Player p = i.next();
            System.out.println("Hash: " + p.hashCode() + " - " + p.getName());
        }
    }

    public void sorting(){
        Player player1 = new Player(23, "LeBron James");
        Player player2 = new Player(3, "Anthony Davis");
        Player player3 = new Player(9, "Rajon Rondo");
        Player player4 = new Player(4, "Alex Caruso");
        Player player5 = new Player(14, "Danny Green");


        Set<Player> players = new TreeSet<>();
//        Set<Player> players = new TreeSet<>(new PlayerComparator());    // using custom Comparator class
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

        System.out.println(players.toString());

    }


    public static void main(String[] args) {
        Collection c = new Collection();
//        c.array();
//        c.arrayList();
//        c.linkedList();
//        c.map();
//        c.set();
        c.sorting();

    }

}

class Player implements Comparable<Player> {

    public Player(int number, String name){
        this.number = number;
        this.name = name;
    }

    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;
        return number == player.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.name);  // sorted asc
    }

}

class PlayerComparator implements Comparator<Player>{

    @Override
    public int compare(Player player1, Player player2) {
        return player2.getNumber() - player1.getNumber();   // sorted by number desc
    }

}
