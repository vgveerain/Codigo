package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class FragTimePicker extends Fragment {


    TextView tvtitle,tvdesc;
    TimePicker timePicker;
    public FragTimePicker() {
        // Required empty public constructor
    }
    public static FragTimePicker newInstance(Data data) {
        FragTimePicker fragment = new FragTimePicker();
        Bundle args = new Bundle();
        args.putParcelable("data",data);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_time_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc());
        timePicker=view.findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getContext(), ""+hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
