package co.com.ceiba.mobile.pruebadeingreso.interfaces.rest;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET(Endpoints.GET_USERS)
    Call<List<User>> getUsers();

}
