package com.coffey.tracker.controllers;

import com.coffey.tracker.models.ExerciseCategory;
import com.coffey.tracker.models.Exercise;
import com.coffey.tracker.repositories.ExerciseCategoryRepository;
import com.coffey.tracker.repositories.ExerciseRepository;
import com.coffey.tracker.requests.CreateExerciseRequest;
import com.coffey.tracker.responses.ExerciseResponse;
import com.coffey.tracker.responses.GetAllExerciseResponse;
import com.coffey.tracker.responses.RoutineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ExerciseCategoryRepository exerciseCategoryRepository;

    @PostMapping
    private ExerciseResponse createRoutineWeightedExercise(@RequestBody CreateExerciseRequest createExerciseRequest) {
        Optional<ExerciseCategory> exerciseCategory = exerciseCategoryRepository.findById(createExerciseRequest.getCategoryId());
        Exercise exercise = exerciseRepository.save(new Exercise(createExerciseRequest.getName(), exerciseCategory.orElse(null)));
        return new ExerciseResponse(exercise);
    }

    @GetMapping(value = "/by-category")
    private GetAllExerciseResponse getAllExercisesByCategory(@RequestParam String categoryId) {
        List<ExerciseResponse> exercises = new ArrayList<>();
        exerciseRepository.findByExerciseCategoryId(Long.parseLong(categoryId)).forEach(exercise -> exercises.add(new ExerciseResponse(exercise)));
        return new GetAllExerciseResponse(exercises);
    }

    @GetMapping(value = "/all")
    private GetAllExerciseResponse getAllExercises() {
        List<ExerciseResponse> exercises = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercise -> exercises.add(new ExerciseResponse(exercise)));
        return new GetAllExerciseResponse(exercises);
    }

    @GetMapping
    private ExerciseResponse getExerciseById(@RequestParam String id) {
        return exerciseRepository.findById(Long.parseLong(id)).map(ExerciseResponse::new).orElseGet(ExerciseResponse::new);
    }
}
