package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragSpinner extends Fragment {

    TextView tvtitle,tvdesc;
    Spinner spinner;

    public FragSpinner() {
        // Required empty public constructor
    }

    public static FragSpinner newInstance(Data data) {

        Bundle args = new Bundle();
        args.putParcelable("data",data);
        FragSpinner fragment = new FragSpinner();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_spinner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc()+" Touching the spinner displays a dropdown menu with all other available values, from which the user can select a new one.");
        Spinner spinner=view.findViewById(R.id.spinner);
        String[] colour={"red","blue","orange","purple","yellow"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,colour);
        spinner.setAdapter(adapter);
    }
}
