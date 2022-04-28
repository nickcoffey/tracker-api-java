package com.coffey.tracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoutineExerciseSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weight;
    private int reps;
    @ManyToOne(optional = false)
    @JoinColumn(name = "routine_exercise_id", nullable = false, referencedColumnName = "id")
    private RoutineExercise routineExercise;

    public RoutineExerciseSet() {
    }

    public RoutineExerciseSet(Double weight, int reps, RoutineExercise routineExercise) {
        this.weight = weight;
        this.reps = reps;
        this.routineExercise = routineExercise;
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

    public RoutineExercise getRoutineExercise() {
        return routineExercise;
    }

    public void setRoutineExercise(RoutineExercise routineExercise) {
        this.routineExercise = routineExercise;
    }
}
