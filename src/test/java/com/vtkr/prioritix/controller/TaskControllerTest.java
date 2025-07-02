package com.vtkr.prioritix.controller;

import com.vtkr.prioritix.TestConstants;
import com.vtkr.prioritix.controller.impl.TaskControllerImpl;
import com.vtkr.prioritix.model.Task;
import com.vtkr.prioritix.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @Mock
    private TaskService mockTaskService;

    private TaskController classToBeTested;

    @BeforeEach
    public void setup() {
        classToBeTested = new TaskControllerImpl(mockTaskService);
    }

    @Test
    public void testLombokAnnotations() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new TaskControllerImpl(null));
        Assertions.assertThrows(NullPointerException.class, () -> classToBeTested.createTask(null));
    }

    @Test
    public void testCreateTask_whenValidRequest_shouldSaveTask() {
        // Given
        final Task validTask = TestConstants.aTask();
        final UUID validTaskId = validTask.getId();

        // When
        Mockito.when(mockTaskService.createTask(validTask)).thenReturn(validTask);
        final Task expectedValidTask = classToBeTested.createTask(validTask);

        // Then
        Assertions.assertEquals(validTaskId, expectedValidTask.getId());
        Assertions.assertEquals(validTask.getCreatedAt().toString(), expectedValidTask.getCreatedAt().toString());
    }
}
