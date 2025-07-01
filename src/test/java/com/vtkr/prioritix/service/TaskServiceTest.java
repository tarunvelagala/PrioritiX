package com.vtkr.prioritix.service;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vtkr.prioritix.TestConstants;
import com.vtkr.prioritix.model.Task;
import com.vtkr.prioritix.repository.TaskRepository;
import com.vtkr.prioritix.service.impl.TaskServiceImpl;

import static org.mockito.ArgumentMatchers.anyString;

/**
 * Unit tests for Task Service.
 */
@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository mockTaskRepository;

    @InjectMocks
    private TaskServiceImpl mockTaskServiceImpl;

    private TaskService classToBeTested;

    @BeforeEach
    public void setup() {
        classToBeTested = mockTaskServiceImpl;
    }

    @Test
    void constructor_ShouldInitializeService() {
        Assertions.assertNotNull(classToBeTested);
    }

    @Test
    void constructor_WhenTaskRepositoryIsNull_ShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> new TaskServiceImpl(null));
    }

    @Test
    public void createTask_WhenTaskIsNull_ShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> classToBeTested.createTask(null));
    }

    @Test
    void createTask_WhenRepositoryThrowsException_ShouldPropagate() {
        // Given
        final Task task = TestConstants.aTask();
        final String exceptionMessage = anyString();
        final Exception runTimeException = new RuntimeException(exceptionMessage);

        // When
        Mockito.when(mockTaskRepository.save(task)).thenThrow(runTimeException);

        // Then
        Assertions.assertThrows(RuntimeException.class, () -> classToBeTested.createTask(task));
        Assertions.assertEquals(exceptionMessage, runTimeException.getMessage());
    }

    @Test
    void createTask_ShouldSaveAndReturnTask() {
        // Given
        final UUID taskIdToBeCreated = UUID.randomUUID();
        final Task taskToBeCreated = Task.builder()
                .id(taskIdToBeCreated)
                .build();

        // When
        Mockito.when(mockTaskRepository.save(taskToBeCreated))
                .thenReturn(taskToBeCreated);

        // Then
        final Task result = classToBeTested.createTask(taskToBeCreated);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(taskToBeCreated.getId(), result.getId());
        Mockito.verify(mockTaskRepository).save(taskToBeCreated);
    }
}
