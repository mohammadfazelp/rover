package com.faz.rover2d.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoverRequest {

    @Expose
    @SerializedName("rover_id")
    private String rover_id;

    public String getRover_id() {
        return rover_id;
    }

    public void setRover_id(String rover_id) {
        this.rover_id = rover_id;
    }

    public RoverRequest(String rover_id) {
        this.rover_id = rover_id;
    }
}
