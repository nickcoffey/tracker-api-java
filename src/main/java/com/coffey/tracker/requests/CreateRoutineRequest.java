package com.coffey.tracker.requests;

public class CreateRoutineRequest {
    private String name;
    private Long programId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }
}
