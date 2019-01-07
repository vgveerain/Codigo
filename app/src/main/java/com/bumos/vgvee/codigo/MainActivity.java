package com.bumos.vgvee.codigo;

import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ferfalk.simplesearchview.SimpleSearchView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Global Declarations
    SimpleSearchView simpleSearchView;
    ImageView searchIV;
    RecyclerView listRecyclerView;
    ArrayList<Data> dataArrayListSource;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting toolbar and then re-setting afterwards
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar);
//        View view = getSupportActionBar().getCustomView();

        //Declarations for SimpleSearchView
        searchIV = findViewById(R.id.searchIV);
        simpleSearchView = findViewById(R.id.searchView);
        Point left = new Point(0,0);

        //Functions for SimpleSearchView
        searchIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleSearchView.showSearch();
            }
        });

        simpleSearchView.setRevealAnimationCenter(left);

        //RecyclerView Declaration
        listRecyclerView = findViewById(R.id.listRV);
        dataArrayListSource = new ArrayList<>();

        //Seriously? WTH Shubham!
        dataArrayListSource.add(new Data("New Project","Creating a new android project"));
        dataArrayListSource.add(new Data("Activity LifeCycle","Understanding the lifecycle of an android application"));
        dataArrayListSource.add(new Data("TextView","A user interface element that displays text to the user."));
        dataArrayListSource.add(new Data("Button","A user interface element the user can tap or click to perform an action."));
        dataArrayListSource.add(new Data("EditText","A user interface element for entering and modifying text"));
        dataArrayListSource.add(new Data("ImageView","A user Interface to display Image files"));
        dataArrayListSource.add(new Data("SnackBar","Snackbars show a brief message at the bottom of the mobile screen"));
        dataArrayListSource.add(new Data("Basic Calculator","Building a calculator using the components discussed so far "));
        dataArrayListSource.add(new Data("CardView","The CardView API is an easy way to display information inside cards"));
        dataArrayListSource.add(new Data("WebView","WebView is a view that display web pages inside an application"));

        adapter=new Adapter(dataArrayListSource,MainActivity.this);
        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        simpleSearchView.setOnQueryTextListener(new SimpleSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("SimpleSearchView", "Submit:" + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                Log.d("SimpleSearchView", "Text changed:" + newText);
//                return false;
                ArrayList<Data> dataArrayListResult = new ArrayList<>();
                if(newText != null && !newText.isEmpty()){
                    for(Data item : dataArrayListSource){
                        if(item.name.contains(newText)){
                            dataArrayListResult.add(item);
                        }
                    }
                    adapter=new Adapter(dataArrayListResult,MainActivity.this);
                    listRecyclerView.setAdapter(adapter);
                }else{
                    adapter=new Adapter(dataArrayListSource,MainActivity.this);
                    listRecyclerView.setAdapter(adapter);
                }
                return true;
            }

            @Override
            public boolean onQueryTextCleared() {
                Log.d("SimpleSearchView", "Text cleared");
                return false;
            }
        });
    }
}
