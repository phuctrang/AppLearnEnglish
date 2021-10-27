package com.example.hpt_english_app.ui.english_basic2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hpt_english_app.Grammar;
import com.example.hpt_english_app.GrammarAdapter;
import com.example.hpt_english_app.QuizDatabase;
import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.english_basic1.Details_english1;
import com.example.hpt_english_app.ui.english_basic1.english_basic1_view;

import java.util.ArrayList;
import java.util.Collections;

public class english_basic2_Fragment extends Fragment {

    private english_basic2_view homeViewModel;

    private GrammarAdapter adapter;
    public ArrayList<Grammar> GrammarList;
    private QuizDatabase data;
    private english_basic1_view viewenglish1;
    private GridView gridView;
    int position;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(english_basic2_view.class);
        View root = inflater.inflate(R.layout.fragment_english2, container, false);

        gridView = (GridView) root.findViewById(R.id.gridView);
        TextView tv = (TextView) root.findViewById(R.id.tv_number);
        // Button alo = (Button) root.findViewById(R.id.alo);
        data = new QuizDatabase(getContext());
        GrammarList = data.getAllGrammar();
        Collections.shuffle(GrammarList);

        int Icon[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
                R.drawable.sevent, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve,
                R.drawable.thirteen, R.drawable.fourteen, R.drawable.fiveteen, R.drawable.sixteen, R.drawable.seventeen, R.drawable.eightteen,
                R.drawable.nineteen, R.drawable.twenty, R.drawable.twentyone, R.drawable.twentytwo, R.drawable.twentythree, R.drawable.twentyfour,
                R.drawable.twentyfive, R.drawable.twentysix, R.drawable.twentyseven, R.drawable.twentyeight, R.drawable.twentynine, R.drawable.thirsty,};
        adapter = new GrammarAdapter(this.getActivity(),R.layout.item, GrammarList,Icon);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
//
//            ArrayList<Integer> count = new ArrayList<Integer>();
//            try {
//                count.add(position, count.get(position) + 1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            int totalcount= count.get(position);
//            tv.setText(String.valueOf(totalcount));
//
            Intent intent = new Intent(getActivity(), Details_english1.class);
            int ID = GrammarList.get(position).getID();
            String content = GrammarList.get(position).getContent();
            String tittle = GrammarList.get(position).getTitle();
            String name = GrammarList.get(position).getNameGrammar();
            String exp = GrammarList.get(position).getExamples();
            Grammar gr = new Grammar(ID,name,tittle,content,exp);
            intent.putExtra("details",  gr);
            startActivity(intent);
        });

        registerForContextMenu(gridView);

//        final TextView textView = root.findViewById(R.id.text_english2);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        position = info.position;
        switch(item.getItemId()) {
            case R.id.Menu_settop:

                // vi tri hien tai
                int ID = GrammarList.get(position).getID();
                String nameGrammar =GrammarList.get(position).getNameGrammar();;
                String title= GrammarList.get(position).getTitle();;
                String content= GrammarList.get(position).getContent();;
                String examples= GrammarList.get(position).getExamples();;
                Grammar gr_current = new Grammar(ID, nameGrammar, title, content, examples);
                // vi tri on top 1
                int ID0 = GrammarList.get(0).getID();
                String nameGrammar0 =GrammarList.get(0).getNameGrammar();;
                String title0= GrammarList.get(0).getTitle();;
                String content0= GrammarList.get(0).getContent();;
                String examples0= GrammarList.get(0).getExamples();;
                Grammar gr_first = new Grammar(ID0, nameGrammar0, title0, content0, examples0);
                GrammarList.set(position, gr_first);
                GrammarList.set(0, gr_current);
                adapter.notifyDataSetChanged();
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_item, menu);
    }
}