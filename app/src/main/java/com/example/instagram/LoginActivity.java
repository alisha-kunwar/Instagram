package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";

    private ImageView ivImage;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(ParseUser.getCurrentUser() != null){
            goMainActivity();
        }


        ivImage = findViewById(R.id.ivImage);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username= etUsername.getText().toString();
                String password = etPassword.getText().toString();
                ParseUser user = new ParseUser();

                user.setPassword(password);
                user.setUsername(username);
                user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login");
                    Toast.makeText(LoginActivity.this, "Issue with login", Toast.LENGTH_SHORT);

                } else {
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT);
                    goMainActivity();
                }
            }
                });
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username= etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);

            }
        });

    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user" + username);

        //navigate to main activity if credantials are correct
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!= null)
                {
                    Log.e(TAG, "Issue with login");
                    Toast.makeText(LoginActivity.this, "Issue with login" , Toast.LENGTH_SHORT);

                    return;
                }

                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success" , Toast.LENGTH_SHORT);

            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

}