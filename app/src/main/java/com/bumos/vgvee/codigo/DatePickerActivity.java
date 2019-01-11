package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_activity);
        tvtitle=findViewById(R.id.tvtitle);
        DatePicker datepicker=findViewById(R.id.datePicker);
        Calendar calendar=Calendar.getInstance();
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        ivxml=findViewById(R.id.ivxml);
        Data d = getIntent().getParcelableExtra("datepicker");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.datepickerjava).into(ivcode);
        Picasso.get().load(R.drawable.datepickerxml).into(ivxml);
        datepicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getBaseContext(),datepicker.getDayOfMonth()+"-"+datepicker.getMonth()+"-"+
                                datepicker.getYear(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
