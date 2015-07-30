package com.example.retrofittest.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by cloud on 22/7/15.
 */
public class ServiceFactory {
    // replace base url here
    private static String SERVICES_URL = "";
    public static ApiService apiService = null;


    public static ApiService GetApiService(){
        if (apiService!= null)
            return apiService;

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
			public void intercept(RequestFacade request) {
				request.addHeader("Content-Type", "application/json");
			}
		};

		Gson gson = new GsonBuilder()
	    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	    .create();

		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(SERVICES_URL)
				.setConverter(new GsonConverter(gson))
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setRequestInterceptor(requestInterceptor).build();

		apiService = restAdapter.create(ApiService.class);

		return apiService;

    }
}
