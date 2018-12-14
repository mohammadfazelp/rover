package com.faz.rover2d.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RoverResult {

    @Expose
    @SerializedName("start_point")
    private PointModel start_point;

    @Expose
    @SerializedName("command")
    private String command;

    @Expose
    @SerializedName("weirs")
    private ArrayList<PointModel> weirs;

    public RoverResult(PointModel start_point, String command, ArrayList<PointModel> weirs) {
        this.start_point = start_point;
        this.command = command;
        this.weirs = weirs;
    }

    public PointModel getStart_point() {
        return start_point;
    }

    public void setStart_point(PointModel start_point) {
        this.start_point = start_point;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<PointModel> getWeirs() {
        return weirs;
    }

    public void setWeirs(ArrayList<PointModel> weirs) {
        this.weirs = weirs;
    }
}
