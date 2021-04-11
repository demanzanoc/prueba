package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.post.PostView;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.PostAdapter;
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.UserAdapter;
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
    private ArrayList<Post> postsList;

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
        postsList = new ArrayList<>();
        PostPresenter presenter = new PostPresenterImpl(this, context);

        userName.setText(user.getUserName());
        userPhone.setText(user.getUserPhone());
        userEmail.setText(user.getUserEmail());
        presenter.getUserPosts(user);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showUserPosts(ArrayList<Post> postsList) {
        this.postsList = postsList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        PostAdapter postAdapter = new PostAdapter(this.postsList);
        userPostsResults.setLayoutManager(linearLayoutManager);
        userPostsResults.setAdapter(postAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
    }
}
