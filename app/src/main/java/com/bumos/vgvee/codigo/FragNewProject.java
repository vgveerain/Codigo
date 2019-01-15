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
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragNewProject extends Fragment {

    Data data;
    TextView tvtitle,tvdesc;

    public FragNewProject() {
        // Required empty public constructor
    }

    public static FragNewProject newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragNewProject fragNewProject=new FragNewProject();
        fragNewProject.setArguments(args);
        return fragNewProject;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_new_project, container, false);
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
    }
}
