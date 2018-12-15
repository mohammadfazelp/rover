package com.faz.rover2d.data.network;

import com.faz.rover2d.data.network.model.RoverRequest;
import com.faz.rover2d.data.network.model.RoverBehaviorResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INetwork {

    @FormUrlEncoded
    @POST(".")
    Observable<RoverBehaviorResponse> getRoverBehaviorFromServer(@Field("rover_id") String rover_id);
}
