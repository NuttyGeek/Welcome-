package com.example.sonal.welcome;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    Dialog myDialog;
Spinner spinnerRoll;
    Button registerUser;
    EditText username, password;
    Button loginButton;
    String user_2, pass,role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDialog = new Dialog(this);
spinnerRoll=(Spinner)findViewById(R.id.spinnerroll);
        registerUser = (Button) findViewById(R.id.register);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login1);

String[] rolls={"STUDENT","H.O.D","TEACHER"};
ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,rolls);
spinnerRoll.setAdapter(adapter);
//for login user accordintgto roll
loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        user_2 = username.getText().toString();
        pass = password.getText().toString();

        if (user_2.equals("")) {
            username.setError("can't be blank");
        } else if (pass.equals("")) {
            password.setError("can't be blank");
        }
        else if (spinnerRoll.equals("")) {


        }else {
            String url = "https://welcome-c2807.firebaseio.com/users.json";
            final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
            pd.setMessage("Loading...");
            pd.show();
          final StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
              @Override
              public void onResponse(String s) {
                  if(s.equals("null"))
                  {
                      Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                  }else {

                          try {
                              JSONObject obj = new JSONObject(s);
                              if(!obj.has(user_2))
                              {
                                  Toast.makeText(LoginActivity.this,"user not found",Toast.LENGTH_LONG).show();
                              }
                              else if(obj.getJSONObject(user_2).getString("password").equals(pass)){
                                  UserDetails.username=user_2;
                                  UserDetails.password=pass;
                                  startActivity(new Intent(LoginActivity.this , XpressActivity.class));
                              }else{
                                  Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_SHORT).show();
                              }


                          } catch (JSONException e) {
                              e.printStackTrace();
                          }

                      }
                      pd.dismiss();}
                  }, new Response.ErrorListener()

                  {
                      @Override
                      public void onErrorResponse(VolleyError error) {
                          System.out.println("" + error);
                           pd.dismiss();
                      }
                  });
          RequestQueue rQueue =Volley.newRequestQueue(LoginActivity.this);
          rQueue.add(request);
              }

              }
        });
    }








//to register user
    public void ShowPopup(View v){
        TextView txt;
        Button reg;
        myDialog.setContentView(R.layout.activity_registeractivity);
        txt = (TextView) myDialog.findViewById(R.id.txtclose);
        reg = (Button) myDialog.findViewById(R.id.reg);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

//
//    public void login(View view)
//    {
//
//        Intent intent = new Intent(LoginActivity.this,XpressActivity.class);
//        startActivity(intent);
//    }


    public void register (View view) {
        Intent intent = new Intent(LoginActivity.this,XpressActivity.class);

    }
}



