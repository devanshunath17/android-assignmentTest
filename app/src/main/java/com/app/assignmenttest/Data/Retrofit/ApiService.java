package com.app.assignmenttest.Data.Retrofit;



import com.app.assignmenttest.Ui.Entity.NameOfFacts;
import com.app.assignmenttest.Utils.StaticData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public interface ApiService {
/*
* call api for geting the List
* */
    @GET(StaticData.GET_LIST)
    Call<NameOfFacts> getFacts();
}
