package com.vtkr.prioritix.repository;

import com.vtkr.prioritix.TestConstants;
import com.vtkr.prioritix.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Unit test class for TaskRepository.
 */
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void givenNewTask_whenSave_thenSuccess() {
        final Task newTask = TestConstants.aTask();
        final Task savedTask = taskRepository.createTask(newTask);

        Assertions.assertNotNull(savedTask);
        Assertions.assertNotNull(savedTask.getId());
        Assertions.assertEquals(TestConstants.TASK_TITLE, savedTask.getTitle());
    }
}
