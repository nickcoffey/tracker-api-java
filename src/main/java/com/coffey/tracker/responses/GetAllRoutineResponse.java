package com.coffey.tracker.responses;

import java.util.List;

public class GetAllRoutineResponse {
    private List<RoutineResponse> routines;

    public GetAllRoutineResponse() {
    }

    public GetAllRoutineResponse(List<RoutineResponse> routines) {
        this.routines = routines;
    }

    public List<RoutineResponse> getRoutines() {
        return routines;
    }

    public void setRoutines(List<RoutineResponse> routines) {
        this.routines = routines;
    }
}
