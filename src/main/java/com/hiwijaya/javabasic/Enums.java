package com.hiwijaya.javabasic;

// enum is type safe
public class Enums {

    private String name;
    private Gender gender;

    public Enums(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    private static String getHero(Gender gender){
        switch (gender){
            case MALE:
                return "Iron Man";
            case FEMALE:
                return "Black Widow";
            default:
                return "?";
        }
    }


    public static void main(String[] args) {

        Enums happy = new Enums("Happy", Gender.MALE);
        Enums yanna = new Enums("Yanna", Gender.FEMALE);

        Gender genderHappy = happy.getGender();
        System.out.println(genderHappy);    // represented by toString()
        System.out.println(genderHappy.getSymbol());

        System.out.println(Enums.getHero(yanna.getGender()));

        Gender[] genders = Gender.values();
        for(Gender gender : genders){
            System.out.println(gender);
        }

    }

}

enum Gender {

    MALE("M","Male"),
    FEMALE("F", "Female");

    private String symbol;
    private String name;

    Gender(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
}
