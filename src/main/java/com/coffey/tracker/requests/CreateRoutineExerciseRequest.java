package com.coffey.tracker.requests;

import java.util.List;

public class CreateRoutineExerciseRequest {
    private Long exerciseId;
    private List<CreateRoutineExerciseSetRequest> sets;

    public CreateRoutineExerciseRequest() {
    }

    public CreateRoutineExerciseRequest(Long exerciseId, List<CreateRoutineExerciseSetRequest> sets) {
        this.exerciseId = exerciseId;
        this.sets = sets;
    }


    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public List<CreateRoutineExerciseSetRequest> getSets() {
        return sets;
    }

    public void setSets(List<CreateRoutineExerciseSetRequest> sets) {
        this.sets = sets;
    }
}
