package com.example.anuraggupta.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonCustomer;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonCustomer=(Button)findViewById(R.id.buttonCustomer);
        buttonCustomer.setOnClickListener(this);

    }
    public void head()
    {
        startActivity(new Intent(getApplicationContext(),customer.class));
    }
    public void onClick(View view)
    {
        if(view==buttonCustomer)
            head();
    }
}
