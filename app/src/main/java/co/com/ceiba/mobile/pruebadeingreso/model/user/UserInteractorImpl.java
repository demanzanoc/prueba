package co.com.ceiba.mobile.pruebadeingreso.model.user;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.database.user.GetUserTaskDB;
import co.com.ceiba.mobile.pruebadeingreso.database.user.SaveUserTaskDB;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInteractorImpl implements UserInteractor, Callback<List<User>> {

    private UserPresenter presenter;
    private List<User> usersList;
    private Context context;

    public UserInteractorImpl(UserPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        this.usersList = new ArrayList<>();
    }

    @Override
    public void getUsersFromApi() {
        Call<List<User>> call = ApiAdapter.getDataUser().getUsers();
        call.enqueue(this);
    }

    @Override
    public void getUsersFromDatabase() {
        new GetUserTaskDB(context, new GetUserTaskDB.Callback() {
            @Override
            public void result(ArrayList<User> usersList) {
                if (usersList.isEmpty())
                    getUsersFromApi();
                else{
                    presenter.showUsers(usersList);
                }
            }
        }).execute();
    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if (!response.isSuccessful()) {
            //Enviamos respuesta de error a UserView
            presenter.showMessage("Error en la respuesta. Código: " + response.code()); ///---
        } else {
            usersList = response.body();
            if (usersList != null) {
                presenter.showUsers((ArrayList<User>) usersList);
                new SaveUserTaskDB(context, new SaveUserTaskDB.Callback() {
                    @Override
                    public void result(String result) {
                        presenter.showMessage(result); ///---
                    }
                }).execute((ArrayList<User>) usersList);
            } else {
                Log.e("onResponseUser", "Null response service"); ///---
            }
        }
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        presenter.showMessage("Error: " + t.getMessage());
    }
}
