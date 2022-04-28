package com.coffey.tracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "workout_id", nullable = false, referencedColumnName = "id")
    private Workout workout;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exercise_id", nullable = false, referencedColumnName = "id")
    private Exercise exercise;
    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL)
    private List<WorkoutExerciseSet> workoutExerciseSets;

    public WorkoutExercise() {
    }

    public WorkoutExercise(Workout workout, Exercise exercise) {
        this.workout = workout;
        this.exercise = exercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<WorkoutExerciseSet> getWorkoutExerciseSets() {
        return workoutExerciseSets;
    }

    public void setWorkoutExerciseSets(List<WorkoutExerciseSet> workoutExerciseSets) {
        this.workoutExerciseSets = workoutExerciseSets;
    }
}
