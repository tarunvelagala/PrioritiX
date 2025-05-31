package com.vtkr.PrioritiX.repository;

import com.vtkr.PrioritiX.model.Task;
import com.vtkr.PrioritiX.model.Priority;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Basic unit test for {@link TaskRepository} to verify
 * saving and retrieving a Task entity.
 */
@DataJpaTest
public class TaskRepositoryTest {

    public static final String TASK_TITLE = "Sample Task";
    public static final String TASK_DESCRIPTION = "Simple test";
    public static final LocalDateTime TASK_CREATED_AT = LocalDateTime.now();
    public static final Priority TASK_PRIORITY = Priority.URGENT_IMPORTANT;
    public static final boolean TASK_COMPLETED = false;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Test to verify that a valid Task can be saved and retrieved by ID.
     * Asserts all key fields to confirm persistence is accurate.
     */
    @Test
    public void givenValidTask_whenSaved_thenShouldBeFoundById() {

        // Given: a valid task entity
        final Task validTask = Task.builder()
                .title(TASK_TITLE)
                .description(TASK_DESCRIPTION)
                .priority(TASK_PRIORITY)
                .completed(TASK_COMPLETED)
                .createdAt(TASK_CREATED_AT)
                .build();

        final Task savedTask = taskRepository.save(validTask);
        final Optional<Task> oSavedTask = taskRepository.findById(savedTask.getId());

        // When: the task is saved and retrieved
        Assertions.assertTrue(oSavedTask.isPresent());
        final Task task = oSavedTask.get();

        // Then: the task should exist and fields should match
        Assertions.assertAll(
                () -> Assertions.assertEquals(TASK_TITLE, task.getTitle()),
                () -> Assertions.assertEquals(TASK_DESCRIPTION, task.getDescription()),
                () -> Assertions.assertEquals(TASK_COMPLETED, task.isCompleted()),
                () -> Assertions.assertEquals(TASK_PRIORITY, task.getPriority()),
                () -> Assertions.assertEquals(TASK_CREATED_AT, task.getCreatedAt()));
    }

    /**
     * Test to verify that searching with a non-existent ID returns an empty result.
     */
    @Test
    public void givenNonExistentId_whenFindById_thenShouldReturnEmptyOptional() {
        final Long invalidTaskId = 9999L;

        // When: searching for a task with an invalid ID
        final Optional<Task> oTask = taskRepository.findById(invalidTaskId);

        // Then: the result should be empty
        Assertions.assertTrue(oTask.isEmpty(), "Expected empty Optional for non-existent task ID");
    }
}