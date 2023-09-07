package Lap2.Ex2;

public class Entry {
    public static void main(String[] args) {
        Temperature temp = new Temperature();
        temp.setCTemp(25);
        System.out.println("F: "+ temp.getFTemp() + "; K: " + temp.getKTemp());
    }
}
