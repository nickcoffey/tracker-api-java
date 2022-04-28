package com.coffey.tracker.responses;

import java.util.List;

public class GetAllExerciseCategoryResponse {
    private List<ExerciseCategoryResponse> exerciseCategories;

    public GetAllExerciseCategoryResponse() {
    }

    public GetAllExerciseCategoryResponse(List<ExerciseCategoryResponse> exerciseCategories) {
        this.exerciseCategories = exerciseCategories;
    }

    public List<ExerciseCategoryResponse> getExerciseCategories() {
        return exerciseCategories;
    }

    public void setExerciseCategories(List<ExerciseCategoryResponse> exerciseCategories) {
        this.exerciseCategories = exerciseCategories;
    }
}
