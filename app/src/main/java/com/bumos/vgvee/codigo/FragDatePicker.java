package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragDatePicker extends Fragment {


    Data data;
    TextView tvtitle,tvdesc;

    public FragDatePicker() {
        // Required empty public constructor
    }

    public static FragDatePicker newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragDatePicker fragDatePicker=new FragDatePicker();
        fragDatePicker.setArguments(args);
        return fragDatePicker;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_date_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        Log.e("TAG",""+data.java);
        tvdesc =view.findViewById(R.id.dpDesc);
        tvtitle =view.findViewById(R.id.dpTitle);
        tvdesc.setText(data.getDesc());
        tvtitle.setText(data.getName());
        DatePicker datepicker=view.findViewById(R.id.datePicker);
        Calendar calendar=Calendar.getInstance();
        datepicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getContext(),datepicker.getDayOfMonth()+"-"+datepicker.getMonth()+"-"+
                                        datepicker.getYear(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
