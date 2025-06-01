package com.vtkr.prioritix.repository;

import com.vtkr.prioritix.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Task} entity.
 *
 * Provides CRUD operations and database interactions for tasks.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional query methods (if needed) can be defined here.
}
