package src;

public class PendingState implements TaskState {
    public void start(CareTask task) {
        task.setState(new InProgressState());
        System.out.println("Task started.");
    }

    public void complete(CareTask task) {
        System.out.println("Task must be started before it can be completed.");
    }

    public TaskStatus getStatus() {
        return TaskStatus.PENDING;
    }
}
