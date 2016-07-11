package com.example;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private OkHttpClient httpClient;

    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://qrng.anu.edu.au/API/")
                .client(client)
                .build();
    }

    @Bean
    public RandomNumberService randomNumberService(Retrofit retrofit) {
        return retrofit.create(RandomNumberService.class);
    }
}
