package com.app.assignmenttest.Data.Retrofit;




import com.app.assignmenttest.Utils.StaticData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public class ApiClient {

    private static Retrofit retrofit = null;

    private ApiClient() {
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(StaticData.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

}
