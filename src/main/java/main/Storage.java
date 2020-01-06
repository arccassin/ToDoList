package main;

import org.springframework.http.HttpStatus;
import response.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 04 Янв., 2020
 */
public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();

    public static List<Task> getAllTasks(){
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList.addAll(tasks.values());
        return taskList;
    }

    public static int addTask(Task task){
        int id = currentId++;
        while (tasks.containsKey(id))
        {
            id = currentId++;
        }
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static HttpStatus putTask(int taskId, Task task){
        if (tasks.containsKey(taskId)){
            tasks.put(taskId, task);
            return HttpStatus.OK;
        } else {
            tasks.put(taskId, task);
            return HttpStatus.CREATED;
        }
    }

    public static Task getTask(int taskId){
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static boolean deleteTask(int taskId){
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
            return true;
        }
        return false;
    }
}
