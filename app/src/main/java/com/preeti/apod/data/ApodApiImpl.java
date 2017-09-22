package com.preeti.apod.data;

import android.util.Log;

import com.preeti.apod.util.MainInterface;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Game on 22-09-17.
 */

public class ApodApiImpl implements MainInterface.MainModel {


    private static final String TAG = "ApodApiImpl";

    @Override
    public void getAPODImage(final MainInterface.MainPresenter presenter) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();

        ApodService apodServiceClient = retrofit.create(ApodService.class);

        Call<ApodImage> call = apodServiceClient.hitApodAPI("cu0EekmvN2QosKK4OYfWr126x6o3DpcTMmNtyjFX");

        call.enqueue(new Callback<ApodImage>() {
            @Override
            public void onResponse(Call<ApodImage> call, Response<ApodImage> response) {
                ApodImage apodImage = response.body();
                Log.d(TAG, apodImage.getHdurl());
                presenter.receivedAPODImage(apodImage);
            }

            @Override
            public void onFailure(Call<ApodImage> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });



    }
}
