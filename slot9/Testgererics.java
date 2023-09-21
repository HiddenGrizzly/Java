//Run test neneri
package Slot9;

public class Testgererics {
    public static void main(String[] args){
        MyGreneri<Integer> m1 = new MyGreneri<>();
        m1.add(2);
        System.out.println(m1.get());

        MyGreneri<String> m2 = new MyGreneri<>();

        m2.add("Hello");
        System.out.println(m2.get());

    }
}
