package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Task;

import java.util.List;

/**
 * Created by User on 04 Янв., 2020
 */

@RestController
public class TaskController {

    @GetMapping("/tasks/")
    public List<Task> list() {
        return Storage.getAllTasks();
    }

    @PostMapping("/tasks/")
    public int add(Task task) {
        return Storage.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (Storage.deleteTask(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return null;
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity put(@PathVariable int id, Task task) {
        int res = Storage.putTask(id, task);
        if (res == 201) {
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else if (res == 200) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);

    }
}
