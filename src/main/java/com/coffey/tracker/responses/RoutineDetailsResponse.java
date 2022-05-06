package com.coffey.tracker.responses;

import com.coffey.tracker.models.Routine;

import java.util.ArrayList;
import java.util.List;

public class RoutineDetailsResponse {
    private Long id;
    private String name;
    private Long programId;
    private List<RoutineExerciseResponse> exercises;

    public RoutineDetailsResponse() {
    }

    public RoutineDetailsResponse(Routine routine) {
        this.id = routine.getId();
        this.name = routine.getName();
        this.programId = routine.getProgram().getId();
        this.exercises = new ArrayList<>();
        routine.getRoutineExercises().forEach(routineExercise -> this.exercises.add(new RoutineExerciseResponse(routineExercise)));
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

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public List<RoutineExerciseResponse> getExercises() {
        return exercises;
    }

    public void setExercises(List<RoutineExerciseResponse> exercises) {
        this.exercises = exercises;
    }
}
