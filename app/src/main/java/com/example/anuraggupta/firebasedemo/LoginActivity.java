package com.example.anuraggupta.firebasedemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonsignin;
    private EditText edittextEmail;
    private EditText edittextpassword;
    private TextView textViewsignin;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            //profile activity here
        }



        edittextEmail = (EditText) findViewById(R.id.editTextEmail);
        edittextpassword = (EditText) findViewById(R.id.editTextPassword);
        buttonsignin = (Button) findViewById(R.id.buttonSignin);
        textViewsignin = (TextView) findViewById(R.id.textViewSignin);
        progressDialog = new ProgressDialog(this);
        buttonsignin.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);
    }

    private void userLogin()
    {
        String Email = edittextEmail.getText().toString().trim();
        String password = edittextpassword.getText().toString().trim();

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





        firebaseAuth.signInWithEmailAndPassword(Email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if(task.isSuccessful())
                            {
                                finish();
                                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                            }

                            else {

                                Toast.makeText(getApplicationContext(), "You are not a registerd user", Toast.LENGTH_SHORT).show();
                                return;
                            }

                    }
                });

        progressDialog.setMessage("Please wait Signing in.....");
        progressDialog.show();



    }

    @Override
    public void onClick(View view) {
        if(view == buttonsignin)
        {
            userLogin();

        }
        if(view == textViewsignin)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
