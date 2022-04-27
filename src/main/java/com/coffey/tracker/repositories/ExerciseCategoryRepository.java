package com.coffey.tracker.repositories;

import com.coffey.tracker.models.ExerciseCategory;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseCategoryRepository extends CrudRepository<ExerciseCategory, Long> {
}
