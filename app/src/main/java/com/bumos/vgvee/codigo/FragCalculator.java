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

public class FragCalculator extends Fragment {

    TextView tvtitle,tvdesc;
    EditText num1,num2;
    Button add,mult,sub,div;

    public static FragCalculator newInstance(Data data){
        Bundle args = new Bundle();
        args.putParcelable("data", data);

        FragCalculator fragCalculator = new FragCalculator();
        fragCalculator.setArguments(args);
        return fragCalculator;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvdesc.setText(data.getDesc());
        tvtitle.setText(data.getName());

        num1=view.findViewById(R.id.num1);
        num2=view.findViewById(R.id.num2);
        add=view.findViewById(R.id.add);
        sub=view.findViewById(R.id.sub);
        div=view.findViewById(R.id.div);
        mult=view.findViewById(R.id.mult);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1+n2;
                Toast.makeText(getActivity(),""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1-n2;
                Toast.makeText(getActivity(),""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1*n2;
                Toast.makeText(getActivity(),""+sum,Toast.LENGTH_SHORT).show();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int sum=n1/n2;
                Toast.makeText(getActivity(),""+sum,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
