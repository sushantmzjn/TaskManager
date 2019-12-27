package com.sushant.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sushant.taskmanager.API.UsersAPI;
import com.sushant.taskmanager.Url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private Button Login;
    private EditText username, password;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.btnLogin);
        username = findViewById(R.id.etusername);
        password = findViewById(R.id.etpassword);
        signup = findViewById(R.id.tvsignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }

    private void checkUser() {
        final String uname = username.getText().toString().trim();
        final String pass = password.getText().toString().trim();

        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<Void> voidCall = usersAPI.checkUsers(uname, pass);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Login.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Login.this, "login Denied" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
