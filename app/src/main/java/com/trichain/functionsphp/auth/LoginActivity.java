package com.trichain.functionsphp.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.trichain.functionsphp.R;
import com.trichain.functionsphp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_login);
    }

    public void validate(View view){
        if (b.emailED.getText().toString().isEmpty()){
            b.emailED.setError("Please fill this");
            b.emailED.requestFocus();
        }else if (b.passwordED.getText().toString().isEmpty()){
            b.passwordED.setError("Please fill this");
            b.passwordED.requestFocus();
        }else if (!b.emailED.getText().toString().contains("@")){
            b.emailED.setError("Please enter a valid email");
            b.emailED.requestFocus();
        }else{
            networkLogin();
        }
    }

    private void networkLogin() {
        b.progressCircular.show();
        b.progressCircular.hide();
    }
}