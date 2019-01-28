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
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class FragRatingBar extends Fragment {

    TextView tvtitle,tvdesc;
    Button btn;
    RatingBar ratingBar;
    public FragRatingBar() {
        // Required empty public constructor
    }

    public static FragRatingBar newInstance(Data data) {
        FragRatingBar fragment = new FragRatingBar();
        Bundle args = new Bundle();
        args.putParcelable("data",data);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_rating_bar, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvtitle.setText(data.getName());
        tvdesc.setText(data.getDesc());
        ratingBar=view.findViewById(R.id.ratingBar);
        btn=view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float f=ratingBar.getRating()+1;
                Toast.makeText(getContext(), ""+f, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
