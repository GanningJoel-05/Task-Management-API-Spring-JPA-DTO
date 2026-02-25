package com.TaskManagementAPI.MiniProject.dto;

import com.TaskManagementAPI.MiniProject.entity.TaskPriority;
import com.TaskManagementAPI.MiniProject.entity.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskRequestDTO {

    @NotBlank(message = "Title is Required")
    @Size(max = 200)
    private String title;

    private String description;

    @NotNull(message = "Status is Required")
    private TaskStatus status;

    @NotNull(message = "Priority is Required")
    private TaskPriority priority;

    @FutureOrPresent(message = "Due date must br today or future")
    private LocalDate dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
