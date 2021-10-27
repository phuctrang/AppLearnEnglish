package com.example.hpt_english_app.ui.english_basic1;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.hpt_english_app.DatabaseGrammar;
import com.example.hpt_english_app.Grammar;
import com.example.hpt_english_app.GrammarAdapter;
import com.example.hpt_english_app.QuizDatabase;
import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.Question;
import com.example.hpt_english_app.ui.RespondingAction;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class english_basic1_Fragment extends Fragment {

   // private DatabaseGrammar databaseGrammar;
    private GrammarAdapter adapter;
    public ArrayList<Grammar> GrammarList;
    private QuizDatabase data;
    private english_basic1_view viewenglish1;
    private ListView lv;
    private SearchView sv;
    int position;
//#C6BCBC
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewenglish1 = new ViewModelProvider(this).get(english_basic1_view.class);
        View root = inflater.inflate(R.layout.fragment_english1, container, false);

        lv = (ListView) root.findViewById(R.id.lvEB1);
        sv = (SearchView) root.findViewById(R.id.sv_grammar);
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
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
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
        registerForContextMenu(lv);
        //
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                if(TextUtils.isEmpty(query)){
                    adapter.getFilter().filter("");
                    lv.clearTextFilter();
                    Toast.makeText(getActivity(), "Not Found!", Toast.LENGTH_LONG).show();
                }else
                {
                    adapter.getFilter().filter(query);
                }
                return true;
            }
        });
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