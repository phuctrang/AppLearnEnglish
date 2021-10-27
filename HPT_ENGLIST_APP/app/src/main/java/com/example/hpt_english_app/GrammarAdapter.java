package com.example.hpt_english_app;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.example.hpt_english_app.ui.Favourite.favourite_Fragment;
import com.example.hpt_english_app.ui.Question;
import com.example.hpt_english_app.ui.english_basic1.Details_english1;
import com.example.hpt_english_app.ui.english_basic1.PracticeGrammar1;

import java.util.*;

public class GrammarAdapter extends ArrayAdapter<Grammar> implements Filterable {
    private int i = 0;
    CustomFilter filter;
    private Context mcontext;
    private ArrayList<Grammar> grammars;
    private ArrayList<Grammar> filterlist;
    private int mresource;
    private int icons[];
    //private MainActivity activity;

    public GrammarAdapter(Context context,int resource, ArrayList<Grammar> objects, int icons[]) {
        super(context,resource, objects);
        this.mcontext = context;
        this.grammars = objects;
        this.mresource = resource;
        this.filterlist = grammars;
        this.icons = icons;
    }

    class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if (constraint !=null && constraint.length()>0){
                //constraint = constraint.toString().toUpperCase();
                ArrayList<Grammar> filters = new ArrayList<Grammar>();
                for(int i =0; i<filterlist.size(); i++){
                    //
                    if(filterlist.get(i).getTitle().contains(constraint.toString())){

                        Grammar gr = new Grammar(filterlist.get(i).getID(),
                                filterlist.get(i).getTitle(), filterlist.get(i).getNameGrammar(),
                                filterlist.get(i).getContent(), filterlist.get(i).getExamples()
                        );
                        filters.add(gr);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
            else {
                //hay .///
                results.count = filterlist.size();
                results.values = filterlist;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            grammars = (ArrayList<Grammar>) results.values;
            notifyDataSetChanged();
        }
    }
    @Override
    public Filter getFilter()
    {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    @Override
    public int getCount() {
        return this.grammars.size();
    }

    @Override
    public Grammar getItem(int position) {
        return grammars.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflatE = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //viewHolder holder;
        if (convertView == null) {
            convertView = inflatE.inflate(R.layout.item, null);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.img_day);
        TextView title = (TextView) convertView.findViewById(R.id.tv_Title);
        TextView opened = (TextView) convertView.findViewById(R.id.tv_number);
        ImageButton img_favourite = (ImageButton) convertView.findViewById(R.id.img_heart);
        img.setBackgroundResource(icons[position]);
        title.setText(grammars.get(position).getNameGrammar());
        img_favourite.setBackgroundResource(R.drawable.fav1);


        img_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            // sao làm khó được a :)))
            public void onClick(View view) {
                    if(i==0){
                        img_favourite.setBackgroundResource(R.drawable.fav22);

                        Intent intent = new Intent(mcontext.getApplicationContext(),MainActivity.class);
                        String namegrammar = grammars.get(position).getNameGrammar();
                        intent.putExtra("name_fav", namegrammar);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mcontext.getApplicationContext().startActivity(intent);

                        i++;
                        //notifyDataSetChanged();
                    }
                    else {
                        img_favourite.setBackgroundResource(R.drawable.fav1);
                        i=0;
                    }
            }
        });

//        opened.setText(String.valueOf(1));
        return convertView;
    }
    public void sdd(){
        clear();
    }

}


