package com.coffey.tracker.controllers;

import com.coffey.tracker.models.*;
import com.coffey.tracker.repositories.*;
import com.coffey.tracker.requests.CreateRoutineRequest;
import com.coffey.tracker.responses.GetAllRoutineResponse;
import com.coffey.tracker.responses.ProgramResponse;
import com.coffey.tracker.responses.RoutineDetailsResponse;
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
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private RoutineExerciseRepository routineExerciseRepository;
    @Autowired
    private RoutineExerciseSetRepository routineExerciseSetRepository;

    @PostMapping
    private RoutineResponse createRoutine(@RequestBody CreateRoutineRequest createRoutineRequest) {
        Optional<Program> program = programRepository.findById(createRoutineRequest.getProgramId());
        Routine routine = routineRepository.save(new Routine(createRoutineRequest.getName(), program.orElse(null)));
        createRoutineRequest.getExercises().forEach(routineExerciseReq -> {
            Exercise exercise = exerciseRepository.findById(routineExerciseReq.getExerciseId()).orElse(null);
            RoutineExercise routineExercise = routineExerciseRepository.save(new RoutineExercise(routine, exercise));
            routineExerciseReq.getSets().forEach(routineExerciseSetReq -> routineExerciseSetRepository.save(new RoutineExerciseSet(routineExerciseSetReq.getWeight(), routineExerciseSetReq.getReps(), routineExercise)));
        });
        return new RoutineResponse(routine);
    }

    @GetMapping(value = "/by-program")
    private GetAllRoutineResponse getAllRoutinesByProgram(@RequestParam String programId) {
        List<RoutineResponse> routines = new ArrayList<>();
        routineRepository.findByProgramId(Long.parseLong(programId)).forEach(routine -> routines.add(new RoutineResponse(routine)));
        return new GetAllRoutineResponse(routines);
    }

    @GetMapping
    private RoutineDetailsResponse getRoutineById(@RequestParam String id) {
        return routineRepository.findById(Long.parseLong(id)).map(RoutineDetailsResponse::new).orElseGet(RoutineDetailsResponse::new);
    }
}
