package java2Laps.lap1.myThread;

public class MyThread extends Thread{
    String name;
    public void run() {
        System.out.println("Current thread name: " + Thread.currentThread().getName());
        Thread.currentThread().setName("myJavaThread");
        System.out.println("Renamed thread name: " + Thread.currentThread().getName());
        System.out.println("First 10 even numbers:");
        for (int i = 0; i < 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
    }
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
