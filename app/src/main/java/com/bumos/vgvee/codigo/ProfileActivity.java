package com.bumos.vgvee.codigo;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    TextView percentProgress;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        int progress = getIntent().getExtras().getInt("progress");

        progressBar = findViewById(R.id.progressBar);
        percentProgress = findViewById(R.id.percentProgress);

        progressBar.setProgress(progress);
        percentProgress.setText(""+progress+"%");
//        Log.e("TAGProfile",""+progress);
    }
}
