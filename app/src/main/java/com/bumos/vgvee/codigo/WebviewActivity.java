package com.bumos.vgvee.codigo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

public class WebviewActivity extends AppCompatActivity {

    ViewPager viewPager;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new GoThroughAdapter(getSupportFragmentManager()));

        // Create an object of page transformer
        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();

        // Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
        bookFlipPageTransformer.setEnableScale(true);

        // Assign the page transformer to the ViewPager.
        viewPager.setPageTransformer(true, bookFlipPageTransformer);
        Data data = (Data) getIntent().getParcelableExtra("webview");
        Log.e("TAG", ""+data.getJava());
        Log.e("TAG", ""+data.desc);
    }

    private class GoThroughAdapter extends FragmentPagerAdapter {
        public GoThroughAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    FragJava fragJava = FragJava.newInstance(getIntent().getParcelableExtra("webview"));
                    return fragJava;
                case 1:
                    FragXML fragXML = FragXML.newInstance(getIntent().getParcelableExtra("webview"));
                    return fragXML;
                case 2:
                    FragWebView fragWebView=FragWebView.newInstance(getIntent().getParcelableExtra("webview"));
                    return fragWebView;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
