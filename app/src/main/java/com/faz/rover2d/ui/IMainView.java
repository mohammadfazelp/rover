package com.faz.rover2d.ui;


import com.faz.rover2d.data.network.model.RoverResult;

public interface IMainView {

    void showToast(String s);
    void displayResult(RoverResult result);
    void displayError(String s);
}