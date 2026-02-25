package com.TaskManagementAPI.MiniProject.service;

import com.TaskManagementAPI.MiniProject.entity.Task;
import com.TaskManagementAPI.MiniProject.entity.TaskStatus;
import com.TaskManagementAPI.MiniProject.exception.TaskNotFoundException;
import com.TaskManagementAPI.MiniProject.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        log.info("Creating new task with title: {}", task.getTitle());
        return taskRepository.save(task);
    }

    public Page<Task> getAllTasks(Pageable pageable) {
        log.info("Fetching tasks with pagination");
        return taskRepository.findAll(pageable);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task Not Found with ID: " + id));
    }

    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());

        log.info("Updating task with ID: {}", id);
        return taskRepository.save(existingTask);
    }

    public Task partialUpdateTask(Long id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        if (updatedTask.getTitle() != null) {
            existingTask.setTitle(updatedTask.getTitle());
        }

        if (updatedTask.getDescription() != null) {
            existingTask.setDescription(updatedTask.getDescription());
        }

        if (updatedTask.getStatus() != null) {
            existingTask.setStatus(updatedTask.getStatus());
        }

        if (updatedTask.getPriority() != null) {
            existingTask.setPriority(updatedTask.getPriority());
        }

        if (updatedTask.getDueDate() != null) {
            existingTask.setDueDate((updatedTask.getDueDate()));
        }

        log.info("Partially updating task with ID: {}", id);
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        log.warn("Deleting tasks with ID: {}", id);
        taskRepository.delete(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        log.info("Fetching tasks by status: {}", status);
        return taskRepository.findByStatus(status);
    }
}
