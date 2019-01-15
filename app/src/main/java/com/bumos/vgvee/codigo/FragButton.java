package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragButton extends Fragment {

    Button button;
    TextView tvtitle,tvdesc;

    public static FragButton newInstance(Data data){
        Bundle args = new Bundle();
        args.putParcelable("data",data);

        FragButton fragButton = new FragButton();
        fragButton.setArguments(args);
        return fragButton;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        button = view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc());
    }
}
