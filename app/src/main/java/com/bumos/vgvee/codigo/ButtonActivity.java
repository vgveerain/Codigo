package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ButtonActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        btn=findViewById(R.id.btn);
        ivxml=findViewById(R.id.ivxml);
        Data d = getIntent().getParcelableExtra("button");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.buttonjava).into(ivcode);
        Picasso.get().load(R.drawable.buttonxml).into(ivxml);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
