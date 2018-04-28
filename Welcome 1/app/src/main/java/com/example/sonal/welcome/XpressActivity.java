package com.example.sonal.welcome;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class XpressActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;



//initializing fragments


    private Dashboard dashboardFragment;
    private Profile profileFragment;
    private Notification notificationFragment;

    private CardView teachercard, syllabuscard, attendencecard, notescard, noticecard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xpress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ////teachercard = findViewById(R.id.teacher_card);
        //syllabuscard = findViewById(R.id.syllabus_card);
       // attendencecard = findViewById(R.id.attendence_card);
       // notescard = findViewById(R.id.notes_card);
       // noticecard = findViewById(R.id.notice_card);


        //Add click listener to the cards
        //teachercard.setOnClickListener(this);
        //syllabuscard.setOnClickListener(this);
        //attendencecard.setOnClickListener(this);
        //notescard.setOnClickListener(this);
        //noticecard.setOnClickListener(this);

        mMainFrame=(FrameLayout) findViewById(R.id.main_frame);
        mMainNav=(BottomNavigationView) findViewById(R.id.main_nav);


        dashboardFragment=new Dashboard();
        notificationFragment=new Notification();
        profileFragment=new Profile();
        //adding default fragment
        setFragment(dashboardFragment);

        //adding listner
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_dashboard:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);

                        setFragment(dashboardFragment);
                        return true;
                    case R.id.nav_profile_1:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(profileFragment);
                        return true;
                    case R.id.nav_notification:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notificationFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });






    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
       Intent i=new Intent(XpressActivity.this,User.class);
    }
    });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.xpress, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   // @Override
   /// public void onClick(View view) {
        //Intent i;
        //every time we check which card was clicked

        //switch (view.getId()) {
           // case R.id.teacher_card : i = new Intent(this,TeacherActivity.class);
               // startActivity(i);
               // break;
            //case R.id.syllabus_card : i = new Intent(this,ChatActivity.class);
                //startActivity(i);
               // break;

            //default:break;
        //}

    //}

    /**
     * fragment is created and replace frame by fragment
     * and commit
     * @param fragment
     */
    private void setFragment(Fragment fragment) {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_frame,fragment);
        ft.commit();
    }

    @Override
    public void onClick(View view) {

    }
}



