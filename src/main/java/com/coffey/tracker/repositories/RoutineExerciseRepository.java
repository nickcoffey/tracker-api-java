package com.coffey.tracker.repositories;

import com.coffey.tracker.models.RoutineExercise;
import org.springframework.data.repository.CrudRepository;

public interface RoutineExerciseRepository extends CrudRepository<RoutineExercise, Long> {
    Iterable<RoutineExercise> findByRoutineId(Long routineId);
}
