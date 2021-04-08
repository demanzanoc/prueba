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
import co.com.ceiba.mobile.pruebadeingreso.model.adapter.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class MainActivity extends Activity {

    Context context;
    EditText editTextSearch;
    RecyclerView recyclerViewSearchResults;
    List<User> userList;

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
                Toast.makeText(context,"" + editable, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        context = getApplicationContext();
        editTextSearch = findViewById(R.id.editTextSearch);
        recyclerViewSearchResults = findViewById(R.id.recyclerViewSearchResults);
        userList = new ArrayList<>();
        userList.add(new User("david","318","email@email"));
        userList.add(new User("david2","3182","email@email2"));
        userList.add(new User("david3","3183","email@email3"));

        UserAdapter userAdapter = new UserAdapter(userList, context);
        recyclerViewSearchResults.setHasFixedSize(true);
        recyclerViewSearchResults.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSearchResults.setAdapter(userAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}