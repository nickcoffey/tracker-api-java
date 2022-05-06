package com.coffey.tracker.controllers;

import com.coffey.tracker.models.*;
import com.coffey.tracker.repositories.*;
import com.coffey.tracker.requests.CreateRoutineRequest;
import com.coffey.tracker.responses.*;
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

    @PutMapping
    private RoutineDetailsResponse updateRoutine(@RequestBody RoutineDetailsResponse updateRoutineRequest ) {
        Routine routine = routineRepository.findById(updateRoutineRequest.getId()).orElse(null);
        if(routine == null) {
            return null;
        } else {
            routine.setName(updateRoutineRequest.getName());
            List<RoutineExercise> exercises = (List<RoutineExercise>) routineExerciseRepository.findByRoutineId(updateRoutineRequest.getId());
            // remove, update, and add exercises
            for (int i = 0; i < exercises.size(); i++) {
                RoutineExercise exercise = exercises.get(i);
                Boolean doRemoveExercise = true;
                for (int j = 0; j < updateRoutineRequest.getExercises().size(); j++) {
                    RoutineExerciseResponse updateRequestExercise = updateRoutineRequest.getExercises().get(j);
                    if(exercise.getId() == updateRequestExercise.getId()) {
                        doRemoveExercise = false;
                        updateSets(exercise.getRoutineExerciseSets(), updateRequestExercise.getSets());
                    }
                }
                if(doRemoveExercise) {
                    routineExerciseRepository.deleteById(exercise.getId());
                }
            }
            Routine updatedRoutine  = routineRepository.save(routine);
            return new RoutineDetailsResponse(updatedRoutine);
        }
    }

    private void updateSets(List<RoutineExerciseSet> sets, List<RoutineExerciseSetResponse> updateRoutineSets) {
        for (int i = 0; i < sets.size(); i++) {
            RoutineExerciseSet set = sets.get(i);
            Boolean doRemoveSet = true;
            for (int j = 0; j < updateRoutineSets.size(); j++) {
                RoutineExerciseSetResponse updateRequestSet = updateRoutineSets.get(j);
                if(set.getId() == updateRequestSet.getId()) {
                    doRemoveSet = false;
                    set.setWeight(updateRequestSet.getWeight());
                    set.setReps(updateRequestSet.getReps());
                    routineExerciseSetRepository.save(set);
                }
            }
            if(doRemoveSet) {
                routineExerciseSetRepository.deleteById(set.getId());
            }
        }
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
