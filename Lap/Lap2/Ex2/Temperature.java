package Lap2.Ex2;

public class Temperature {
    private double cTemp;
    public Temperature(){

    }
    public Temperature(double c){
        this.cTemp = c;
    }

    public double getCTemp() {
        return cTemp;
    }

    public void setCTemp(double c) {
        this.cTemp = c;
    }
    public double getFTemp(){
        return (cTemp*9/5)+32;
    }
    public double getKTemp(){
        return (cTemp+273.15);
    }
}
