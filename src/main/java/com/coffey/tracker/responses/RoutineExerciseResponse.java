package com.coffey.tracker.responses;

import java.util.ArrayList;
import java.util.List;

import com.coffey.tracker.models.RoutineExercise;

public class RoutineExerciseResponse {
    private Long id;
    private Long exerciseId;
    private String name;
    private List<RoutineExerciseSetResponse> sets;

    public RoutineExerciseResponse() {
    }

    public RoutineExerciseResponse(RoutineExercise routineExercise) {
        this.id = routineExercise.getId();
        this.exerciseId = routineExercise.getExercise().getId();
        this.name = routineExercise.getExercise().getName();
        this.sets = new ArrayList<>();
        routineExercise.getRoutineExerciseSets().forEach(routineExerciseSet -> sets.add(new RoutineExerciseSetResponse((routineExerciseSet))));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoutineExerciseSetResponse> getSets() {
        return sets;
    }

    public void setSets(List<RoutineExerciseSetResponse> sets) {
        this.sets = sets;
    }
}
