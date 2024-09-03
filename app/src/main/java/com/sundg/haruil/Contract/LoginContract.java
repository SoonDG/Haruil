package com.sundg.haruil.Contract;

public interface LoginContract
{
    interface Presenter{
        public void emailLogin(String email, String password);

    }

    interface View{
        public void toMain();

        public void warningAuthenticationFailed();
    }
}
