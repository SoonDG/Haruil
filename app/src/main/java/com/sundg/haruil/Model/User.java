package com.sundg.haruil.Model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User {
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String uid;

    public User(){
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public boolean emailLogin(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    firebaseUser = firebaseAuth.getCurrentUser();
                    uid = firebaseUser.getUid();
                }
            }
        });
        if(firebaseUser != null){
            return true;
        }
        else {
            return false;
        }
    }

    public String getUid(){
        return uid;
    }
}
