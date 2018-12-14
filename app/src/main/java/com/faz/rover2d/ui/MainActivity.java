package com.faz.rover2d.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.faz.rover2d.R;
import com.faz.rover2d.data.network.INetwork;
import com.faz.rover2d.data.network.Urls;
import com.faz.rover2d.data.network.model.RoverRequest;
import com.faz.rover2d.data.network.model.RoverResult;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements IMainView{

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMVP();
        getRover();
    }

    private void getRover() {
        mainPresenter.getRover();
    }


    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }
    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this,s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayResult(RoverResult result) {
        Log.v("displayResult",result.toString());
    }

    @Override
    public void displayError(String s) {

    }
}
