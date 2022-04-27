package com.coffey.tracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExerciseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "exerciseCategory", cascade = CascadeType.ALL)
    private List<RoutineWeightedExercise> routineWeightedExercises;

    public ExerciseCategory() {
    }

    public ExerciseCategory(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RoutineWeightedExercise> getRoutineWeightedExercises() {
        return routineWeightedExercises;
    }
}
