package com.faz.rover2d.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.faz.rover2d.R;
import com.faz.rover2d.data.network.model.RoverBehaviorResponse;
import com.faz.rover2d.utils.SpaceItemDecoration;

public class MainActivity extends AppCompatActivity implements IMainView{

    MainPresenter mainPresenter;

    RecyclerView _recyclerView;
    StaggeredGridLayoutManager _layoutManager;
    RoverAdapter _adapter;
    ProgressBar _progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenter(this);
        mainPresenter.getRoverBehaviorFromServer();
    }

    private void initView() {
        _recyclerView = findViewById(R.id.recycler_view);
        _progressBar = findViewById(R.id.pb);

        _recyclerView.setHasFixedSize(true);
        _layoutManager = new StaggeredGridLayoutManager(10,
                StaggeredGridLayoutManager.VERTICAL);
        _layoutManager.setReverseLayout(true);
        _recyclerView.setLayoutManager(_layoutManager);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this,s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayResult(RoverBehaviorResponse result) {
        Log.v("displayResult",result.toString());
        _progressBar.setVisibility(View.GONE);
        _adapter = new RoverAdapter(this,result);
        _recyclerView.setAdapter(_adapter);
    }

    @Override
    public void displayError(String s) {
    }
}
