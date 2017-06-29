package com.example.workingonretrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.workingonretrofit.R;
import com.example.workingonretrofit.interfaces.FeedsAPI;
import com.example.workingonretrofit.models.Feeds;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    public static String END_POINT = "http://services.hanselandpetal.com";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit();
    }

    private void retrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FeedsAPI feedsAPI = retrofit.create(FeedsAPI.class);

        Call<List<Feeds>> response = feedsAPI.getFeeds();
        response.enqueue(new Callback<List<Feeds>>() {
            @Override
            public void onResponse(Call<List<Feeds>> call, Response<List<Feeds>> response)
            {
                for (Feeds feeds:response.body())
                {
                    Log.i("Id",""+feeds.productId);
                }
            }

            @Override
            public void onFailure(Call<List<Feeds>> call, Throwable t)
            {
                Log.i("Retrofit Error",t.getMessage());
            }
        });

    }
}
