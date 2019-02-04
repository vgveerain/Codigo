package com.bumos.vgvee.codigo;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.content.Intent;
import android.graphics.Point;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ferfalk.simplesearchview.SimpleSearchView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
    FirebaseAuth mAuth;
    float count = 0;
    float progress1 = 0;
    int progress = 0;
    float size = 0;
    LinearLayout banner;

//    String t,q;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null)
        {
            Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declarations
        if(savedInstanceState == null){
            dataArrayListVisited = new ArrayList<>();
        }

        banner = findViewById(R.id.banner);

        //Setting toolbar and then re-setting afterwards
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

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
        dataArrayListSource.add(new Data("What is Android","Android is a software package and linux based operating system for mobile devices such as tablet computers and smart phones.",R.drawable.and_icon));
        dataArrayListSource.add(new Data("Why Android","Android has dominated the global smart phone operating system market share for several years now.",R.drawable.why_icon));
        dataArrayListSource.add(new Data("New Project","Creating a new android project", R.drawable.training));
        dataArrayListSource.add(new Data("Application Components","Application components are the essential building blocks of an Android application.",R.drawable.component_icon));
        dataArrayListSource.add(new Data("Activity LifeCycle","Understanding the lifecycle of an android application", R.drawable.synchronize));
        dataArrayListSource.add(new Data("TextView","A user interface element that displays text to the user.",R.drawable.text,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        TextView textView=findViewById(R.id.textView);\n" +
                "        textView.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                Toast.makeText(MainActivity.this, \"Clicked\", Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }","<TextView\n" +
                "                android:id=\"@+id/text_view_id\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:textSize=\"25sp\"\n" +
                "                android:textStyle=\"bold\"\n" +
                "                android:layout_margin=\"5dp\"\n" +
                "                android:gravity=\"center\"\n" +
                "                android:text=\"This is an example of TextView\" />\n\n\n"));

        dataArrayListSource.add(new Data("Button", "A user interface element the user can tap or click to perform an action.", R.drawable.menu , "public class ButtonActivity extends AppCompatActivity {\nButton btn;\n" +
                "    @Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\nbtn=findViewById(R.id.btn);\nbtn.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                Toast.makeText(ButtonActivity.this,\"Button Clicked\",Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "}\n", "<Button\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            android:text=\"Click Me\"\n" +
                "            android:id=\"@+id/btn\"\n" +
                "            android:layout_width=\"match_parent\"\n" +
                "            android:layout_height=\"wrap_content\" />\n"));


        dataArrayListSource.add(new Data("EditText","A user interface element for entering and modifying text",R.drawable.edit,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        EditText editText=findViewById(R.id.editText);\n" +
                "        editText.addTextChangedListener(new TextWatcher() {\n" +
                "            @Override\n" +
                "            public void beforeTextChanged(CharSequence s, int start, int count, int after) {\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onTextChanged(CharSequence s, int start, int before, int count) {\n" +
                "\n" +
                "                Toast.makeText(MainActivity.this, \"\"+s, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void afterTextChanged(Editable s) {\n" +
                "\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }","<EditText\n" +
                "        android:layout_width=\"200dp\"\n" +
                "        android:textSize=\"32sp\"\n" +
                "        android:id=\"@+id/editText\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));
        dataArrayListSource.add(new Data("What is a Layout","A layout defines the visual structure for a user interface, such as the UI for an activity or app widget.",R.drawable.layout_icon));
        dataArrayListSource.add(new Data("Relative Layout","Relative Layout is a view group that displays child views in relative positions",R.drawable.relative_icon,null,"  <RelativeLayout\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_margin=\"10dp\"\n" +
                "        >\n" +
                "\n" +
                "        <EditText\n" +
                "            android:id=\"@+id/name\"\n" +
                "            android:layout_width=\"fill_parent\"\n" +
                "            android:layout_height=\"wrap_content\"\n" +
                "            android:hint=\"reminder\"\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            />\n" +
                "\n" +
                "        <Button\n" +
                "            android:layout_width=\"100dp\"\n" +
                "            android:layout_height=\"wrap_content\"\n" +
                "            android:layout_below=\"@id/name\"\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            android:layout_alignParentRight=\"true\"\n" +
                "            android:text=\"done\" />\n" +
                "\n" +
                "    </RelativeLayout>"));
        dataArrayListSource.add(new Data("Linear Layout","LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally.",R.drawable.layout_icon,null,"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"fill_parent\"\n" +
                "    android:layout_height=\"fill_parent\"\n" +
                "    android:paddingLeft=\"16dp\"\n" +
                "    android:paddingRight=\"16dp\"\n" +
                "    android:orientation=\"vertical\" >\n" +
                "    <EditText\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:hint=\"@string/to\" />\n" +
                "    <EditText\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:hint=\"@string/subject\" />\n" +
                "    <EditText\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"0dp\"\n" +
                "        android:layout_weight=\"1\"\n" +
                "        android:gravity=\"top\"\n" +
                "        android:hint=\"@string/message\" />\n" +
                "    <Button\n" +
                "        android:layout_width=\"100dp\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_gravity=\"right\"\n" +
                "        android:text=\"@string/send\" />\n" +
                "</LinearLayout>"));
        dataArrayListSource.add(new Data("ImageView","A user Interface to display Image files",R.drawable.gallery,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        ImageView imageView=findViewById(R.id.imageView);\n" +
                "        imageView.setImageResource(R.drawable.img);\n" +
                "    }\n\n\n\n","<ImageView\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:id=\"@+id/imageView\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));
        dataArrayListSource.add(new Data("SnackBar","Snackbars show a brief message at the bottom of the mobile screen",R.drawable.snackbar,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        Button button = findViewById(R.id.button);\n" +
                "        button.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                Snackbar snackbar=Snackbar.make(v,\"Hello World!\",Snackbar.LENGTH_SHORT);\n" +
                "                snackbar.show();\n" +
                "            }\n" +
                "        });\n\n\n\n","<Button\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:text=\"Click Me!\"\n" +
                "        android:id=\"@+id/button\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));

        dataArrayListSource.add(new Data("Grid View","GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid.",R.drawable.grid_icon,"public void onCreate(Bundle savedInstanceState) {\n" +
                "    super.onCreate(savedInstanceState);\n" +
                "    setContentView(R.layout.main);\n" +
                "\n" +
                "    GridView gridview = (GridView) findViewById(R.id.gridview);\n" +
                "    gridview.setAdapter(new ImageAdapter(this));\n" +
                "\n" +
                "    gridview.setOnItemClickListener(new OnItemClickListener() {\n" +
                "        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {\n" +
                "            Toast.makeText(HelloGridView.this, \"\" + position, Toast.LENGTH_SHORT).show();\n" +
                "        }\n" +
                "    });\n" +
                "}","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<GridView xmlns:android=\"http://schemas.android.com/apk/res/android\" \n" +
                "    android:id=\"@+id/gridview\"\n" +
                "    android:layout_width=\"fill_parent\" \n" +
                "    android:layout_height=\"fill_parent\"\n" +
                "    android:columnWidth=\"90dp\"\n" +
                "    android:numColumns=\"auto_fit\"\n" +
                "    android:verticalSpacing=\"10dp\"\n" +
                "    android:horizontalSpacing=\"10dp\"\n" +
                "    android:stretchMode=\"columnWidth\"\n" +
                "    android:gravity=\"center\"\n" +
                "/>"));
        dataArrayListSource.add(new Data("Basic Calculator","Building a calculator using the components discussed so far.",R.drawable.math,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        final EditText num1=findViewById(R.id.editText1);\n" +
                "        final EditText num2=findViewById(R.id.editText2);\n" +
                "        final TextView textView=findViewById(R.id.textView);\n" +
                "        Button add,subtract,multiply,div;\n" +
                "        add=findViewById(R.id.add);\n" +
                "        subtract=findViewById(R.id.subtract);\n" +
                "        multiply=findViewById(R.id.multiply);\n" +
                "        div=findViewById(R.id.div);\n" +
                "        add.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                int a=Integer.parseInt(num1.getText().toString());\n" +
                "                int b=Integer.parseInt(num2.getText().toString());\n" +
                "                int c=a+b;\n" +
                "                textView.setText(\"\"+c);\n" +
                "            }\n" +
                "        });\n" +
                "        multiply.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                int a=Integer.parseInt(num1.getText().toString());\n" +
                "                int b=Integer.parseInt(num2.getText().toString());\n" +
                "                int c=a*b;\n" +
                "                textView.setText(\"\"+c);\n" +
                "            }\n" +
                "        });\n" +
                "        div.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                int a=Integer.parseInt(num1.getText().toString());\n" +
                "                int b=Integer.parseInt(num2.getText().toString());\n" +
                "                int c=a/b;\n" +
                "                textView.setText(\"\"+c);\n" +
                "            }\n" +
                "        });\n" +
                "        subtract.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                int a=Integer.parseInt(num1.getText().toString());\n" +
                "                int b=Integer.parseInt(num2.getText().toString());\n" +
                "                int c=a-b;\n" +
                "                textView.setText(\"\"+c);\n" +
                "            }\n" +
                "        });\n" +
                "    }\n\n\n\n","<LinearLayout\n" +
                "    android:orientation=\"vertical\"\n" +
                "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" +
                "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    tools:context=\".MainActivity\">\n" +
                "\n" +
                "    <LinearLayout\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:orientation=\"horizontal\"\n" +
                "        android:layout_height=\"wrap_content\">\n" +
                "        <EditText\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            android:layout_width=\"60dp\"\n" +
                "            android:inputType=\"number\"\n" +
                "            android:textSize=\"25sp\"\n" +
                "            android:id=\"@+id/editText1\"\n" +
                "            android:layout_height=\"60dp\" />\n" +
                "\n" +
                "        <EditText\n" +
                "            android:layout_width=\"60dp\"\n" +
                "            android:textSize=\"25sp\"\n" +
                "            android:inputType=\"number\"\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            android:id=\"@+id/editText2\"\n" +
                "            android:layout_height=\"60dp\" />\n" +
                "\n" +
                "        <TextView\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:textSize=\"25sp\"\n" +
                "            android:layout_margin=\"10dp\"\n" +
                "            android:id=\"@+id/textView\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "\n" +
                "    </LinearLayout>\n" +
                "\n" +
                "    <LinearLayout\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:orientation=\"horizontal\"\n" +
                "        android:layout_height=\"wrap_content\">\n" +
                "        <Button\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:text=\"+\"\n" +
                "            android:id=\"@+id/add\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        <Button\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:text=\"-\"\n" +
                "            android:id=\"@+id/subtract\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        <Button\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:text=\"/\"\n" +
                "            android:id=\"@+id/div\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        <Button\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:text=\"*\"\n" +
                "            android:id=\"@+id/multiply\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "\n" +
                "    </LinearLayout>\n" +
                "\n" +
                "</LinearLayout>\n\n\n\n"));
//        dataArrayListSource.add(new Data("CardView","The CardView API is an easy way to display information inside cards"));
        dataArrayListSource.add(new Data("WebView","WebView is a view that display web pages inside an application",R.drawable.website,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main2);\n" +
                "        WebView webView=findViewById(R.id.webView);\n" +
                "        webView.loadUrl(\"https://www.google.com/\");\n" +
                "    }\n\n\n\n","<WebView\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:id=\"@+id/webView\"\n" +
                "        android:layout_height=\"300dp\"></WebView>\n\n\n\n"));

        dataArrayListSource.add(new Data("TextClock","TextClock is a UI control which is used to show the current date or time as a formatted string.",R.drawable.time,"","<TextClock\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:textSize=\"32sp\"\n" +
                "        android:id=\"@+id/textClock\"\n" +
                "        android:format12Hour=\"hh:mm:ss\"\n" +
                "        android:layout_height=\"match_parent\" />\n\n\n\n"));
        dataArrayListSource.add(new Data("DatePicker","Android DatePicker is a widget to select date. It allows you to select date by day, month and year.",R.drawable.calendar,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main2);\n" +
                "        final DatePicker datePicker=findViewById(R.id.datePicker);\n" +
                "        Calendar calendar=Calendar.getInstance();\n" +
                "        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {\n" +
                "            @Override\n" +
                "            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {\n" +
                "                Toast.makeText(Main2Activity.this, \"\"+datePicker.getDayOfMonth()+\"-\"+datePicker.getMonth()+\"-\"+datePicker.getYear(), Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }\n\n\n\n","<DatePicker\n" +
                "       android:layout_width=\"match_parent\"\n" +
                "       android:id=\"@+id/datePicker\"\n" +
                "       android:layout_height=\"match_parent\"></DatePicker>\n\n\n\n"));
        dataArrayListSource.add(new Data("ListView","ListView is a view group that displays a list of scrollable items.", R.drawable.list));
        dataArrayListSource.add(new Data("Switch","A Switch is a two-state toggle sw widget that can select between two options.",R.drawable.sw,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        Switch s=findViewById(R.id.Switch);\n" +
                "        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {\n" +
                "            @Override\n" +
                "            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {\n" +
                "                if(isChecked){\n" +
                "                    Toast.makeText(MainActivity.this, \"ON\", Toast.LENGTH_SHORT).show();\n" +
                "                }\n" +
                "                else\n" +
                "                    Toast.makeText(MainActivity.this, \"OFF\", Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n\n\n\n"," <Switch\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:id=\"@+id/Switch\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));

        dataArrayListSource.add(new Data("TimePicker","A widget for selecting the time of day, in either 24-hour or AM/PM mode.",R.drawable.timepicker,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        TimePicker timePicker=findViewById(R.id.timePicker);\n" +
                "        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {\n" +
                "            @Override\n" +
                "            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {\n" +
                "                Toast.makeText(MainActivity.this, \"\"+hourOfDay+\":\"+minute, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n\n\n\n","<TimePicker\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:id=\"@+id/timePicker\"\n" +
                "        android:layout_height=\"wrap_content\"/>\n\n\n\n"));

        dataArrayListSource.add(new Data("SeekBar","A SeekBar is an extension of ProgressBar that adds a draggable thumb.",R.drawable.seekbar,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        SeekBar seekBar=findViewById(R.id.seekBar);\n" +
                "        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {\n" +
                "            @Override\n" +
                "            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {\n" +
                "                Toast.makeText(MainActivity.this, \"\"+progress, Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStartTrackingTouch(SeekBar seekBar) {\n" +
                "                Toast.makeText(MainActivity.this, \"Seekbar Tracking started\", Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onStopTrackingTouch(SeekBar seekBar) {\n" +
                "                Toast.makeText(MainActivity.this, \"Seekbar tracking stopped\", Toast.LENGTH_SHORT).show();\n" +
                "\n" +
                "            }\n" +
                "        });\n" +
                "    }\n\n\n\n","<SeekBar\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:max=\"10\"\n" +
                "        android:id=\"@+id/seekBar\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));
        dataArrayListSource.add(new Data("Spinner","Spinners provide a quick way to select one value from a set.",R.drawable.spinner,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        Spinner spinner=findViewById(R.id.spinner);\n" +
                "        String[] colour={\"red\",\"blue\",\"orange\",\"purple\",\"yellow\"};\n" +
                "        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,colour);\n" +
                "        spinner.setAdapter(adapter);\n" +
                "    }\n\n\n\n","<Spinner\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:id=\"@+id/spinner\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:layout_height=\"wrap_content\"/>\n\n\n\n"));
        dataArrayListSource.add(new Data("RatingBar","A RatingBar is an extension of SeekBar and ProgressBar that shows a rating in stars.",R.drawable.ratingbar,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main);\n" +
                "        final RatingBar ratingBar=findViewById(R.id.ratingBar);\n" +
                "        Button btn=findViewById(R.id.btn);\n" +
                "        btn.setOnClickListener(new View.OnClickListener() {\n" +
                "            @Override\n" +
                "            public void onClick(View v) {\n" +
                "                Toast.makeText(MainActivity.this, \"\"+ratingBar.getRating(), Toast.LENGTH_SHORT).show();\n" +
                "            }\n" +
                "        });\n" +
                "    }\n\n\n\n","<RatingBar\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:id=\"@+id/ratingBar\"\n" +
                "        android:numStars=\"5\"\n" +
                "        android:stepSize=\".25\"\n" +
                "        android:layout_height=\"wrap_content\" />\n" +
                "\n" +
                "    <Button\n" +
                "        android:layout_below=\"@id/ratingBar\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:text=\"Click Me\"\n" +
                "        android:layout_centerHorizontal=\"true\"\n" +
                "        android:id=\"@+id/btn\"\n" +
                "        android:layout_height=\"wrap_content\" />\n\n\n\n"));
        dataArrayListSource.add(new Data("RadioButton","Radio buttons allow the user to select one option from a set.",R.drawable.menu,"@Override\n" +
                "    protected void onCreate(Bundle savedInstanceState) {\n" +
                "        super.onCreate(savedInstanceState);\n" +
                "        setContentView(R.layout.activity_main2);\n" +
                "        RadioGroup radioGroup=findViewById(R.id.radioGroup);\n" +
                "        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {\n" +
                "            @Override\n" +
                "            public void onCheckedChanged(RadioGroup group, int checkedId) {\n" +
                "                sw(checkedId){\n" +
                "\n" +
                "                    case R.id.radioButton1:\n" +
                "                        Toast.makeText(Main2Activity.this, \"1\", Toast.LENGTH_SHORT).show();\n" +
                "                        break;\n" +
                "                    case R.id.radioButton2:\n" +
                "                        Toast.makeText(Main2Activity.this, \"2\", Toast.LENGTH_SHORT).show();\n" +
                "                        break;\n" +
                "                    case R.id.radioButton3:\n" +
                "                        Toast.makeText(Main2Activity.this, \"3\", Toast.LENGTH_SHORT).show();\n" +
                "                        break;\n" +
                "                }\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "    }\n\n\n\n","<RadioGroup\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:id=\"@+id/radioGroup\"\n" +
                "        android:layout_height=\"match_parent\">\n" +
                "\n" +
                "        <RadioButton\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:id=\"@+id/radioButton1\"\n" +
                "            android:text=\"1\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        <RadioButton\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:id=\"@+id/radioButton2\"\n" +
                "            android:text=\"2\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        <RadioButton\n" +
                "            android:layout_width=\"wrap_content\"\n" +
                "            android:id=\"@+id/radioButton3\"\n" +
                "            android:text=\"3\"\n" +
                "            android:layout_height=\"wrap_content\" />\n" +
                "        </RadioGroup>\n\n\n\n"));


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
                    banner.setVisibility(View.GONE);
                }else{
                    adapter=new Adapter(dataArrayListSource,MainActivity.this);
                    listRecyclerView.setAdapter(adapter);
                    banner.setVisibility(View.VISIBLE);
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
