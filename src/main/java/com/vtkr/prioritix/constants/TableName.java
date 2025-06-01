package com.vtkr.prioritix.constants;

import lombok.experimental.UtilityClass;

/**
 * Utility class to hold table name constants used in JPA entity mappings.
 * <p>
 * This helps avoid hardcoded strings in annotations like
 * {@code @Table(name = ...)}
 * and ensures consistency across the codebase.
 */
@UtilityClass
public class TableName {
    /**
     * Name of the database table that stores Task entities.
     */
    public final String TASKS = "tasks";
}
