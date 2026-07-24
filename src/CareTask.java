package src;

public class CareTask {
    private String description;
    private TaskPriority priority;
    private TaskState state;

    public CareTask(String description, TaskPriority priority) {
        this.description = description;
        this.priority = priority;
        this.state = new PendingState();
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return state.getStatus();
    }

    public void start() {
        state.start(this);
    }

    public void complete() {
        state.complete(this);
    }

    void setState(TaskState state) {
        this.state = state;
    }

    public String toString() {
        return description + " (" + priority + ", " + getStatus() + ")";
    }
}
