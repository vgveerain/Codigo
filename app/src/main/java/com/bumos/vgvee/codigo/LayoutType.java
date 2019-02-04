package com.bumos.vgvee.codigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LayoutType extends AppCompatActivity {

    TextView tvTitle,tvDesc;
    TextView tvTitle2,tvDesc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_type);

        tvTitle=findViewById(R.id.tvtitle);
        tvDesc=findViewById(R.id.tvdesc);
        tvTitle2=findViewById(R.id.tvtitle2);
        tvDesc2=findViewById(R.id.tvdesc2);


        tvTitle.setText("What is a Layout");
        tvDesc.setText("A layout defines the visual structure for a user interface, such as the UI for an activity or app widget. You can declare a layout in two ways:\n" +
                "\n" +
                "\u2022  Declare UI elements in XML. Android provides a straightforward XML vocabulary that corresponds to the View classes and subclasses, such as those for widgets and layouts.\n" +
                "\u2022  Instantiate layout elements at runtime. Your application can create View and ViewGroup objects (and manipulate their properties) programmatically.");
        tvTitle2.setText("\nTypes of Layout");
        tvDesc2.setText("1. Linear Layout\n" +
                "LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally.\n" +
                "\n" +
                "2. Relative Layout\n" +
                "RelativeLayout is a view group that displays child views in relative positions.\n" +
                "\n" +
                "3. Table Layout\n" +
                "TableLayout is a view that groups views into rows and columns.\n" +
                "\n" +
                "4. Absolute Layout\n" +
                "AbsoluteLayout enables you to specify the exact location of its children.\n" +
                "\n" +
                "5. Frame Layout\n" +
                "The FrameLayout is a placeholder on screen that you can use to display a single view.\n" +
                "\n" +
                "6. List View\n" +
                "ListView is a view group that displays a list of scrollable items.\n" +
                "\n" +
                "7. Grid View\n" +
                "GridView is a ViewGroup that displays items in a two-dimensional, scrollable grid.");

    }
}
