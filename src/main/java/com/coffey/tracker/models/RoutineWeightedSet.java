package com.coffey.tracker.models;

import javax.persistence.*;

@Entity
public class RoutineWeightedSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weight;
    private int reps;
    @ManyToOne(optional = false)
    @JoinColumn(name = "routine_exercise_id", nullable = false, referencedColumnName = "id")
    private RoutineWeightedExercise routineWeightedExercise;

    public RoutineWeightedSet() {
    }

    public RoutineWeightedSet(Double weight, int reps, RoutineWeightedExercise routineWeightedExercise) {
        this.weight = weight;
        this.reps = reps;
        this.routineWeightedExercise = routineWeightedExercise;
    }

    public Long getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public RoutineWeightedExercise getExerciseCategory() {
        return routineWeightedExercise;
    }
}
