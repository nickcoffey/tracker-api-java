package com.coffey.tracker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoutineWeightedExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private ExerciseCategory exerciseCategory;

    @OneToMany(mappedBy = "routineWeightedExercise", cascade = CascadeType.ALL)
    private List<RoutineWeightedSet> routineWeightedSets;

    public RoutineWeightedExercise() {
    }

    public RoutineWeightedExercise(String name, ExerciseCategory exerciseCategory) {
        this.name = name;
        this.exerciseCategory = exerciseCategory;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public List<RoutineWeightedSet> getRoutineWeightedSets() {
        return routineWeightedSets;
    }
}
