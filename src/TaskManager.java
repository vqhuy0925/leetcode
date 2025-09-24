import java.util.List;
import java.util.PriorityQueue;

public class TaskManager {

    record Task(int userId, int taskId, int priority) {}

    private Map<Integer, Task> taskInfo;
    private PriorityQueue<Task> taskQueue;

    public TaskManager(List<List<Integer>> tasks) {
        this.taskQueue = new PriorityQueue<>((t1, t2) -> t2.priority - t1.priority);

    }
    
    public void add(int userId, int taskId, int priority) {
        
    }
    
    public void edit(int taskId, int newPriority) {
        
    }
    
    public void rmv(int taskId) {
        
    }
    
    public int execTop() {
        return 1;
    }
   
    public static void main(String[] args) {
        
    }
}
