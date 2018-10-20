package com.example.anuraggupta.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

public class CredentialsActivity extends AppCompatActivity {


    private EditText edittextName;
    private EditText edittextAddress;
    private EditText edittextMobileno;
    private Button registerUser;
    private Firebase rootdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Firebase.setAndroidContext(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);


        edittextName = (EditText) findViewById(R.id.editTextName);
        edittextAddress = (EditText) findViewById(R.id.editTextAddress);
        edittextMobileno = (EditText) findViewById(R.id.editTextMob);

        registerUser = (Button) findViewById(R.id.buttonRegister);
        rootdatabase = new Firebase("https://fir-authdemo-17a7e.firebaseio.com/Users");

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edittextName.getText().toString();
                String address = edittextAddress.getText().toString();
                String mobileno = edittextMobileno.getText().toString();

                Firebase x =    rootdatabase.push();
                Firebase child1 = x.child("Name");
                child1.setValue(name);
                Firebase child3 = x.child("Address");
                child3.setValue(address);
                Firebase child2 = x.child("Mobile no");
                child2.setValue(mobileno);



            }


        });
    }

}


