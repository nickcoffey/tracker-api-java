package com.coffey.tracker.repositories;

import com.coffey.tracker.models.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
}
