package com.app.assignmenttest.Utils;

import retrofit2.Response;
/**
 * Created by Devanshu 26 july 2018
 */

public class NetworkException extends Exception {

    private Response mResponse;

    public NetworkException(Response response) {
        mResponse = response;
    }

    public Response getResponse() {
        return mResponse;
    }
}
