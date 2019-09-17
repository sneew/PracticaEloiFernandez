package com.example.practicapp.retrofit;

import com.example.practicapp.model.Ghibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {

    @GET("films/")
    Call<List<Ghibli>> listGhiblis();

}
