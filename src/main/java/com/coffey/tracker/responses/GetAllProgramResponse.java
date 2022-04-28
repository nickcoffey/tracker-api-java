package com.coffey.tracker.responses;

import java.util.List;

public class GetAllProgramResponse {
    private List<ProgramResponse> programs;

    public GetAllProgramResponse() {
    }

    public GetAllProgramResponse(List<ProgramResponse> programs) {
        this.programs = programs;
    }

    public List<ProgramResponse> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramResponse> programs) {
        this.programs = programs;
    }
}
