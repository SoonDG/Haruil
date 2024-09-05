package com.sundg.haruil.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sundg.haruil.Contract.RegisterContract;
import com.sundg.haruil.Presenter.RegisterPresenter;
import com.sundg.haruil.R;
import com.sundg.haruil.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {
    private ActivityRegisterBinding binding;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new RegisterPresenter(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.registerBtnRegister.setOnClickListener(new View.OnClickListener() { //회원가입 버튼 클릭 시
            @Override
            public void onClick(View view) {
                String email = binding.registerTextEmail.getText().toString();
                String password = binding.registerTextPassword.getText().toString();
                String repeatPassword = binding.registerTextRepeatPassword.getText().toString();
                if(password.length() < 6){ //만약 비밀번호를 6자리 미만으로 설정했다면
                    Toast toast = Toast.makeText(RegisterActivity.this, "비밀번호는 6자 이상이어야 합니다.", Toast.LENGTH_SHORT);
                    toast.show(); //비밀번호의 길이를 6자리 이상으로 해줄 것을 요청하는 메시지를 띄움
                }
                else if(!password.equals(repeatPassword)){ //만약 비밀번호가 일치하지 않는다면
                    Toast toast = Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않음", Toast.LENGTH_SHORT);
                    toast.show(); //비밀번호가 일치하지 않음을 알리는 메시지를 띄움
                }
                else {
                    presenter.register(email, password); //presenter에게 입력한 이메일과 비밀번호 전달.
                }
            }
        });
    }

    public void toLogin(){
        finish(); //회원가입 성공 후 회원가입 액티비티는 스택에서 제거
    }

    public void warningRegisterFailed(){
        Toast toast = Toast.makeText(RegisterActivity.this, "회원가입 실패", Toast.LENGTH_SHORT);
        toast.show();
    }
}