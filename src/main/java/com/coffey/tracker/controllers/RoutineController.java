package com.coffey.tracker.controllers;

import com.coffey.tracker.models.Program;
import com.coffey.tracker.models.Routine;
import com.coffey.tracker.repositories.ProgramRepository;
import com.coffey.tracker.repositories.RoutineRepository;
import com.coffey.tracker.requests.CreateRoutineRequest;
import com.coffey.tracker.responses.GetAllRoutineResponse;
import com.coffey.tracker.responses.ProgramResponse;
import com.coffey.tracker.responses.RoutineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {
    @Autowired
    private RoutineRepository routineRepository;
    @Autowired
    private ProgramRepository programRepository;

    @PostMapping
    private RoutineResponse createRoutine(@RequestBody CreateRoutineRequest createRoutineRequest) {
        Optional<Program> program = programRepository.findById(createRoutineRequest.getProgramId());
        Routine routine = routineRepository.save(new Routine(createRoutineRequest.getName(), program.orElse(null)));
        return new RoutineResponse(routine);
    }

    @GetMapping(value = "/by-program")
    private GetAllRoutineResponse getAllRoutinesByProgram(@RequestParam String programId) {
        List<RoutineResponse> routines = new ArrayList<>();
        routineRepository.findByProgramId(Long.parseLong(programId)).forEach(routine -> routines.add(new RoutineResponse(routine)));
        return new GetAllRoutineResponse(routines);
    }

    @GetMapping
    private RoutineResponse getRoutineById(@RequestParam String id) {
        return routineRepository.findById(Long.parseLong(id)).map(RoutineResponse::new).orElseGet(RoutineResponse::new);
    }
}
