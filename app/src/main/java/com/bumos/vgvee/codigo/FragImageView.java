package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragImageView extends Fragment {


    Data data;
    TextView tvtitle,tvdesc;
    ImageView imageView;
    public FragImageView() {
        // Required empty public constructor
    }

    public static FragImageView newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragImageView fragImageView=new FragImageView();
        fragImageView.setArguments(args);
        return fragImageView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_image_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        Log.e("TAG",""+data.java);
        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        tvdesc.setText(data.getDesc());
        tvtitle.setText(data.getName());
        imageView=view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.img);
    }
}
