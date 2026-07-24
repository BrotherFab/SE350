package src;

public interface TaskState {
    void start(CareTask task);
    void complete(CareTask task);
    TaskStatus getStatus();
}
