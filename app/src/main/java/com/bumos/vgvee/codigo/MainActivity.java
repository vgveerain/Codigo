package com.bumos.vgvee.codigo;
import android.graphics.Color;
import android.content.Intent;
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
    ImageView searchIV,profileIV;
    RecyclerView listRecyclerView;
    ArrayList<Data> dataArrayListSource;
    Adapter adapter;
    int count = 0;
    int progress = 0;

//    String t,q;

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

        profileIV=findViewById(R.id.profileIV);
        profileIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
//                intent.putParcelableArrayListExtra("array",dataArrayListSource);
                progress = (int)((count/dataArrayListSource.size())*100);
                intent.putExtra("progress", progress);
                startActivity(intent);
            }
        });
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
//        dataArrayListSource.add(new Data("CardView","The CardView API is an easy way to display information inside cards"));
        dataArrayListSource.add(new Data("WebView","WebView is a view that display web pages inside an application"));
        dataArrayListSource.add(new Data("TextClock","TextClock is a UI control which is used to show the current date or time as a formatted string."));
        dataArrayListSource.add(new Data("DatePicker","Android DatePicker is a widget to select date. It allows you to select date by day, month and year. "));
        dataArrayListSource.add(new Data("ListView","ListView is a view group that displays a list of scrollable items."));
        dataArrayListSource.add(new Data("RadioButton","Radio buttons allow the user to select one option from a set. You should use radio buttons for optional sets that are mutually exclusive if you think that the user needs to see all available options side-by-side."));


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
//                Log.d("SimpleSearchView", "Text changed:" + newText);
//                return false;
                ArrayList<Data> dataArrayListResult = new ArrayList<>();
//                t=newText.toLowerCase().trim();
                if(newText!= null && !newText.isEmpty()){
                    for(Data item : dataArrayListSource){

//                        Log.e("TAG",""+q+" "+t);
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

        if(savedInstanceState != null){

        }

        Log.e("TAGonCreateOut", ""+count);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Log.e("onRestart","Restart");
        for(Data item: dataArrayListSource){

//            Log.e("inLoop",""+item.isProgress());
            if(item.progress){
//                Log.e("count",""+count);
                count++;
            }
//            Log.e("TAG",""+item.getName());
//            Log.e("TAG","Loop"+dataArrayList.size());

        }
        Log.e("TAGoutCount","Count - "+count);
    }
}
