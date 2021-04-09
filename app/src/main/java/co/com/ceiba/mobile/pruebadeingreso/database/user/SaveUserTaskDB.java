package co.com.ceiba.mobile.pruebadeingreso.database.user;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class SaveUserTaskDB extends AsyncTask<ArrayList<User>, Void, String>{

    private Context context;
    private Callback callback;

    public SaveUserTaskDB(Context context, Callback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected String doInBackground(ArrayList<User>... usersList) {
        UserDB.saveUsers(context, usersList[0]);
        return "Datos almacenados con exito";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        callback.result(result);
    }

    public interface Callback{
        void result(String result);
    }

}
