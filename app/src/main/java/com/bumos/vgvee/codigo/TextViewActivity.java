package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TextViewActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        ivxml=findViewById(R.id.ivxml);
        Data d = getIntent().getParcelableExtra("textview");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.textview_xml).into(ivxml);
        Picasso.get().load(R.drawable.textviewjava).into(ivcode);


    }
}
