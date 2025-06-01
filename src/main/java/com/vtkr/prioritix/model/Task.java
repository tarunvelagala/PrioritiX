package com.vtkr.prioritix.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity representing a task in the PrioritiX application.
 * 
 * This task is classified using the Eisenhower Matrix (priority), and includes
 * metadata like completion status and creation time.
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    /**
     * Unique identifier for the task. Auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title or name of the task. Cannot be null.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Optional detailed description of the task.
     */
    private String description;

    /**
     * Priority of the task based on Eisenhower Matrix quadrants.
     */
    @Enumerated(EnumType.STRING)
    private Priority priority;

    /**
     * Completion status of the task. True if completed, false otherwise.
     */
    private boolean completed;

    /**
     * Timestamp when the task was created.
     */
    private LocalDateTime createdAt;
}
