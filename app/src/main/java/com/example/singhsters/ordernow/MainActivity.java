package com.example.singhsters.ordernow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Thread t=new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep((long)2000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Exception Occured", Toast.LENGTH_SHORT).show();
                }
                finally
                {
                    Intent t=new Intent(getApplicationContext(),Home.class);
                    startActivity(t);
                }
            }
        };
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    }
