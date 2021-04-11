package co.com.ceiba.mobile.pruebadeingreso.model.post;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.database.user.SaveUserTaskDB;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostInteractorImpl implements PostInteractor, Callback<List<Post>> {

    private List<Post> postsList;
    private PostPresenter presenter;
    private Context context;

    public PostInteractorImpl(PostPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        this.postsList = new ArrayList<>();
    }

    @Override
    public void getUserPosts(User user) {
        Call<List<Post>> call = ApiAdapter.getDataUser().getUserPosts(user.getUserId());
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        if (!response.isSuccessful()) {
            presenter.showMessage("Error en la respuesta. Código: " + response.code());
        } else {
            postsList = response.body();
            if (postsList != null) {
                presenter.showUserPosts((ArrayList<Post>) postsList);
            } else {
                Log.e("onResponsePost", "Null response service");
            }
        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {
        presenter.showMessage("Error: " + t.getLocalizedMessage());
    }
}
