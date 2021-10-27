package com.example.hpt_english_app.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hpt_english_app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RespondingAction extends AppCompatActivity {
    DatabaseReference data ;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responding);

        Button gui = (Button)findViewById(R.id.gui);
        EditText edt = (EditText)findViewById(R.id.responding);
        data = FirebaseDatabase.getInstance().getReference("ListResponding");
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gopy= edt.getText().toString();
                Responding res = new Responding(gopy);
                data.push().setValue(res);
            }
        });
    }
}
