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
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserView;
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.presenter.user.UserPresenterImpl;

public class MainActivityImpl extends Activity implements UserView {

    Context context;
    EditText editTextSearch;
    RecyclerView recyclerViewSearchResults;
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(context, "" + editable, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        context = getApplicationContext();
        editTextSearch = findViewById(R.id.editTextSearch);
        recyclerViewSearchResults = findViewById(R.id.recyclerViewSearchResults);
        presenter = new UserPresenterImpl(this);
        presenter.getUsers();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showUsers(ArrayList<User> usersList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        UserAdapter userAdapter = new UserAdapter(usersList, context);
        recyclerViewSearchResults.setLayoutManager(linearLayoutManager);
        recyclerViewSearchResults.setAdapter(userAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
    }
}