package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EdittextActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    EditText et;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        ivxml=findViewById(R.id.ivxml);
        btn=findViewById(R.id.btn);
        et=findViewById(R.id.et);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=et.getText().toString();
                Toast.makeText(EdittextActivity.this,""+text,Toast.LENGTH_SHORT).show();
            }
        });
        Data d = getIntent().getParcelableExtra("edittext");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
    }
}
