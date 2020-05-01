package com.hiwijaya.javabasic;

public class Inheritance {

    public static void main(String[] args) {

        Car car = new Tesla();          // Polymorphism
        car.setTransmission("automatic");
        car.setFuel("electricity");
        car.drive();
        car.honk();

        Tesla modelX = (Tesla) car;     // Casting
        System.out.println("fuel: " + modelX.getFuel());
        modelX.setSelfDriving(true);
    }

}


class Car {

    private String transmission;
    private String fuel;
    private boolean parkingCam;
    private int productionYear;

    public Car(){
        System.out.println("This is general car.");
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public boolean hasParkingCam() {
        return parkingCam;
    }

    public void setParkingCam(boolean parkingCam) {
        this.parkingCam = parkingCam;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public void drive(){
        System.out.println("Drive");
    }

    public void honk() {
        System.out.println("Telolet!");
    }

}

class Tesla extends Car {

    private boolean selfDriving;

    public Tesla(){
        super();
        System.out.println("This is Tesla!");
    }

    public void setSelfDriving(boolean activated){
        this.selfDriving = activated;
        System.out.println("Self driving active: " + activated);
    }

    public boolean onSelfDrivingMode(){
        return selfDriving;
    }

    @Override
    public void honk(){
        System.out.println("Tetttttt!");
    }

}
