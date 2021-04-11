package co.com.ceiba.mobile.pruebadeingreso.interfaces.post;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.model.post.Post;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public interface PostPresenter {

    void showUserPosts(ArrayList<Post> posts);

    void getUserPosts(User user);

    void showMessage(String message);

}
