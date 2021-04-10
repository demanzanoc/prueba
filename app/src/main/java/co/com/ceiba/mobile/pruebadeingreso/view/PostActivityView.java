package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostView;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.model.post.Post;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.presenter.post.PostPresenterImpl;
import co.com.ceiba.mobile.pruebadeingreso.presenter.user.UserPresenterImpl;

public class PostActivityView extends Activity implements PostView {

    private Context context;
    private TextView userName;
    private TextView userPhone;
    private TextView userEmail;
    private RecyclerView userPostsResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        User user = (User) getIntent().getSerializableExtra("User");
        initViews(user);
    }

    private void initViews(User user) {
        context = getApplicationContext();
        userName = findViewById(R.id.name);
        userPhone = findViewById(R.id.phone);
        userEmail = findViewById(R.id.email);
        userPostsResults = findViewById(R.id.recyclerViewPostsResults);
        PostPresenter presenter = new PostPresenterImpl(this, context);
        presenter.getUserPosts(user);
        userName.setText(user.getUserName());
        userPhone.setText(user.getUserPhone());
        userEmail.setText(user.getUserEmail());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showUserPosts(ArrayList<Post> posts) {

    }
}
