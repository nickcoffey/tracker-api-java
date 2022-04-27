package com.coffey.tracker.controllers;

import com.coffey.tracker.models.ExerciseCategory;
import com.coffey.tracker.repositories.ExerciseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exercise-category")
public class ExerciseCategoryController {

    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;

    @PostMapping
    private ExerciseCategory createExerciseCategory(@RequestBody ExerciseCategory exerciseCategory) {
        return exerciseCategoryRepository.save(exerciseCategory);
    }

    @GetMapping(value = "/all")
    private Iterable<ExerciseCategory> getAllExerciseCategory() {
        return exerciseCategoryRepository.findAll();
    }

    @GetMapping
    private Optional<ExerciseCategory> getExerciseCategoryById(@RequestParam String id) {
        return exerciseCategoryRepository.findById(Long.parseLong(id));
    }
}
