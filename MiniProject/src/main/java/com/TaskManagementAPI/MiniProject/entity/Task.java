package com.TaskManagementAPI.MiniProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_ID")
    private Long id;

    @Column(name = "Task_Name", nullable = false, length = 200)
    private String title;

    @Column(name = "Task_Description", nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "Task_Status", nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "Task_Priority", nullable = false)
    private TaskPriority priority;

    @Column(name = "Task_DueDate", nullable = false)
    private LocalDate dueDate;
}
