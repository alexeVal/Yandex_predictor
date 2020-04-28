package com.example.yandex_predictor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("api/v1/predict/complete")
    Call<ModelJSON> getword(@Query("key") String key,@Query("q") String q, @Query("lang") String lang);
}
