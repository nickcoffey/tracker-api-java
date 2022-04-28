package com.coffey.tracker.responses;

import com.coffey.tracker.models.ExerciseCategory;

public class ExerciseCategoryResponse {
    private Long id;
    private String name;

    public ExerciseCategoryResponse() {
    }

    public ExerciseCategoryResponse(ExerciseCategory category) {
        this.id = category.getId();
        this.name = category.getName();
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
}
