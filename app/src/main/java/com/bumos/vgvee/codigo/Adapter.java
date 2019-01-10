package com.bumos.vgvee.codigo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
//    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {
    ArrayList<Data> arrayList;
    ArrayList<Data> arrayListFull;
    Context context;

    public Adapter(ArrayList<Data> arrayList, Context context) {
        this.arrayList = arrayList;
        arrayListFull = new ArrayList<>(arrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li =LayoutInflater.from(context);
        View view = li.inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {

        final Data d=arrayList.get(i);
        viewHolder.topicTitle.setText(d.getName());
        viewHolder.topicDesc.setText(d.getDesc());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d.getName()=="TextView"){
                   Intent intent= new Intent(context,TextViewActivity.class);
                   d.progress=true;
                   d.setProgress(true);
                   Log.e("TAG",""+d.progress);
                   intent.putExtra("textview",d);
                   context.startActivity(intent);
                }
                else if(d.getName()=="Button"){
                    Intent intent= new Intent(context,ButtonActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("button",d);
                    context.startActivity(intent);

                } else if(d.getName()=="SnackBar"){
                    Intent intent= new Intent(context,SnackBarActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("snackbar",d);
                    context.startActivity(intent);

                } else if(d.getName()=="RadioButton"){
                    Intent intent= new Intent(context,RadioButtonActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("radiobutton",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="New Project"){
                    Intent intent= new Intent(context,NewProjectActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("project",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="Activity LifeCycle"){
                    Intent intent= new Intent(context,LifecycleActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("lifecycle",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="ImageView"){
                    Intent intent= new Intent(context,ImageviewActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("imageview",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="Basic Calculator"){
                    Intent intent= new Intent(context,CalculatorActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("calculator",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="EditText"){
                    Intent intent= new Intent(context,EdittextActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("edittext",d);
                    context.startActivity(intent);
                } else if(d.getName()=="TextClock"){
                    Intent intent= new Intent(context,TextClockActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("textclock",d);
                    context.startActivity(intent);

                } else if(d.getName()=="DatePicker"){
                    Intent intent= new Intent(context,DatePickerActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("datepicker",d);
                    context.startActivity(intent);

                } else if(d.getName()=="ListView"){
                    Intent intent= new Intent(context,ListViewActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("listview",d);
                    context.startActivity(intent);
                }
                else if(d.getName()=="WebView"){
                    Intent intent= new Intent(context,WebviewActivity.class);
                    d.progress=true;
                    d.setProgress(true);
                    Log.e("TAG",""+d.progress);
                    intent.putExtra("webview",d);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

//    @Override
//    public Filter getFilter() {
//        return listFilter;
//    }
//
//   private Filter listFilter = new Filter() {
//       @Override
//       protected FilterResults performFiltering(CharSequence constraint) {
//        ArrayList<Data> found = new ArrayList<>();
//
//        if(constraint == null || constraint.length() == 0) {
//            found.addAll(arrayListFull);
//        } else {
//            String filterPattern = constraint.toString().toLowerCase().trim();
//
//            for (Data item:arrayListFull)
//            {
//             if(item.name.toLowerCase().trim().contains(filterPattern))
//                 found.add(item);
//            }
//        }
//        FilterResults results = new FilterResults();
//        results.values = found;
//        return results;
//       }
//
//
//       @Override
//       protected void publishResults(CharSequence constraint, FilterResults results) {
//        arrayList.clear();
//        arrayList.addAll((ArrayList) results.values);
//        notifyDataSetChanged();
//       }
//   };

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView androidImage;
        TextView topicTitle,topicDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            androidImage=itemView.findViewById(R.id.androidImage);
            topicTitle=itemView.findViewById(R.id.topicTitle);
            topicDesc=itemView.findViewById(R.id.topicDesc);
        }
    }
}
