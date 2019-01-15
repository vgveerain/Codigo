package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragTextView extends Fragment {

    TextView tvtitle,tvdesc,textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_textview, container, false);
    }

    public static FragTextView newInstance(Data d){
        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragTextView fragTextView = new FragTextView();
        fragTextView.setArguments(args);
        return fragTextView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        textView=view.findViewById(R.id.text_view_id);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc());
        textView.setText("This is a sample TextView!");
    }
}
