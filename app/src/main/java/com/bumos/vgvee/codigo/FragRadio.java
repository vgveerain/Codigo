package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragRadio extends Fragment {


    TextView tvtitle,tvdesc;
    Data data;

    public FragRadio() {
        // Required empty public constructor
    }


    public static FragRadio newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragRadio fragRadio=new FragRadio();
        fragRadio.setArguments(args);
        return fragRadio;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_radio, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        data = (Data)bundle.getParcelable("data");
        tvtitle = view.findViewById(R.id.rdTitle);
        tvdesc = view .findViewById(R.id.rdDesc);
        tvdesc.setText(data.getDesc());
        tvtitle.setText(data.getName());

        RadioGroup radioGroup=view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radiobutton1:
                        Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton2:
                        Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton3:
                        Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}
