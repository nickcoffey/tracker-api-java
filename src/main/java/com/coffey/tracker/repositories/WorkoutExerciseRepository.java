package com.coffey.tracker.repositories;

import com.coffey.tracker.models.WorkoutExercise;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutExerciseRepository extends CrudRepository<WorkoutExercise, Long> {
    Iterable<WorkoutExercise> findByWorkoutId(Long workoutId);
}
