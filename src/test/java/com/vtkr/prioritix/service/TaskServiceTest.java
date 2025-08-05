package com.vtkr.prioritix.service;

import java.util.List;
import java.util.Map;
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
import com.vtkr.prioritix.model.Priority;
import com.vtkr.prioritix.model.entity.Task;
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

    @Test
    void getTasksByPriority_WhenNullTasksList_shouldReturnEmptyPriorityMap() {
        // Given
        final Map<Priority, List<Task>> expectedTasksByPriority = Map.of();

        // When
        Mockito.when(mockTaskRepository.findAll()).thenReturn(null);
        final Map<Priority, List<Task>> actualTasksByPriority = classToBeTested.getTasksByPriority();

        // Then
        Assertions.assertEquals(expectedTasksByPriority, actualTasksByPriority);
        Assertions.assertEquals(0, actualTasksByPriority.size());
    }

    @Test
    void getTasksByPriority_WhenEmptyTasks_shouldReturnEmptyPriorityMap() {
        // Given
        final Map<Priority, List<Task>> expectedTasksByPriority = Map.of();

        // When
        Mockito.when(mockTaskRepository.findAll()).thenReturn(TestConstants.EMPTY_TASK_LIST);
        final Map<Priority, List<Task>> actualTasksByPriority = classToBeTested.getTasksByPriority();

        // Then
        Assertions.assertEquals(expectedTasksByPriority, actualTasksByPriority);
        Assertions.assertEquals(0, actualTasksByPriority.size());
    }

    @Test
    void getTasksByPriority_WhenTasksExist_ShouldReturnMapOfPriorityToTaskList() {
        // Given
        final List<Task> tasks = TestConstants.aTaskList();
        final Map<Priority, List<Task>> expectedTasksByPriority = Map.of(
            Priority.URGENT_IMPORTANT, tasks
        );

        // When
        Mockito.when(mockTaskRepository.findAll()).thenReturn(tasks);
        final Map<Priority, List<Task>> actualTasksByPriority = classToBeTested.getTasksByPriority();

        // Then
        Mockito.verify(mockTaskRepository).findAll();
        Assertions.assertEquals(expectedTasksByPriority, actualTasksByPriority);
        Assertions.assertEquals(1, actualTasksByPriority.size());
        Assertions.assertTrue(actualTasksByPriority.containsKey(Priority.URGENT_IMPORTANT));
        Assertions.assertEquals(tasks, actualTasksByPriority.get(Priority.URGENT_IMPORTANT));
    }

}
