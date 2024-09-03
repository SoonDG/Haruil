package com.sundg.haruil.Presenter;

import com.sundg.haruil.Contract.LoginContract;
import com.sundg.haruil.Model.User;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private User user;

    public LoginPresenter(LoginContract.View view){
        this.view = view;
        user = new User();
    }

    public void emailLogin(String email, String password){
        boolean login = user.emailLogin(email, password);
        if(login){
            view.toMain();
        }
        else {
            view.warningAuthenticationFailed();
        }
    }
}
