package com.example.hpt_english_app.ui.english_basic1;
import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.hpt_english_app.Grammar;
import com.example.hpt_english_app.MainActivity;
import com.example.hpt_english_app.QuizDatabase;
import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.Question;
import com.example.hpt_english_app.ui.Responding;
import com.example.hpt_english_app.ui.RespondingAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Details_english1 extends AppCompatActivity {

    QuizDatabase data;
    private ArrayList<Question> questionList;
    Intent it;
    //private Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_grammar);


        TextView namegrammar = (TextView)findViewById(R.id.tvnamegrammar);
        TextView tittle = (TextView)findViewById(R.id.tvtittle);
        TextView content = (TextView)findViewById(R.id.tvcontent);
        TextView exp = (TextView)findViewById(R.id.tvexamples);
        Button practice = (Button)findViewById(R.id.btnpractice);

        Intent intent = getIntent();

        Grammar grammar = (Grammar) intent.getSerializableExtra("details");
        namegrammar.setText(grammar.getNameGrammar());
        tittle.setText(grammar.getTitle());
        content.setText(String.valueOf(grammar.getContent()));
        exp.setText(String.valueOf(grammar.getExamples()));



        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = grammar.getNameGrammar();
                it = new Intent(Details_english1.this, PracticeGrammar1.class);
                it.putExtra("name", name);
                startActivity(it);
                /* notifycation. */
//                String message;
//                message = "Quiz pratice: " + grammar.getTitle();
//                NotificationCompat.Builder build = new NotificationCompat.Builder(
//                        Details_english1.this
//                )
//                        .setSmallIcon(R.drawable.notify)
//                        .setContentTitle("Tiếng anh là chuyện nhỏ")
//                        .setContentText(message)
//                        .setAutoCancel(true);
//                Intent it = new Intent(Details_english1.this, PracticeGrammar1.class);
//                it.addFlags(it.FLAG_ACTIVITY_CLEAR_TOP);
//                PendingIntent pendingIntent = PendingIntent.getActivity(Details_english1.this, 0, it, PendingIntent.FLAG_UPDATE_CURRENT);
//                build.setContentIntent(pendingIntent);
//
//                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//                notificationManager.notify(0, build.build());
                //

            }
        });

        }
}







