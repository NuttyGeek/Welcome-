package com.example.sonal.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Notices extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);

        String url = "https://drive.google.com/open?id=1kFOu4HQdMSpLzicwal1NL_qDoNh6K4JD";

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        loadImage(url,image1);
        loadImage(url,image2);
        loadImage(url,image3);

    }


    public void loadImage(String url, ImageView imageView)
    {
        Glide.with(this).load(url).into(imageView);

    }

}
