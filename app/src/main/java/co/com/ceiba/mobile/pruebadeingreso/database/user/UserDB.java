package co.com.ceiba.mobile.pruebadeingreso.database.user;

import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.database.instance.AppDatabase;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public class UserDB {

    public UserDB() {
    }

    public static void saveUsersDB(Context context, List<User> usersList) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        for (User user : usersList) {
            appDatabase.userDao().insertAll(user);
        }
    }

    public static List<User> getUsersDB(Context context) {
        return AppDatabase.getInstance(context).userDao().getAll();
    }

}
