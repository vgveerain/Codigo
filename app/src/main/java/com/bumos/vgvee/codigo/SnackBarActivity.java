package com.bumos.vgvee.codigo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SnackBarActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivcode;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        btn=findViewById(R.id.btn);
        ivcode=findViewById(R.id.ivjava);
        Data d = getIntent().getParcelableExtra("snackbar");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.snackjava).into(ivcode);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar=Snackbar.make(v,"Hello World!",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

    }
}
