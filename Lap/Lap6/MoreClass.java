package Lap6;

public class MoreClass {
    public static void main(String[] args) {
        Object obj1 = new Object();
        System.out.println(obj1);

        Object obj2 = new Object(){
            public String toString(){
                return "this is obj2";
            }
        };
        System.out.println(obj2);
    }
}
