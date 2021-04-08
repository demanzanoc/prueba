package co.com.ceiba.mobile.pruebadeingreso.rest;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.JsonPlaceHolderApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private ApiAdapter() {
    }

    private static JsonPlaceHolderApi jsonPlaceHolderApi;

    public static JsonPlaceHolderApi getJsonPlaceHolderApi() {

        if (jsonPlaceHolderApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Endpoints.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        }
        return jsonPlaceHolderApi;
    }

}
