package com.TaskManagementAPI.MiniProject.repository;

import com.TaskManagementAPI.MiniProject.entity.Task;
import com.TaskManagementAPI.MiniProject.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
}
