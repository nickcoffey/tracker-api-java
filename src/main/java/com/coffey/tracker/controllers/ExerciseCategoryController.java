package com.coffey.tracker.controllers;

import com.coffey.tracker.models.ExerciseCategory;
import com.coffey.tracker.repositories.ExerciseCategoryRepository;
import com.coffey.tracker.responses.GetAllExerciseCategoryResponse;
import com.coffey.tracker.responses.ExerciseCategoryResponse;
import com.coffey.tracker.responses.ProgramResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercise-category")
public class ExerciseCategoryController {

    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;

    @PostMapping
    private ExerciseCategoryResponse createExerciseCategory(@RequestBody ExerciseCategory exerciseCategory) {
        ExerciseCategory newExerciseCategory = exerciseCategoryRepository.save(exerciseCategory);
        return new ExerciseCategoryResponse(newExerciseCategory);
    }

    @GetMapping(value = "/all")
    private GetAllExerciseCategoryResponse getAllExerciseCategory() {
        List<ExerciseCategoryResponse> exerciseCategories = new ArrayList<>();
        exerciseCategoryRepository.findAll().forEach(category -> exerciseCategories.add(new ExerciseCategoryResponse(category)));
        return new GetAllExerciseCategoryResponse(exerciseCategories);
    }

    @GetMapping
    private ExerciseCategoryResponse getExerciseCategoryById(@RequestParam String id) {
        return exerciseCategoryRepository.findById(Long.parseLong(id)).map(ExerciseCategoryResponse::new).orElseGet(ExerciseCategoryResponse::new);
    }
}
