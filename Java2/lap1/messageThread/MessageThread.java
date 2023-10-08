package java2Laps.lap1.messageThread;

public class MessageThread extends Thread{
    private int number;
    private String message;
    private String priority;
    private int timeout;

    public MessageThread( int number, String message, String priority, int timeout) {
        this.number = number;
        this.message = message;
        this.priority = priority;
        this.timeout = timeout;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getMPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println("Message " + number + ": " + message);
        System.out.println("Time out: " + timeout);
        System.out.println("Priority: " + priority);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 4; i++){
            try {
                System.out.println(message);
                Thread.sleep(timeout);
            }catch (InterruptedException e){
                System.out.println("Interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        MessageThread mt1 = new MessageThread(1, "multithreading", "high", 1000);
        MessageThread mt2 = new MessageThread(2, "multitasking", "medium", 2000);
        mt1.start();
        mt2.start();
    }
}
