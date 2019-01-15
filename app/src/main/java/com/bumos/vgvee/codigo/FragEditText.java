package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FragEditText extends Fragment {

    TextView tvtitle,tvdesc;
    EditText et;
    Button button;

    public static FragEditText newInstance(Data data){
        Bundle args = new Bundle();
        args.putParcelable("data",data);

        FragEditText fragEditText = new FragEditText();
        fragEditText.setArguments(args);
        return fragEditText;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_edit_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        et=view.findViewById(R.id.et);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc());

        button = view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=et.getText().toString();
                Toast.makeText(getActivity(),""+text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
