package co.com.ceiba.mobile.pruebadeingreso.presenter.user;

import java.util.ArrayList;

import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserInteractor;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserPresenter;
import co.com.ceiba.mobile.pruebadeingreso.interfaces.user.UserView;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.model.user.UserInteractorImpl;

public class UserPresenterImpl implements UserPresenter {

    UserView view;
    UserInteractor interactor;

    public UserPresenterImpl(UserView view) {
        this.view = view;
        this.interactor = new UserInteractorImpl(this);
    }

    @Override
    public void showUsers(ArrayList<User> users) {
        view.showUsers(users);
    }

    @Override
    public void showMessage(String message) {
        view.showMessage(message);
    }

    @Override
    public void getUsers() {
        interactor.getUsers();
    }
}
