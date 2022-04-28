package com.coffey.tracker.models;

import javax.persistence.*;

@Entity
public class WorkoutExerciseSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weight;
    private int reps;
    @ManyToOne(optional = false)
    @JoinColumn(name = "workout_exercise_id", nullable = false, referencedColumnName = "id")
    private WorkoutExercise workoutExercise;

    public WorkoutExerciseSet() {
    }

    public WorkoutExerciseSet(Double weight, int reps, WorkoutExercise workoutExercise) {
        this.weight = weight;
        this.reps = reps;
        this.workoutExercise = workoutExercise;
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

    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
    }
}
