package com.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomNumberService {
    @GET("jsonI.php?type=uint8")
    Call<RandomNumberResponse> getRandomNumbers(@Query("length") int length);

    @GET("jsonI.php?type=uint8")
    Call<InvalidRandomNumberResponse> getInvalidRandomNumbers(@Query("length") int length);

    @GET("foo.php")
    Call<RandomNumberResponse> getFoo();
}
