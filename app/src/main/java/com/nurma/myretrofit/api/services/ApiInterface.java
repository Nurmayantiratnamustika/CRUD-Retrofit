package com.nurma.myretrofit.api.services;


import com.nurma.myretrofit.api.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("mahasiswa")
    Call<List<Post>> getSemuaMahasiswa();

    @FormUrlEncoded
    @POST("mahasiswa")
    Call<Post> createPost(@Field("nim") String nim,
                          @Field("nama") String nama,
                          @Field("alamat") String alamat,
                          @Field("jeniskelamin") String jeniskelamin,
                          @Field("telepon") String telepon);

    @FormUrlEncoded
    @PUT("mahasiswa")
    Call<Post> updatePost(@Field("nim") String nim,
                          @Field("nama") String nama,
                          @Field("alamat") String alamat,
                          @Field("jeniskelamin") String jeniskelamin,
                          @Field("telepon") String telepon);

}

