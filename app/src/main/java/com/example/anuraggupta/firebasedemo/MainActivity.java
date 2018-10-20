package com.example.anuraggupta.firebasedemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        buttonRegister =  (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();


        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    private void registerUser(){
        String Email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils. isEmpty(Email))
        {
            //email is empty
            Toast.makeText(this,"Please Enter Email" ,Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            // password is empty
            Toast.makeText(this,"Please Enter Password" , Toast.LENGTH_SHORT).show();
            return;
        }


        Task<AuthResult> authResultTask = firebaseAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            progressDialog.setMessage("Registering User...");
                            progressDialog.show();

                            progressDialog.hide();
                            Toast.makeText(MainActivity.this,"Registered Succesfully",Toast.LENGTH_SHORT).show();
                           // finish();
                            startActivity(new Intent(getApplicationContext(),CredentialsActivity.class));


                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Failed to register",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }

        if (view == textViewSignin) {
           startActivity(new Intent(this,LoginActivity.class));

        }
=======
        frameLayout = (FrameLayout)findViewById(R.id.animLay);
        animationDrawable =(AnimationDrawable)frameLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2500);
        animationDrawable.start();
      //  startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
>>>>>>> ae3f5855d66fd2cd42d0bdf7192d9906bd966c7f
    }


}
