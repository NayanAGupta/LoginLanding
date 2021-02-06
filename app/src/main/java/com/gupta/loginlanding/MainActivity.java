package com.gupta.loginlanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;

    ArrayList<User> users = new ArrayList<User>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        users.add(new User("Nayan" , "monke", 1));
        users.add(new User("Kat" , "doge", 2));
        users.add(new User("Zed" , "snek", 3));
        users.add(new User("Miles" , "phrog", 4));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean found = false;
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getUsername().equals(username.getText().toString())
                            && users.get(i).getPassword().equals(password.getText().toString())) {
                        found = true;
                        Toast.makeText(MainActivity.this,"Welcome " + username.getText().toString(),Toast.LENGTH_LONG).show();

                        int id = users.get(i).getId();

                        Intent myIntent = new Intent(MainActivity.this, WelcomePage.class);
                        myIntent.putExtra("id", id);
                        startActivity(myIntent);
                    }
                }
                if(!found) {
                    Toast.makeText(MainActivity.this,"Incorrect Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}