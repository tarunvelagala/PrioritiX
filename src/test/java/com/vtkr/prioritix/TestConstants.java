package com.vtkr.prioritix;

import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.Task;
import lombok.experimental.UtilityClass;

/**
 * Constants for unit tests.
 */
@UtilityClass
public class TestConstants {

    public final String TASK_TITLE = "TASK_TITLE";

    public final String TASK_DESCRIPTION = "TASK_DESCRIPTION";

    public final Priority TASK_PRIORITY = Priority.URGENT_IMPORTANT;

    public final boolean COMPLETED = false;

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
}
