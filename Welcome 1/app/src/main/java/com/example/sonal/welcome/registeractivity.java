package com.example.sonal.welcome;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;



public class registeractivity extends AppCompatActivity {
    EditText uname, passwrd,email2,role1,branch1,contact1,address1,regno,dob1;
    Button registerButton;
    RadioGroup radiogp;

    String user_3, pass_2,email_3,role_3,branch_3,dob_3,contact_3,address_3,regno_3,radiogp_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        uname = (EditText)findViewById(R.id.username);
        passwrd = (EditText)findViewById(R.id.password);
        registerButton = (Button)findViewById(R.id.reg);
        email2 = (EditText)findViewById(R.id.email1);
        role1 = (EditText)findViewById(R.id.userrole);
        branch1 = (EditText)findViewById(R.id.branch);
         contact1= (EditText)findViewById(R.id.contact);
        address1 = (EditText)findViewById(R.id.address);
        regno = (EditText)findViewById(R.id.registrationno);
        dob1 = (EditText)findViewById(R.id.dob);
       radiogp=(RadioGroup)findViewById(R.id.gender);

        Firebase.setAndroidContext(this);
     registerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(registeractivity.this,"done",Toast.LENGTH_SHORT).show();
            user_3 = uname.getText().toString();
            pass_2 = passwrd.getText().toString();
            email_3= email2.getText().toString();
            role_3 = role1.getText().toString();
            dob_3 = dob1.getText().toString();
            contact_3 = contact1.getText().toString();
            address_3 = address1.getText().toString();
            regno_3 = regno.getText().toString();
            branch_3=branch1.getText().toString();
            if(user_3.equals("")){
                uname.setError("can't be blank");
            }
            else if(pass_2.equals("")){
                passwrd.setError("can't be blank");
            }
            if(email_3.equals("")){
                email2.setError("can't be blank");
            }
            if(role_3.equals("")){
                role1.setError("can't be blank");
            }
            if(dob_3.equals("")){
                dob1.setError("can't be blank");
            }
            if(contact_3.equals("")){
                contact1.setError("can't be blank");
            }
            if(address_3.equals("")){
                address1.setError("can't be blank");
            }
            if(regno_3.equals("")){
                regno.setError("can't be blank");
            }
            if(branch_3.equals("")){
                branch1.setError("can't be blank");
            }
            else if(!user_3.matches("[A-Za-z0-9]+")){
                uname.setError("only alphabet or number allowed");
            }
            else if(uname.length()<20){
                uname.setError("at least 20 characters long");
            }
            else if(pass_2.length()<5){
                passwrd.setError("at least 5 characters long");
            }
            else {
                final ProgressDialog pd = new ProgressDialog(registeractivity.this);
                pd.setMessage("Loading...");
                pd.show();

                String url = "https://welcome-c2807.firebaseio.com/users.json";

                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        Firebase reference = new Firebase("https://welcome-c2807.firebaseio.com/users");

                        if(s.equals("null")) {
                            reference.child(user_3).child("password").setValue(pass_2);
                            reference.child(user_3).child("email").setValue(email_3);
                            reference.child(user_3).child("branch").setValue(branch_3);
                            reference.child(user_3).child("role").setValue(role_3);
                            reference.child(user_3).child("contact").setValue(contact_3);
                            reference.child(user_3).child("D.O.B").setValue(dob_3);
                            reference.child(user_3).child("Address").setValue(address_3);
                            reference.child(user_3).child("Registration No.").setValue(regno_3);
                            Toast.makeText(registeractivity.this, "registration successful", Toast.LENGTH_LONG).show();
                        }
                        else {
                            try {
                                JSONObject obj = new JSONObject(s);

                                if (!obj.has(user_3)) {
                                    reference.child(user_3).child("password").setValue(pass_2);

                                    Toast.makeText(registeractivity.this, "registration successful", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(registeractivity.this, "username already exists", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        pd.dismiss();
                    }

                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("" + volleyError );
                        pd.dismiss();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(registeractivity.this);
                rQueue.add(request);
            }
        }
    });

}
}



