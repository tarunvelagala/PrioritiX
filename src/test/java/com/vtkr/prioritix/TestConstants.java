package com.vtkr.prioritix;

import java.util.List;
import java.util.Map;

import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.entity.Task;
import lombok.experimental.UtilityClass;

/**
 * Constants for unit tests.
 */
@UtilityClass
public class TestConstants {

    public static final String TASK_TITLE = "TASK_TITLE";

    public static final String TASK_DESCRIPTION = "TASK_DESCRIPTION";

    public static final Priority TASK_PRIORITY = Priority.URGENT_IMPORTANT;

    public static final boolean COMPLETED = false;

    public static final List<Task> EMPTY_TASK_LIST = List.of();


    /**
     * Method for creating mock task.
     *
     * @return {@code Task} a mock Task.
     */
    public static Task aTask() {
        return Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .priority(TASK_PRIORITY)
                .completed(COMPLETED)
                .build();
    }

    /**
     * Method for creating a list of mock tasks.
     * 
     * @return {@code List<Task>} a list of mock tasks.
     */
    public static List <Task> aTaskList() {
        return List.of(aTask());
    }

    /**
     * Method for creating a map of tasks by priority.
     * 
     * @return {@code Map<Priority, List<Task>>} a map of tasks by priority.
     */
    public static Map<Priority, List<Task>> aTaskPriorityMap() {   
        return Map.of(TASK_PRIORITY, aTaskList());
    }
}
