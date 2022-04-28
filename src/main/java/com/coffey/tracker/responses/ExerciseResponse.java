package com.coffey.tracker.responses;

import com.coffey.tracker.models.Exercise;

public class ExerciseResponse {
    private Long id;
    private String name;
    private String category;

    public ExerciseResponse() {
    }

    public ExerciseResponse(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.category = exercise.getExerciseCategory().getName();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
