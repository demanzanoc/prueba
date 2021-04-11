package co.com.ceiba.mobile.pruebadeingreso.presenter.post;

import android.content.Context;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostView;
import co.com.ceiba.mobile.pruebadeingreso.model.post.Post;
import co.com.ceiba.mobile.pruebadeingreso.model.post.PostInteractorImpl;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class PostPresenterImpl implements PostPresenter {

    private PostView view;
    private PostInteractor interactor;

    public PostPresenterImpl(PostView view, Context context) {
        this.view = view;
        this.interactor = new PostInteractorImpl(this, context);
    }

    @Override
    public void showUserPosts(ArrayList<Post> postsList) {
        view.showUserPosts(postsList);
    }

    @Override
    public void getUserPosts(User user) {
        interactor.getUserPosts(user);
    }

    @Override
    public void showMessage(String message) {
        view.showMessage(message);
    }
}
