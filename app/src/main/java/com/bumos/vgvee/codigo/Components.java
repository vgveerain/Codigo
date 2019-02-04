package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class Components extends AppCompatActivity {

    TextView tvTitle,tvDesc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        tvTitle=findViewById(R.id.tvtitle);
        tvDesc=findViewById(R.id.tvdesc);
        imageView = findViewById(R.id.iv);


        tvTitle.setText("What is Android");
        tvDesc.setText("Activities\n" +
                "\n" +
                "They dictate the UI and handle the user interaction to the smart phone screen.\n" +
                "\n" +
                "Services\n" +
                "\n" +
                "They handle background processing associated with an application.\n" +
                "\n" +
                "Broadcast Receivers\n" +
                "\n" +
                "They handle communication between Android OS and applications.\n" +
                "\n" +
                "Content Providers\n" +
                "\n" +
                "They handle data and database management issues.");
    }
}
