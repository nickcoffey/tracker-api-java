package com.coffey.tracker.responses;

import com.coffey.tracker.models.Program;

public class ProgramResponse {
    private Long id;
    private String name;

    public ProgramResponse() {
    }

    public ProgramResponse(Program program) {
        this.id = program.getId();
        this.name = program.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
