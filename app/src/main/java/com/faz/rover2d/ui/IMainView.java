package com.faz.rover2d.ui;


import com.faz.rover2d.data.network.model.RoverBehaviorResponse;

public interface IMainView {

    void showToast(String s);
    void displayResult(RoverBehaviorResponse result);
    void displayError(String s);
}