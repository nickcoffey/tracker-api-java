package com.coffey.tracker.repositories;

import com.coffey.tracker.models.WorkoutExerciseSet;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutExerciseSetRepository extends CrudRepository<WorkoutExerciseSet, Long> {
    Iterable<WorkoutExerciseSet> findByWorkoutExerciseId(Long workoutExerciseId);
}
