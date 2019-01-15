package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FragLifecycle extends Fragment {

    TextView tvtitle,tvdesc;
    ImageView iv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_lifecycle,container,false);
    }

    public static FragLifecycle newInstance(Data d){
        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragLifecycle fragLifecycle = new FragLifecycle();
        fragLifecycle.setArguments(args);
        return fragLifecycle;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        tvtitle=view.findViewById(R.id.tvtitle);
        tvdesc=view.findViewById(R.id.tvdesc);
        iv=view.findViewById(R.id.iv);
        tvtitle.setText(data.getName());
        Picasso.get().load(R.drawable.activity).into(iv);
        tvdesc.setText("As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that allow the activity to know that a state has changed: that the system is creating, stopping, or resuming an activity, or destroying the process in which the activity resides.");
    }
}
