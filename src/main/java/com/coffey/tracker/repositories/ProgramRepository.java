package com.coffey.tracker.repositories;

import com.coffey.tracker.models.Program;
import org.springframework.data.repository.CrudRepository;

public interface ProgramRepository extends CrudRepository<Program, Long> {
}
