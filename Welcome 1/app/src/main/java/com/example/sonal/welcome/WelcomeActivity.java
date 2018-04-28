package com.example.sonal.welcome;

import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;

public class WelcomeActivity extends AppCompatActivity {

LinearLayout l1,l2;

Animation uptodown;
Animation downtotop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);







        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtotop = AnimationUtils.loadAnimation(this,R.anim.downtotop);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtotop);

        Thread thread = new Thread()
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }





    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}




