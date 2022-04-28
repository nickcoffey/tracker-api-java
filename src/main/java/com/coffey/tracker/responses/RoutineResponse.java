package com.coffey.tracker.responses;

import com.coffey.tracker.models.Routine;

public class RoutineResponse {
    private Long id;
    private String name;

    public RoutineResponse() {
    }

    public RoutineResponse(Routine routine) {
        this.id = routine.getId();
        this.name = routine.getName();
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
