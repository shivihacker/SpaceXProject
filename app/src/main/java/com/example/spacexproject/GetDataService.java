package com.example.spacexproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("crew")
    Call<List<Model>> getCrewMember();

}
