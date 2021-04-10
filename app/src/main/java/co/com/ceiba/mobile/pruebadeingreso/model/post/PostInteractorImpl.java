package co.com.ceiba.mobile.pruebadeingreso.model.post;

import android.content.Context;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class PostInteractorImpl implements PostInteractor {

    private ArrayList<Post> postsList;
    private PostPresenter presenter;
    private Context context;

    public PostInteractorImpl(PostPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        this.postsList = new ArrayList<>();
    }

    @Override
    public void getUserPosts(User user) {

    }
}
