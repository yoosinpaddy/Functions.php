package com.trichain.functionsphp.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.trichain.functionsphp.R;
import com.trichain.functionsphp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
    }
    public void validate(View v){
        if (b.emailED.getText().toString().isEmpty()){
            b.emailED.setError("Please fill this");
            b.emailED.requestFocus();
        }else if (b.passwordED.getText().toString().isEmpty()){
            b.passwordED.setError("Please fill this");
            b.passwordED.requestFocus();
        }else if (!b.emailED.getText().toString().contains("@")){
            b.emailED.setError("Please enter a valid email");
            b.emailED.requestFocus();
        }else if (b.rPasswordED.getText().toString().isEmpty()){
            b.rPasswordED.setError("Please fill this");
            b.rPasswordED.requestFocus();
        }else if (!b.passwordED.getText().toString().contentEquals(b.rPasswordED.getText().toString())){
            b.passwordED.setError("Passwords don't match");
            b.passwordED.requestFocus();
        }else if (b.genderRG.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Kindly select the gender", Toast.LENGTH_SHORT).show();
        }else{
            networkRegister();
        }
    }
    public void loginRedirect(View v){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        RegisterActivity.this.finish();
    }

    private void networkRegister() {
        b.progressCircular.show();

        b.progressCircular.hide();
    }
}