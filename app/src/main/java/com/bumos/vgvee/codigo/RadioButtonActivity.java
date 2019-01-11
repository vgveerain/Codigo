package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class RadioButtonActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        ivxml=findViewById(R.id.ivxml);
        Data d = getIntent().getParcelableExtra("radiobutton");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.radiobuttonjava).into(ivcode);
        Picasso.get().load(R.drawable.radiobuttonxml).into(ivxml);
        RadioGroup radioGroup=findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.radiobutton1:
                        Toast.makeText(RadioButtonActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton2:
                        Toast.makeText(RadioButtonActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton3:
                        Toast.makeText(RadioButtonActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}
