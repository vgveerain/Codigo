package com.bumos.vgvee.codigo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class FragSwitch extends Fragment {

    TextView tvtitle,tvdesc;

    public FragSwitch() {
        // Required empty public constructor
    }

    public static FragSwitch newInstance(Data data) {

        Bundle args = new Bundle();
        args.putParcelable("data",data);
        FragSwitch fragment = new FragSwitch();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_switch, container, false);
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
        Switch s=view.findViewById(R.id.Switch);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getContext(), "ON", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), "OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
