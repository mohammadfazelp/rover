package com.faz.rover2d.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointModel {

    @Expose
    @SerializedName("x")
    private int x;

    @Expose
    @SerializedName("y")
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PointModel(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
