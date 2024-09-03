package com.sundg.haruil.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sundg.haruil.Contract.LoginContract;
import com.sundg.haruil.Presenter.LoginPresenter;
import com.sundg.haruil.R;
import com.sundg.haruil.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        presenter = new LoginPresenter(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.loginBtnLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.loginTextEmail.getText().toString();
                String password = binding.loginTextPassword.getText().toString();
                presenter.emailLogin(email, password);
            }
        }));

        binding.loginBtnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void toMain(){

    }

    public void warningAuthenticationFailed(){

    }

}