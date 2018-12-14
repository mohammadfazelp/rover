package com.faz.rover2d.data.network;

import com.faz.rover2d.data.network.model.RoverRequest;
import com.faz.rover2d.data.network.model.RoverResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface INetwork {

    @POST(".")
    Observable<RoverResult> getRover(@Body RoverRequest request);
}
