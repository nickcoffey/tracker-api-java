package com.coffey.tracker.requests;

public class CreateRoutineExerciseSetRequest {
    private Double weight;
    private int reps;

    public CreateRoutineExerciseSetRequest() {
    }

    public CreateRoutineExerciseSetRequest(Double weight, int reps) {
        this.weight = weight;
        this.reps = reps;
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
