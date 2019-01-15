package com.bumos.vgvee.codigo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    TextView percentProgress;
    ProgressBar progressBar;
    ImageView imageView;
    Button button;
    TextView textView,textView2;
    private static final int RequestCode= 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        int progress = getIntent().getExtras().getInt("progress");

        imageView = findViewById(R.id.profileIV);
        progressBar = findViewById(R.id.progressBar);
        percentProgress = findViewById(R.id.percentProgress);
        button = findViewById(R.id.edit);
        textView =findViewById(R.id.personName);
        textView2 = findViewById(R.id.personEmail);

        final View alertView = LayoutInflater.from(ProfileActivity.this).inflate(R.layout.dialog_layout, null, true);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Edit")
                .setCancelable(false)
                .setMessage("Please enter Name and Email")
                .setView(alertView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = alertView.findViewById(R.id.edtName);
                        EditText email = alertView.findViewById(R.id.edtEmail);
                        textView.setText(name.getText().toString());
                        textView2.setText(email.getText().toString());
                        name.setText("");
                        email.setText("");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(ProfileActivity.this, "As You Wish", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.show();
            }
        });

        progressBar.setProgress(progress);
        percentProgress.setText(""+progress+"%");
//        Log.e("TAGProfile",""+progress);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ContextCompat.checkSelfPermission(ProfileActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)+ContextCompat.checkSelfPermission(ProfileActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ProfileActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, RequestCode);
                    ActivityCompat.requestPermissions(ProfileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RequestCode);
                } else {
                    pickImage();

                }
            }

            });
        }

    public void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == 1) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                Bitmap newProfilePic = extras.getParcelable("data");
                imageView.setImageBitmap(newProfilePic);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RequestCode) {

            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Thank you for granting the permissions!", Toast.LENGTH_SHORT).show();
                pickImage();
            } else {
                Toast.makeText(this,
                        "Sorry, but I need the permissions for the app to work!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}

