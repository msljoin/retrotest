package com.msl.retrotest.utils;

import com.msl.retrotest.entity.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceHolderApi {
    // select by id post
    @GET("/posts/{id}")
    Call<Post> getPostId(@Path("id") int id);

    // Select all posts from web service
    @GET("/posts")
    Call<List<Post>> getPosts(@Query("id") int after, @Query("id") int before);

    @GET("/posts")
    Call<List<Post>> getPosts();
}
