package com.sundg.haruil.Presenter;

import com.sundg.haruil.Contract.RegisterContract;
import com.sundg.haruil.Model.User;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private User user;

    public RegisterPresenter(RegisterContract.View view){
        this.view = view;
        user = new User();
    }

    public void register(String email, String password){
        user.register(email, password);
        if(user.getLoginState()){ //회원가입이 완료되어 현재 로그인된 상태라면
            user.logout(); //사용자가 정보를 확인할 수 있도록 회원 가입 완료시 로그 아웃 후
            view.toLogin(); // 로그인 화면으로 전환
        }
        else {

        }
    }
}
