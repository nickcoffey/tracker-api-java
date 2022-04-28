package com.coffey.tracker.repositories;

import com.coffey.tracker.models.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    Iterable<Exercise> findByExerciseCategoryId(Long categoryId);
}
