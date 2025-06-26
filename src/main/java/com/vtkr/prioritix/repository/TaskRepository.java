package com.vtkr.prioritix.repository;

import com.vtkr.prioritix.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * JPA repository for {@link Task} entity with UUID as the ID type.
 */
public interface TaskRepository extends JpaRepository<Task, UUID> {

    Task createTask(Task task);
}
