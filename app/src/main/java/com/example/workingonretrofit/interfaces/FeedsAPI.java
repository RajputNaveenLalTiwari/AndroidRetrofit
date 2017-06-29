package com.example.workingonretrofit.interfaces;

import com.example.workingonretrofit.models.Feeds;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 2114 on 26-06-2017.
 */

public interface FeedsAPI
{
    @GET("/feeds/flowers.json")
    Call<List<Feeds>> getFeeds();
}
