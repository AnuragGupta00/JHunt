package com.example.anuraggupta.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

public class CredentialsActivity extends AppCompatActivity {

    
    private EditText edittextName;
    private EditText edittextAddress;
    private EditText edittextMobileno;
    private Button registerUser;
    private Firebase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);


        edittextName = (EditText) findViewById(R.id.editTextName);
        edittextAddress = (EditText) findViewById(R.id.editTextAddress);
        edittextMobileno  = (EditText) findViewById(R.id.editTextMob);

        registerUser = (Button) findViewById(R.id.buttonRegister);
        database = new Firebase("https://fir-authdemo-17a7e.firebaseio.com");

    }
}
