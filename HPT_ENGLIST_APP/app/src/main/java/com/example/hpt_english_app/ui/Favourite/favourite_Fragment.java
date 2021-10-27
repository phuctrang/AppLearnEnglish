package com.example.hpt_english_app.ui.Favourite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hpt_english_app.Grammar;
import com.example.hpt_english_app.GrammarAdapter;
import com.example.hpt_english_app.R;

import java.util.ArrayList;

public class favourite_Fragment extends Fragment{

    public ArrayList<Grammar> GrammarList;
    private favourite_view slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(favourite_view.class);
        View root = inflater.inflate(R.layout.favourite, container, false);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        ListView lv = root.findViewById(R.id.lvFav);

        Intent it;
        it = getActivity().getIntent();
        String name_fav = it.getStringExtra("name_fav");
        Grammar gr = new Grammar(name_fav);

        GrammarList = new ArrayList<Grammar>();
        GrammarList.add(gr);
        int Icon[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
                R.drawable.sevent, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve,
                R.drawable.thirteen, R.drawable.fourteen, R.drawable.fiveteen, R.drawable.sixteen, R.drawable.seventeen, R.drawable.eightteen,
                R.drawable.nineteen, R.drawable.twenty, R.drawable.twentyone, R.drawable.twentytwo, R.drawable.twentythree, R.drawable.twentyfour,
                R.drawable.twentyfive, R.drawable.twentysix, R.drawable.twentyseven, R.drawable.twentyeight, R.drawable.twentynine, R.drawable.thirsty,};
        GrammarAdapter adapter = new GrammarAdapter(this.getActivity(),R.layout.item, GrammarList,Icon );
        lv.setAdapter(adapter);

        return root;
    }
}