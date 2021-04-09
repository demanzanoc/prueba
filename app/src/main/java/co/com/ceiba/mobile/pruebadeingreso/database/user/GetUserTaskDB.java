package co.com.ceiba.mobile.pruebadeingreso.database.user;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class GetUserTaskDB extends AsyncTask<String, Void, ArrayList<User>> {

    private Context context;
    private Callback callback;

    public GetUserTaskDB(Context context, Callback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected ArrayList<User> doInBackground(String... strings) {
        return (ArrayList<User>) UserDB.getUsersDB(context);
    }

    @Override
    protected void onPostExecute(ArrayList<User> usersList) {
        super.onPostExecute(usersList);
        callback.result(usersList);
    }

    public interface Callback{
        void result(ArrayList<User> usersList);
    }

}
