package src;

public class CareTask {
    private String description;
    private TaskPriority priority;
    private TaskStatus status;

    public CareTask(String description, TaskPriority priority) {
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
