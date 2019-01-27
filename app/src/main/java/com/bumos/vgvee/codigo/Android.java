package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Android extends AppCompatActivity {

    TextView tvTitle,tvDesc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        tvTitle=findViewById(R.id.tvtitle);
        tvDesc=findViewById(R.id.tvdesc);
        imageView = findViewById(R.id.iv);

        tvTitle.setText("What is Android");
        Picasso.get().load(R.drawable.android_icon).into(imageView);
        tvDesc.setText("Before learning all topics of android, it is required to know what is android.\n" +
                "\n" +
                "Android is a software package and linux based operating system for mobile devices such as tablet computers and smartphones.\n" +
                "\n" +
                "It is developed by Google and later the OHA (Open Handset Alliance). Java language is mainly used to write the android code even though other languages can be used.\n" +
                "\n" +
                "The goal of android project is to create a successful real-world product that improves the mobile experience for end users");
    }
}
