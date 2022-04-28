package com.coffey.tracker.repositories;

import com.coffey.tracker.models.RoutineExerciseSet;
import org.springframework.data.repository.CrudRepository;

public interface RoutineExerciseSetRepository extends CrudRepository<RoutineExerciseSet, Long> {
    Iterable<RoutineExerciseSet> findByRoutineExerciseId(Long routineExerciseId);
}
