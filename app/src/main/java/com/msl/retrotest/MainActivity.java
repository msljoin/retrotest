package com.msl.retrotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.msl.retrotest.R;
import com.msl.retrotest.entity.Post;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView1);

        NetworkService.getInstance()
                .getJsonApi()
                .getPostId(1)
                .enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                try {

                    Post post = response.body();

                    textView.append(Objects.requireNonNull(post).getUserId() + "\n");
                    textView.append(post.getId() + "\n");
                    textView.append(post.getTitle() + "\n");
                    textView.append(post.getBody() + "\n");
                }
                catch (NullPointerException exception) {

                    System.out.println("wqew");
                }


                if ( response.body() == null) {
                    throw new NullPointerException();
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                textView.append("Error occurred while getting request!");
                t.printStackTrace();
            }
        });

    }

}