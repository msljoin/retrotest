package com.msl.retrotest.utils;

import com.msl.retrotest.entity.Comments;
import com.msl.retrotest.entity.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlaceHolderApi {
    // select by id post
    @GET("/posts/{id}")
    Call<Post> getPostId(@Path("id") int id);

    // Select all posts from web service
    @GET("/posts")
    Call<List<Post>> getPosts(@Query("userId") int [] userId,
                              @Query("_sort") String sort,
                              @Query("_order") String oder);

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{id}/comments")
    Call<List<Comments>> getComments(@Query("userId") int userId,
                                     @Query("sort") String sort,
                                     @Query("order") String oder
    );

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
