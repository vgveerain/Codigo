package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ArrayList<Data> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        int progress = getIntent().getExtras().getInt("progress");
        Log.e("TAGProfile",""+progress);
    }
}
