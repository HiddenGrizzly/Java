package java2Laps.lap2.ex2;
import java.util.LinkedList;
import java.util.Queue;

class TaskList {
    private Queue<String> tasks = new LinkedList<>();

    public synchronized void addTask(String task) {
        tasks.add(task);
        notifyAll();
    }

    public synchronized String getTask() {
        while (tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tasks.poll();
    }
}

class Manager extends Thread {
    private TaskList taskList;

    public Manager(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            taskList.addTask("Task " + i);
            System.out.println("Manager added Task " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Worker extends Thread {
    private TaskList taskList;

    public Worker(TaskList taskList, String name) {
        super(name);
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (true) {
            String task = taskList.getTask();
            System.out.println(getName() + " performing " + task);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

