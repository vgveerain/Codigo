package com.bumos.vgvee.codigo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {


    ViewPager viewPager;
    Bundle bundle;
    DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_activity);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new GoThroughAdapter(getSupportFragmentManager()));

        // Create an object of page transformer
        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();

        // Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
        bookFlipPageTransformer.setEnableScale(true);

        // Assign the page transformer to the ViewPager.
        viewPager.setPageTransformer(true, bookFlipPageTransformer);
        dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(viewPager);
        Data d = getIntent().getParcelableExtra("datepicker");
    }

    private class GoThroughAdapter extends FragmentPagerAdapter {
        public GoThroughAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    FragJava fragJava = FragJava.newInstance(getIntent().getParcelableExtra("datepicker"));
                    return fragJava;
                case 1:
                    FragXML fragXML = FragXML.newInstance(getIntent().getParcelableExtra("datepicker"));
                    return fragXML;
                case 2:
                    FragDatePicker fragDatePicker = FragDatePicker.newInstance(getIntent().getParcelableExtra("datepicker"));
                    return fragDatePicker;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}