package Lap2.Ex3;

public class ElectricLamp {
    private boolean status;
    public ElectricLamp(){
        this.status = false;
    }
    public void turnOff(){
        this.status = false;
    }
    public void turnOn(){
        this.status = true;
    }
}
