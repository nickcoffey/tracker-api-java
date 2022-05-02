package com.coffey.tracker.requests;

import com.coffey.tracker.models.RoutineExercise;

import java.util.List;

public class CreateRoutineRequest {
    private String name;
    private Long programId;
    private List<CreateRoutineExerciseRequest> exercises;

    public List<CreateRoutineExerciseRequest> getExercises() {
        return exercises;
    }

    public void setExercises(List<CreateRoutineExerciseRequest> exercises) {
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }
}
