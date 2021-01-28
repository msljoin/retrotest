package com.msl.retrotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.msl.retrotest.R;
import com.msl.retrotest.entity.Comments;
import com.msl.retrotest.entity.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);

//        getComments();
//        getSortPosts();
//        selectPostById();
//        createPost();
        updatePost();
//        deletePost();
    }

    private void deletePost() {

        NetworkService
                .getInstance()
                .getJsonApi()
                .deletePost(5)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        textView.setText(response.code());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private void updatePost() {

        Post post = new Post(12,null,"New body");

        NetworkService
                .getInstance()
                .getJsonApi()
                .patchPost(5,post)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        if (response.isSuccessful()) {
                            Post post = response.body();

                            if ( post == null) {
                                return;
                            }

                            String content = "";
                            content+= "Code:" + response.code() + "\n";
                            content+= "Id = " + post.getId() + "\n";
                            content+= "userId = " + post.getUserId() + "\n";
                            content+= "title = " + post.getTitle() + "\n";
                            content+= "body = " + post.getBody() + "\n" + "\n";

                            textView.setText(content);
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });
    }

    private void createPost() {
        Post post = new Post(23, "Title", "Text Qwerty");

        Map<String,String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title",  "New");

        NetworkService
                .getInstance()
                .getJsonApi()
                .createPost(fields)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if (response.isSuccessful()) {
                            Post post = response.body();

                            if ( post == null) {
                                return;
                            }

                            String content = "";
                            content+= "Code:" + response.code() + "\n";
                            content+= "Id = " + post.getId() + "\n";
                            content+= "userId = " + post.getUserId() + "\n";
                            content+= "title = " + post.getTitle() + "\n";
                            content+= "body = " + post.getBody() + "\n" + "\n";

                            textView.setText(content);
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                    }
                });
    }

    private void getSortPosts() {
        // Call retrofit service to get post from API
        NetworkService.getInstance()
                .getJsonApi()
                .getPosts(new int[] {1,2,4},"id", "desc")
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                        if (response.isSuccessful()) {

                            List<Post> posts = response.body();

                            if ( posts == null) {
                                return;
                            }

                            for (Post post : posts) {
                                String content = "";
                                content+= "Id = " + post.getId() + "\n";
                                content+= "userId = " + post.getUserId() + "\n";
                                content+= "title = " + post.getTitle() + "\n";
                                content+= "body = " + post.getBody() + "\n" + "\n";

                                textView.append(content);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {
                        t.printStackTrace();
                        textView.setText(t.getMessage());
                    }
                });
    }

    private void getComments() {
        NetworkService.getInstance()
                .getJsonApi()
                .getComments(1,"id","desc")
                .enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (response.isSuccessful()) {

                    List<Comments> comments = response.body();

                    if (comments == null) {
                        return;
                    }

                    for (Comments comment : comments) {
                        String content = "";
                        content+= "Id = " + comment.getId() + "\n";
                        content+= "postId = " + comment.getPostId() + "\n";
                        content+= "title = " + comment.getName() + "\n";
                        content+= "body = " + comment.getEmail() + "\n";
                        content+= "body = " + comment.getBody()+ "\n" + "\n";

                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }

    private void selectPostById() {

        NetworkService.getInstance()
                .getJsonApi()
                .getPostId(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        Post post = response.body();

                        textView.append(Objects.requireNonNull(post).getUserId() + "\n");
                        textView.append(post.getId() + "\n");
                        textView.append(post.getTitle() + "\n");
                        textView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}