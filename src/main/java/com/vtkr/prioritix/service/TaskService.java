package com.vtkr.prioritix.service;

import java.util.List;
import java.util.Map;

import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.Task;

/**
 * Service interface for managing {@link Task} entities.
 */
public interface TaskService {

    /**
     * Creates and saves a new {@link Task}.
     * 
     * @param task {@link Task} New task to be created.
     * @return {@link Task} created task.
     */
    public Task createTask(final Task task);

    /**
     * Gets Map of Priority to Task list.
     * 
     * @return Map of Priority to Task list.
     */
    public Map<Priority, List<Task>> getTasksByPriority();
}
