package com.msl.retrotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.msl.retrotest.entity.Comments;
import com.msl.retrotest.entity.Post;
import com.msl.retrotest.network.NetworkService;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize layout textView
        textView = findViewById(R.id.textView1);
        // get
        selectPostById();
    }

    private void selectPostById() {

        NetworkService.getInstance()
                .getJsonApi()
                // api request
                .getPostId(1)
                // callback of post model
                .enqueue(new Callback<Post>() {
                    // відповідь (response) |
                    @Override
                    public void onResponse(@NotNull Call<Post> call, @NotNull Response<Post> response) {
                        // condition if request was good
                        if (response.isSuccessful()) {
                            // in object assign request body
                            Post post = response.body();
                            // from post have access to methods
                            textView.append(Objects.requireNonNull(post).getUserId() + "\n");
                            textView.append(post.getId() + "\n");
                            textView.append(post.getTitle() + "\n");
                            textView.append(post.getBody() + "\n");
                        }
//                        try {
//                            JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
//                            Log.i("jsonObject", jsonObject.getString("title"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        String get = new Gson().toJson(response.body());
//                        Log.i("get123", get);
                    }

                    @Override
                    public void onFailure(@NotNull Call<Post> call, @NotNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}