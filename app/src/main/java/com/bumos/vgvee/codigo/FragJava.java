package com.bumos.vgvee.codigo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;


public class FragJava extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Data data;
    CodeView javaCodeView;


    public FragJava() {
        // Required empty public constructor
    }

    public static FragJava newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragJava fragment = new FragJava();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        data = getArguments().getParcelable("data");
//        Log.e("TAG", ""+data.java);

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_frag_java, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");
        Log.e("TAG",""+data.java);

        javaCodeView = view.findViewById(R.id.javaCodeView);
        javaCodeView
                .setTheme(Theme.ANDROIDSTUDIO)
                .setCode(data.java)
                .setLanguage(Language.JAVA)
                .setWrapLine(true)
                .setFontSize(10)
                .setZoomEnabled(true)
                .setShowLineNumber(true)
                .setStartLineNumber(1)
                .apply();
    }
}
