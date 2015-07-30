package com.example.retrofittest.Service;

import com.example.retrofittest.Model.Phones;
import com.example.retrofittest.Model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by cloud on 22/7/15.
 */
public interface ApiService {
    @POST("/api/v1/lookup_contacts")
    public void lookupUserByPhone(@Query("phones") String phone, Callback<List<User>> cb);

    @POST("/api/v1/lookup_contacts")
	public void lookupContacts(@Body Phones phones, Callback<List<User>> cb);

}
