package com.coffey.tracker.responses;

import java.util.List;

public class GetAllExerciseResponse {
    private List<ExerciseResponse> exercises;

    public GetAllExerciseResponse() {
    }

    public GetAllExerciseResponse(List<ExerciseResponse> exercises) {
        this.exercises = exercises;
    }

    public List<ExerciseResponse> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseResponse> exercises) {
        this.exercises = exercises;
    }
}
