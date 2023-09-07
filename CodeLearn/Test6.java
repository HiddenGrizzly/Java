class Student6 {
	String name;
    int age;
    public Student6(String n, int a) {
        name = n;
        age = a;
    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Test6 {
    public static void main(String[] args) {
        Student6 s1 = new Student6("Long", 24);
        Student6 s2 = new Student6("Kien", 29);
        s1.display();
        s2.display();
    }
}