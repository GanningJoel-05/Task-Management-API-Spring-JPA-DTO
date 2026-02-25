package com.TaskManagementAPI.MiniProject.mapper;

import com.TaskManagementAPI.MiniProject.dto.TaskRequestDTO;
import com.TaskManagementAPI.MiniProject.dto.TaskResponseDTO;
import com.TaskManagementAPI.MiniProject.entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());
        return task;
    }

    public static TaskResponseDTO toDto(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        return dto;
    }
}
