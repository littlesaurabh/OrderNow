package com.example.singhsters.ordernow;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static java.sql.Types.NULL;

public class SignUp extends AppCompatActivity {
    DatabaseReference mDatabase;
    Button b,b2;
    EditText e1,e2,e3,e4;
    String Name,Email,Mob_no,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        e1= (EditText) findViewById(R.id.Name);
        e2= (EditText) findViewById(R.id.Email);
        e3= (EditText) findViewById(R.id.Mob_no);
        e4= (EditText) findViewById(R.id.Password);
        b= (Button) findViewById(R.id.button4);
        b2= (Button) findViewById(R.id.button5);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText(null);
                e3.setText(null);
                e4.setText(null);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=e1.getText().toString().trim();
                Email=e2.getText().toString().trim();
                Mob_no=e3.getText().toString().trim();
                Password=e4.getText().toString().trim();
//                mDatabase.child("Username").push().setValue(username);
//                mDatabase.child("Password").push().setValue(password);
                HashMap<String,String> dataMap=new HashMap<String,String>();
                dataMap.put("Name",Name);
                dataMap.put("Email",Email);
                dataMap.put("Mobile_no",Mob_no);
                dataMap.put("Password",Password);
                mDatabase.push().setValue(dataMap);
                Toast.makeText(SignUp.this, "SIGN UP Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    private void notify(String s) {
        int mNotificationId = 001;
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.icon_food);
        mBuilder.setContentTitle("My notification"+s);
        mBuilder.setContentText("Hello World!"+s);
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}
