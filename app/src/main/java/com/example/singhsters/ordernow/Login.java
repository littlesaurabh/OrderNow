package com.example.singhsters.ordernow;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Login extends AppCompatActivity  {
    EditText e3,e4;
    Button b;
    String username,password;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        b= (Button) findViewById(R.id.button3);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password=e3.getText().toString().trim();
                username=e4.getText().toString().trim();
//                mDatabase.child("Username").push().setValue(username);
//                mDatabase.child("Password").push().setValue(password);
                HashMap<String,String> dataMap=new HashMap<String, String>();
                dataMap.put("Username",username);
                dataMap.put("Password",password);
                mDatabase.push().setValue(dataMap);
            }
        });


    }
    @Override
    public void onBackPressed() {

        Intent t=new Intent(Login.this,Home.class);
        startActivity(t);
//        super.onBackPressed();
    }
}
