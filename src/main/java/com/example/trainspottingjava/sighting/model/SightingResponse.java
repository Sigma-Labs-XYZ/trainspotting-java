package com.example.trainspottingjava.sighting.model;

import java.util.List;

public class SightingResponse {
    private List<Sighting> data;
    private String error;

    public SightingResponse(List<Sighting> data, String error) {
        this.data = data;
        this.error = error;
    }

    public List<Sighting> getData() {
        return data;
    }

    public String getError() {
        return error;
    }
}
