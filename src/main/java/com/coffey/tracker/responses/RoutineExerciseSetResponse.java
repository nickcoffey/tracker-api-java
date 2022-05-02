package com.coffey.tracker.responses;

import com.coffey.tracker.models.RoutineExerciseSet;

public class RoutineExerciseSetResponse {
    private Long id;
    private Double weight;
    private int reps;

    public RoutineExerciseSetResponse() {
    }

    public RoutineExerciseSetResponse(RoutineExerciseSet routineExerciseSet) {
        this.id = routineExerciseSet.getId();
        this.weight = routineExerciseSet.getWeight();
        this.reps = routineExerciseSet.getReps();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
