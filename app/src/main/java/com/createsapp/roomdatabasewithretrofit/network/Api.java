package com.createsapp.roomdatabasewithretrofit.network;

import com.createsapp.roomdatabasewithretrofit.model.Actor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("data.php/")
    Call<List<Actor>> getAllActors();
}
