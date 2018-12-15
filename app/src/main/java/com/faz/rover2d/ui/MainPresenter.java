package com.faz.rover2d.ui;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.faz.rover2d.data.network.INetwork;
import com.faz.rover2d.data.network.NetworkClient;
import com.faz.rover2d.data.network.model.RoverRequest;
import com.faz.rover2d.data.network.model.RoverBehaviorResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements IMainPresenter {

    private IMainView _mainView;
    private String TAG = "MainPresenter";

    MainPresenter(IMainView mainView) {
        _mainView = mainView;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getRoverBehaviorFromServer() {
        getObservable().subscribeWith(getObserver());
    }

    private Observable<RoverBehaviorResponse> getObservable(){

        return NetworkClient.getRetrofit().create(INetwork.class)
                .getRoverBehaviorFromServer("12856509")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<RoverBehaviorResponse> getObserver(){

        return new DisposableObserver<RoverBehaviorResponse>() {

            @Override
            public void onNext(@NonNull RoverBehaviorResponse result) {
                Log.d(TAG,"OnNext"+result.toString());
                _mainView.displayResult(result);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                _mainView.displayError("Error fetching ...");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                //_mainView.showToast("completed!");
            }
        };
    }
}

