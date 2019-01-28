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

import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.Theme;


public class FragXML extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Data data;


    public FragXML() {
        // Required empty public constructor
    }

    public static FragXML newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data", d);

        FragXML fragment = new FragXML();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        data = getArguments().getParcelable("data");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_xml, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Data data = (Data)bundle.getParcelable("data");

        CodeView xmlCodeView = view.findViewById(R.id.xmlCodeView);
        xmlCodeView
                .setTheme(Theme.ANDROIDSTUDIO)
                .setCode(data.xml)
                .setLanguage(Language.XML)
                .setWrapLine(true)
                .setFontSize(10)
                .setZoomEnabled(true)
                .setShowLineNumber(true)
                .setStartLineNumber(1)
                .apply();
    }

}
