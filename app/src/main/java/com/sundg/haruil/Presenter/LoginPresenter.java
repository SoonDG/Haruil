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
        boolean login = user.emailLogin(email, password); //user 모델에게 정보 전달 후 로그인 성공 여부를 받음
        if(login){ //로그인 성공 시
            view.toMain(); //뷰를 통해 메인 화면으로 전환
        }
        else { //로그인 실패 시
            view.warningAuthenticationFailed(); //뷰를 통해 로그인 실패 오류 메시지를 띄움
        }
    }
}
