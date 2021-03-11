package com.msl.retrotest;

import android.util.Log;

import com.google.gson.Gson;
import com.msl.retrotest.entity.Comments;
import com.msl.retrotest.entity.Post;
import com.msl.retrotest.network.NetworkService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Garbage {

    private void garbageHolder() {
        //        getComments();
        //        getSortPosts();
        //        createPost();
        //        updatePost();
        //        deletePost();
    }

//    private void deletePost() {
//
//        NetworkService
//                .getInstance()
//                .getJsonApi()
//                .deletePost(5)
//                .enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//                        textView.setText(response.code());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Void> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
//    }

//    private void updatePost() {
//
//        Post post = new Post(12,null,"New body");
//
//        NetworkService
//                .getInstance()
//                .getJsonApi()
//                .patchPost(5,post)
//                .enqueue(new Callback<Post>() {
//                    @Override
//                    public void onResponse(Call<Post> call, Response<Post> response) {
//
//                        if (response.isSuccessful()) {
//                            Post post = response.body();
//
//                            if ( post == null) {
//                                return;
//                            }
//
//                            String get = new Gson().toJson(response.body());
//                            Log.i("get123", get);
////                            String content = "";
////                            content+= "Code:" + response.code() + "\n";
////                            content+= "Id = " + post.getId() + "\n";
////                            content+= "userId = " + post.getUserId() + "\n";
////                            content+= "title = " + post.getTitle() + "\n";
////                            content+= "body = " + post.getBody() + "\n" + "\n";
//
//                            textView.setText(get);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Post> call, Throwable t) {
//
//                    }
//                });
//    }
//
//    private void createPost() {
//        Post post = new Post(23, "Title", "Text Qwerty");
//
//        Map<String,String> fields = new HashMap<>();
//        fields.put("userId", "25");
//        fields.put("title",  "New");
//
//        NetworkService
//                .getInstance()
//                .getJsonApi()
//                .createPost(fields)
//                .enqueue(new Callback<Post>() {
//                    @Override
//                    public void onResponse(Call<Post> call, Response<Post> response) {
//                        if (response.isSuccessful()) {
//                            Post post = response.body();
//
//                            if ( post == null) {
//                                return;
//                            }
//
//                            String content = "";
//                            content+= "Code:" + response.code() + "\n";
//                            content+= "Id = " + post.getId() + "\n";
//                            content+= "userId = " + post.getUserId() + "\n";
//                            content+= "title = " + post.getTitle() + "\n";
//                            content+= "body = " + post.getBody() + "\n" + "\n";
//
//                            textView.setText(content);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Post> call, Throwable t) {
//
//                    }
//                });
//    }
//
//    private void getSortPosts() {
//        // Call retrofit service to get post from API
//        NetworkService.getInstance()
//                .getJsonApi()
//                .getPosts(new int[] {1,2,4},"id", "desc")
//                .enqueue(new Callback<List<Post>>() {
//                    @Override
//                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                        if (response.isSuccessful()) {
//
//                            List<Post> posts = response.body();
//
//                            if ( posts == null) {
//                                return;
//                            }
//
//                            for (Post post : posts) {
//                                String content = "";
//                                content+= "Id = " + post.getId() + "\n";
//                                content+= "userId = " + post.getUserId() + "\n";
//                                content+= "title = " + post.getTitle() + "\n";
//                                content+= "body = " + post.getBody() + "\n" + "\n";
//
//                                textView.append(content);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Post>> call, Throwable t) {
//                        t.printStackTrace();
//                        textView.setText(t.getMessage());
//                    }
//                });
//    }
//
//    private void getComments() {
//        NetworkService.getInstance()
//                .getJsonApi()
//                .getComments(1,"id","desc")
//                .enqueue(new Callback<List<Comments>>() {
//                    @Override
//                    public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
//                        if (response.isSuccessful()) {
//
//                            List<Comments> comments = response.body();
//
//                            if (comments == null) {
//                                return;
//                            }
//
//                            String get = new Gson().toJson(response.body());
//                            Log.i("get123", get);
////                    for (Comments comment : comments) {
////                        String content = "";
////                        content+= "Id = " + comment.getId() + "\n";
////                        content+= "postId = " + comment.getPostId() + "\n";
////                        content+= "title = " + comment.getName() + "\n";
////                        content+= "body = " + comment.getEmail() + "\n";
////                        content+= "body = " + comment.getBody()+ "\n" + "\n";
////
////                        textView.append(content);
////                    }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Comments>> call, Throwable t) {
//
//                    }
//                });
//    }
}
