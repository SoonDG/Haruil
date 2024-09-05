package com.sundg.haruil.Contract;

public interface RegisterContract
{
    interface Presenter{
        public void register(String email, String password);
    }

    interface View{
        public void toLogin();

        public void warningRegisterFailed();
    }
}
