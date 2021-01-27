package com.msl.retrotest.utils;

import com.msl.retrotest.entity.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceHolderApi {
    @GET("/posts/{id}")
    Call<Post> getPostId(@Path("id") int id);
    @GET("/posts")
    Call<List<Post>> getPosts(@Query("userId") int id);
}
