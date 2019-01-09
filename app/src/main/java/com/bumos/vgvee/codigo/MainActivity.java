package com.bumos.vgvee.codigo;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.content.Intent;
import android.graphics.Point;
import android.os.PersistableBundle;
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
    ImageView searchIV,profileIV;
    RecyclerView listRecyclerView;
    ArrayList<Data> dataArrayListSource;
    ArrayList<Data> dataArrayListVisited;
    Adapter adapter;
    float count = 0;
    float progress1 = 0;
    int progress = 0;
    float size = 0;

//    String t,q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declarations
        if(savedInstanceState == null){
            dataArrayListVisited = new ArrayList<>();
        }

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
        simpleSearchView.setBackIconColor(Color.BLACK);

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

        //SharedPreference
        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        if(sharedPref.getBoolean("hasData", false)){
            for(int i=0;i<dataArrayListSource.size();i++){
                dataArrayListSource.get(i).setProgress(sharedPref.getBoolean("Sdata"+i, false));
            }
        }
        //update values at start
        for(Data d : dataArrayListSource){
            if(d.progress){
                if(!dataArrayListVisited.contains(d)){
                    dataArrayListVisited.add(d);
                }
            }
        }
        Log.e("TAGonCreate", ""+dataArrayListVisited.size());

        adapter=new Adapter(dataArrayListSource,MainActivity.this);
        listRecyclerView.setAdapter(adapter);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        listRecyclerView.getLayoutParams().height = 1500;
        listRecyclerView.setNestedScrollingEnabled(false);
        listRecyclerView.setHasFixedSize(false);

        simpleSearchView.setOnQueryTextListener(new SimpleSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("SimpleSearchView", "Submit:" + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Data> dataArrayListResult = new ArrayList<>();
                if(newText!= null && !newText.isEmpty()){
                    for(Data item : dataArrayListSource){

                        if(item.name.toLowerCase().trim().contains(newText.toLowerCase().trim())){
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

        //Profile ImageView
        profileIV=findViewById(R.id.profileIV);
        profileIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
//                intent.putParcelableArrayListExtra("array",dataArrayListSource);
                count = dataArrayListVisited.size();
                size = dataArrayListSource.size();
                Log.e("TAGProfileOCSize", ""+size);
                Log.e("TAGProfileOCCount", ""+count);
                progress1 = count/size;
                Log.e("TAGProfileOCProgressF", ""+progress1);
                progress = (int)(progress1*100);
                Log.e("TAGProfileOCProgress%", ""+progress);
                intent.putExtra("progress", progress);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        for(Data d : dataArrayListSource){
            if(d.progress){
                if(!dataArrayListVisited.contains(d)){
                    dataArrayListVisited.add(d);
                }
            }
        }
        Log.e("TAGonRestart", ""+dataArrayListVisited.size());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("data", dataArrayListVisited);
        Log.e("TAGonSave", ""+dataArrayListVisited.size());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        dataArrayListVisited = savedInstanceState.getParcelableArrayList("data");
        Log.e("TAGonSave", ""+dataArrayListVisited.size());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAGonStop", "....");
        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        int counts = 0;
        for (int i = 0; i < dataArrayListSource.size(); i++) {
            if (i == 0) {
                editor.putBoolean("hasData", true);
                Log.e("TAGonStop", "0 -> "+dataArrayListSource.get(i).progress);
            }
            editor.putBoolean("Sdata" + i, dataArrayListSource.get(i).progress);
            if(dataArrayListSource.get(i).progress){
                counts++;
            }
        }
        Log.e("TAGonStop", "afterLoop -> "+sharedPref.getBoolean("hasData", false)+", count -> "+counts);
        editor.commit();
    }
}
