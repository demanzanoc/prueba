package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserView;
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.EmptyAdapter;
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.presenter.user.UserPresenterImpl;
import co.com.ceiba.mobile.pruebadeingreso.utils.DialogCaller;

public class MainActivityView extends Activity implements UserView {

    private Context context;
    private EditText editTextSearch;
    private RecyclerView recyclerViewSearchResults;
    private UserAdapter userAdapter;
    private EmptyAdapter emptyAdapter;
    private ArrayList<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Unnecessary
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Unnecessary
            }

            @Override
            public void afterTextChanged(Editable filter) {
                userFilter(filter.toString());
            }
        });
    }

    private void initViews() {
        context = getApplicationContext();
        editTextSearch = findViewById(R.id.editTextSearch);
        recyclerViewSearchResults = findViewById(R.id.recyclerViewSearchResults);
        UserPresenter presenter = new UserPresenterImpl(this, context);
        DialogCaller.showDialog(this);
        presenter.getUsersFromDatabase();
    }

    private void userFilter(String filter) {
        ArrayList<User> userFilter = new ArrayList<>();
        for (User user : usersList) {
            if (user.getUserName().toLowerCase().contains(filter.toLowerCase())) {
                userFilter.add(user);
            }
        }
        userAdapter = new UserAdapter(userFilter);
        recyclerViewSearchResults.setAdapter(userAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showUsers(ArrayList<User> usersList) {
        this.usersList = usersList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        userAdapter = new UserAdapter(this.usersList);
        recyclerViewSearchResults.setLayoutManager(linearLayoutManager);
        recyclerViewSearchResults.setAdapter(userAdapter);
        DialogCaller.dismissDialog();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
        DialogCaller.dismissDialog();
    }
}