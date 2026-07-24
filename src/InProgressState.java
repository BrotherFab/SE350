package src;

public class InProgressState implements TaskState {
    public void start(CareTask task) {
        System.out.println("Task is already in progress.");
    }

    public void complete(CareTask task) {
        task.setState(new CompletedState());
        System.out.println("Task completed.");
    }

    public TaskStatus getStatus() {
        return TaskStatus.IN_PROGRESS;
    }
}
