package com.preeti.apod.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Game on 22-09-17.
 */

public interface ApodService {

    @GET("planetary/apod")
    Call<ApodImage  > hitApodAPI(@Query("api_key") String apiKey);
}
