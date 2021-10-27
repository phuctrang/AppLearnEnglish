package com.example.hpt_english_app.ui.exit_responding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.Responding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class exit_fra extends Fragment {

    private exit_view slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(exit_view.class);
        View root = inflater.inflate(R.layout.responding, container, false);
        Button gui = (Button)root.findViewById(R.id.gui);
        EditText edt = (EditText)root.findViewById(R.id.responding);
        TextView tv = (TextView)root.findViewById(R.id.tvhhh);
        tv.setText("Please give your feedback after using the app.");
        DatabaseReference data ;
        data = FirebaseDatabase.getInstance().getReference("List Responding");
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gopy= edt.getText().toString();
                Responding res = new Responding(gopy);
                data.push().setValue(res);
                Toast.makeText(getActivity(), "Thanks for sended responding!!!", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
        return root;
    }
}