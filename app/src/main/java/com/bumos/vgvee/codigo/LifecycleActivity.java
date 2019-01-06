package com.bumos.vgvee.codigo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LifecycleActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView iv;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        iv=findViewById(R.id.iv);
        Data d = getIntent().getParcelableExtra("lifecycle");
        tvtitle.setText(d.getName());
        Picasso.get().load(R.drawable.activity).into(iv);
        tvdesc.setText("As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that allow the activity to know that a state has changed: that the system is creating, stopping, or resuming an activity, or destroying the process in which the activity resides.");
        
    }
}
