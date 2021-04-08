package co.com.ceiba.mobile.pruebadeingreso.model.user;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInteractorImpl implements UserInteractor, Callback<List<User>> {

    UserPresenter presenter;
    List<User> usersList;

    public UserInteractorImpl(UserPresenter presenter) {
        this.presenter = presenter;
        usersList = new ArrayList<>();
    }

    @Override
    public void getUsers() {
        Call<List<User>> call = ApiAdapter.getDataUser().getUsers();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if(!response.isSuccessful()){
            //Enviamos respuesta de error a UserView
            presenter.showMessage("Error en la respuesta. Código: " + response.code()); ///---
            return;
        }else {
            usersList = response.body();
            if (usersList != null)
                presenter.showUsers((ArrayList<User>) usersList);
            else
                Log.e("onResponseUser", "Null response service"); ///----
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        presenter.showMessage("Error: " + t.getMessage());
    }
}
