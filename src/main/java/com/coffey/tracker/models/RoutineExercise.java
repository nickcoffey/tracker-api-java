package com.coffey.tracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoutineExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "routine_id", nullable = false, referencedColumnName = "id")
    private Routine routine;
    @ManyToOne(optional = false)
    @JoinColumn(name = "exercise_id", nullable = false, referencedColumnName = "id")
    private Exercise exercise;
    @OneToMany(mappedBy = "routineExercise", cascade = CascadeType.ALL)
    private List<RoutineExerciseSet> routineExerciseSets;

    public RoutineExercise() {
    }

    public RoutineExercise(Routine routine, Exercise exercise) {
        this.routine = routine;
        this.exercise = exercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<RoutineExerciseSet> getRoutineExerciseSets() {
        return routineExerciseSets;
    }

    public void setRoutineExerciseSets(List<RoutineExerciseSet> routineExerciseSets) {
        this.routineExerciseSets = routineExerciseSets;
    }
}
