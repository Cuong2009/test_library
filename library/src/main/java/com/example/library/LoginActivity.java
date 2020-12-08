package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userText;

    private EditText passWordText;

    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        init();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton();
            }
        });
    }

    private void init() {

        userText = (EditText) findViewById(R.id.user_edit_text);
        passWordText = (EditText) findViewById(R.id.pass_edit_text);
        loginButton = (Button) findViewById(R.id.login_button);
    }

    private boolean validateLogin(String user, String pass) {
        if (user.equals("")) {
            Toast.makeText(this, "Please enter information in the user ",
                    Toast.LENGTH_SHORT).show();
            return false;

        } else if (pass.equals("")) {
            Toast.makeText(this, "Please enter information in the  ",
                    Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }

    private void loginButton() {
        final String user = userText.getText().toString();
        final String pass = passWordText.getText().toString();

        if (!validateLogin(user, pass)) {
            return;
        }
        // call api
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);


    }
}