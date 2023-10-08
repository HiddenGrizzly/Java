package java2Laps.lap1.mainThread;

public class MainThread extends Thread {
    String name;
    public MainThread(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 5; i > 0; i--){
            System.out.println(name + " : " + i);
        }
        System.out.println(name +" exiting.");
    }

    public static void main(String[] args) {
        MainThread[] mainThreads = new MainThread[3];
        mainThreads[0] = new MainThread("First");
        mainThreads[1] = new MainThread("Second");
        mainThreads[2] = new MainThread("third");
        for (int i = 0; i < 3; i++){
            System.out.println("New thread : Thread[" + mainThreads[i].name + ", " + i + ", main]");
            mainThreads[i].start();
        }
        for (int i = 0; i < 3; i++){
            try {
                mainThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread exiting.");
    }
}
