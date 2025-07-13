package com.vtkr.prioritix.model;

import java.time.LocalDateTime;
import java.util.UUID;

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

import com.vtkr.prioritix.constants.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity representing a task in the PrioritiX application.
 * This task is classified using the Eisenhower Matrix (priority), and includes
 * metadata like completion status and creation time.
 */
@Entity
@Table(name = TableName.TASKS)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * Unique identifier for the task. Auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
    @Builder.Default
    @Column(nullable = false, updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();
}
