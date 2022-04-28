package com.coffey.tracker.models;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private ExerciseCategory exerciseCategory;

    public Exercise() {
    }

    public Exercise(String name, ExerciseCategory exerciseCategory) {
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
}
