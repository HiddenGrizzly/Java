package java2Laps.lap2.ex2;

public class FactorySimulation {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        Manager manager = new Manager(taskList);
        Worker worker1 = new Worker(taskList, "Worker 1");
        Worker worker2 = new Worker(taskList, "Worker 2");

        manager.start();
        worker1.start();
        worker2.start();
    }
}
