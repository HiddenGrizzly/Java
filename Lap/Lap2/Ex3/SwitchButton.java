package Lap2.Ex3;

public class SwitchButton {
    private boolean status;
    private ElectricLamp lamp;
    public SwitchButton(){
        this.status = false;
    }
    public void connectToLamp(ElectricLamp lamp){
        this.lamp = lamp;
    }
    public void switchOff(){
        this.status = false;
        this.lamp.turnOff();
    }
    public void switchOn(){
        this.status = true;
        this.lamp.turnOn();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
