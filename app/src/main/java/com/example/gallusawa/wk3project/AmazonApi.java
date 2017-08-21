package com.example.gallusawa.wk3project;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by gallusawa on 8/21/17.
 */

public class AmazonApi {
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com";

    public static Retrofit getClient() {
        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()

                    .build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public interface AmazonCalls {
        public static final String PATH = "books.json";

        @GET(PATH)
        Call<ArrayList<Books>> getAmazonBook(
        );

    }

}