package co.com.ceiba.mobile.pruebadeingreso.interfaces.user;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.model.user.User;

public interface UserView {

    void showUsers(ArrayList<User> usersList);

    void showMessage(String message);

}
