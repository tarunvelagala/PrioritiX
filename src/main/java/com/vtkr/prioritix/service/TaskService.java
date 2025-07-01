package com.vtkr.prioritix.service;

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
}
