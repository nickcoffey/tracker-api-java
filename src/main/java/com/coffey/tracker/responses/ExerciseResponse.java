package com.coffey.tracker.responses;

import com.coffey.tracker.models.Exercise;

public class ExerciseResponse {
    private Long id;
    private String name;
    private Long categoryId;

    public ExerciseResponse() {
    }

    public ExerciseResponse(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.categoryId = exercise.getExerciseCategory().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
