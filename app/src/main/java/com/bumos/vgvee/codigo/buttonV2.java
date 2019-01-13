package com.bumos.vgvee.codigo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

public class buttonV2 extends AppCompatActivity {

    ViewPager viewPager;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_v2_activity);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new GoThroughAdapter(getSupportFragmentManager()));

        // Create an object of page transformer
        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();

        // Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
        bookFlipPageTransformer.setEnableScale(true);

        // Assign the page transformer to the ViewPager.
        viewPager.setPageTransformer(true, bookFlipPageTransformer);

        Data data = getIntent().getParcelableExtra("button");

        bundle = new Bundle();
        bundle.putParcelable("data", data);
    }

    private class GoThroughAdapter extends FragmentPagerAdapter {
        public GoThroughAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    FragJava fragJava = new FragJava();
                    fragJava.setArguments(bundle);
                    return fragJava;
                case 1:
                    FragXML fragXML = new FragXML();
                    fragXML.setArguments(bundle);
                    return fragXML;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
