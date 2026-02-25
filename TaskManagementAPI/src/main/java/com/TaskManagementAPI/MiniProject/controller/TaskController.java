package com.TaskManagementAPI.MiniProject.controller;

import com.TaskManagementAPI.MiniProject.dto.TaskRequestDTO;
import com.TaskManagementAPI.MiniProject.dto.TaskResponseDTO;
import com.TaskManagementAPI.MiniProject.entity.Task;
import com.TaskManagementAPI.MiniProject.entity.TaskStatus;
import com.TaskManagementAPI.MiniProject.mapper.TaskMapper;
import com.TaskManagementAPI.MiniProject.repository.TaskRepository;
import com.TaskManagementAPI.MiniProject.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final TaskRepository repository;

    public TaskController(TaskService service, TaskRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        Task saved = service.createTask(task);
        return ResponseEntity.ok(TaskMapper.toDto(saved));
    }


    @GetMapping
    public ResponseEntity<Page<TaskResponseDTO>> getAllTasks(Pageable pageable) {
        Page<TaskResponseDTO> page = service.getAllTasks(pageable)
                .map(TaskMapper::toDto);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@Valid @PathVariable Long id, @Valid @RequestBody TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        Task updated = service.updateTask(id, task);

        return ResponseEntity.ok(TaskMapper.toDto(updated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> partialUpdateTask(@Valid @PathVariable Long id, @Valid @RequestBody TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);
        Task updated = service.partialUpdateTask(id, task);
        return ResponseEntity.ok(TaskMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.ok("Task Deleted Successfully!");
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskResponseDTO>> getTasksByStatus(@RequestParam TaskStatus value) {
        List<TaskResponseDTO> list = service.getTasksByStatus(value)
                .stream()
                .map(TaskMapper::toDto)
                .toList();

        return ResponseEntity.ok(list);
    }
}
