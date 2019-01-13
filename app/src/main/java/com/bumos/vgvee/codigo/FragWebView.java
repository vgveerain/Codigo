package com.bumos.vgvee.codigo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragWebView extends Fragment {

    WebView webView;
    TextView tvtitle,tvdesc;
    Data data;

    public FragWebView() {
        // Required empty public constructor
    }

    public static FragWebView newInstance(Data d) {

        Bundle args = new Bundle();
        args.putParcelable("data",d);
        FragWebView fragment = new FragWebView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_web_view, container, false);
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
        webView.loadUrl("https://www.google.com/");
    }
}
