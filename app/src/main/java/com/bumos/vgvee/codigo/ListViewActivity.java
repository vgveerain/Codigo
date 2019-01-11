package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ListViewActivity extends AppCompatActivity {

    TextView tvtitle,tvdesc;
    ImageView ivxml,ivcode;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        tvtitle=findViewById(R.id.tvtitle);
        tvdesc=findViewById(R.id.tvdesc);
        ivcode=findViewById(R.id.ivjava);
        listView=findViewById(R.id.listview);
        ivxml=findViewById(R.id.ivxml);
        Data d = getIntent().getParcelableExtra("listview");
        tvtitle.setText(d.getName());
        tvdesc.setText(d.getDesc());
        Picasso.get().load(R.drawable.listviewjava).into(ivcode);
        Picasso.get().load(R.drawable.listviewxml).into(ivxml);
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.listitemrow,R.id.label,numbers);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),""+position,Toast.LENGTH_SHORT).show();
            }
        });
//        listView.setNestedScrollingEnabled(true);
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
    }
}
