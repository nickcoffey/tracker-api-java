package com.coffey.tracker.controllers;

import com.coffey.tracker.models.Program;
import com.coffey.tracker.repositories.ProgramRepository;
import com.coffey.tracker.responses.GetAllProgramResponse;
import com.coffey.tracker.responses.ProgramResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/program")
public class ProgramController {
    @Autowired
    private ProgramRepository programRepository;

    @PostMapping
    private ProgramResponse createProgram(@RequestBody Program program) {
        Program newProgram = programRepository.save(program);
        return new ProgramResponse(newProgram);
    }

    @GetMapping(value = "/all")
    private GetAllProgramResponse getAllPrograms() {
        List<ProgramResponse> programs = new ArrayList<>();
        programRepository.findAll().forEach(program -> programs.add(new ProgramResponse(program)));
        return new GetAllProgramResponse(programs);
    }

    @GetMapping
    private ProgramResponse getProgramById(@RequestParam String id) {
        return programRepository.findById(Long.parseLong(id)).map(ProgramResponse::new).orElseGet(ProgramResponse::new);
    }
}
