package src;

public class CompletedState implements TaskState {
    public void start(CareTask task) {
        System.out.println("Task is already completed.");
    }

    public void complete(CareTask task) {
        System.out.println("Task is already completed.");
    }

    public TaskStatus getStatus() {
        return TaskStatus.COMPLETED;
    }
}
