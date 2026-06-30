package com.emeric.taskmanager.service;

import com.emeric.taskmanager.model.Task;
import com.emeric.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Test Beschreibung");
        task.setCompleted(false);
    }

    @Test
    void getAllTasks_sollteLiesteZurueckgeben() {
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
        assertEquals("Test Task", result.get(0).getTitle());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getTaskById_sollteTaskZurueckgeben() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(1L);

        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());
    }

    @Test
    void getTaskById_sollteExceptionWerfenWennNichtGefunden() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> taskService.getTaskById(99L));
    }

    @Test
    void createTask_sollteTaskSpeichern() {
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.createTask(task);

        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void deleteTask_sollteTaskLoeschen() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.deleteTask(1L);

        verify(taskRepository, times(1)).delete(task);
    }
}