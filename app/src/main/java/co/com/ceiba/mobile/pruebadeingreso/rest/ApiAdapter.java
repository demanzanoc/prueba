package co.com.ceiba.mobile.pruebadeingreso.rest;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.rest.JsonApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private ApiAdapter() {
    }

    private static JsonApi jsonApi;

    public static JsonApi getDataUser() {
        if (jsonApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Endpoints.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            jsonApi = retrofit.create(JsonApi.class);
        }
        return jsonApi;
    }

}
