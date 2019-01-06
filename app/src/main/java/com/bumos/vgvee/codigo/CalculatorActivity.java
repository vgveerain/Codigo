package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    EditText num1,num2;
    Button add,mult,sub,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        ivxml=findViewById(R.id.ivxml);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        div=findViewById(R.id.div);
        mult=findViewById(R.id.mult);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1+n2;
                Toast.makeText(CalculatorActivity.this,""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1-n2;
                Toast.makeText(CalculatorActivity.this,""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1*n2;
                Toast.makeText(CalculatorActivity.this,""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1/n2;
                Toast.makeText(CalculatorActivity.this,""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        Data d = getIntent().getParcelableExtra("calculator");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
    }
}
