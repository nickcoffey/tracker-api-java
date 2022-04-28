package com.coffey.tracker.repositories;

import com.coffey.tracker.models.Routine;
import org.springframework.data.repository.CrudRepository;

public interface RoutineRepository extends CrudRepository<Routine, Long> {
    Iterable<Routine> findByProgramId(Long programId);
}
