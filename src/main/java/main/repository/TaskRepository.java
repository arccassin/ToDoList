package main.repository;

import main.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 12 Янв., 2020
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
