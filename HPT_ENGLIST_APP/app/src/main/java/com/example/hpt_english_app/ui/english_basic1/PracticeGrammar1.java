package com.example.hpt_english_app.ui.english_basic1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hpt_english_app.Grammar;
import com.example.hpt_english_app.MainActivity;
import com.example.hpt_english_app.QuizDatabase;
import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.Question;

import java.util.ArrayList;
import java.util.List;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class PracticeGrammar1 extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private TextView tv;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private QuizDatabase dbHelper ;
    private ArrayList<Question> questionList = new ArrayList<>();
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private int score;
    private boolean answered;
    private long backPressedTime;
    private int Score=0, answer=0;
    private String check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.practice_grammar);
        Radiation();
        

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();
        // check quesitionlist
        getData();
        dbHelper = new QuizDatabase(this);
        questionList = dbHelper.Check_getAllQuestions(check);

        if(questionList.size() != 0){
            Toast.makeText(this, "READY!!!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "DATA HAVE'NT FOUND!!!", Toast.LENGTH_LONG).show();
            Intent intent1 = new Intent(PracticeGrammar1.this, MainActivity.class);
            startActivity(intent1);
        }
        Collections.shuffle(questionList);

        questionCountTotal = questionList.size();
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(PracticeGrammar1.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });


    }


    //anh xa - Radiation
    public void Radiation()
    {
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);

        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        tv = (TextView)findViewById(R.id.tv_tieude);
    }
    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            last();
            finishQuiz();
        }
    }
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextSize(30);
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score+=10;
            textViewScore.setText("Score: " + score);
        }
        Score = score;
        showSolution();
    }
    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer A is correct");
                //textViewQuestion.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer B is correct");
                //textViewQuestion.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer C is correct");
                //textViewQuestion.setTextColor(Color.GREEN);
                break;
        }
        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next >");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }
    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
    }
    @SuppressLint("ClickableViewAccessibility")
    public void last(){

//        MediaPlayer audio =  MediaPlayer.create(PracticeGrammar1.this, R.raw.votay);
//        audio.start();
        int answercorrect;
        Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.score);
        dialog.show();
        //add dialog in findviewbyid./
        TextView marth = (TextView)dialog.findViewById(R.id.tv_score);
        TextView number_answer = (TextView)dialog.findViewById(R.id.tv_answer);
        Button back = (Button)dialog.findViewById(R.id.hailong);
        //Button back1 = (Button)dialog.findViewById(R.id.khonghailong);
   //     Button listen = (Button)dialog.findViewById(R.id.listen);
        if(Score==0){
            answercorrect = 0;
        } else if(Score==10){
            answercorrect = 1;
        } else if(Score ==20){
            answercorrect=2;
        }else if (Score==30){
            answercorrect=3;
        }else if(Score==40){
            answercorrect=4;
        }else answercorrect=5;
        marth.setText(String.valueOf(Score));
        number_answer.setText(String.valueOf(answercorrect));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PracticeGrammar1.this, MainActivity.class);
                startActivity(intent1);
            }
        });
//        back1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(PracticeGrammar1.this, Details_english1.class);
//                startActivity(intent2);
//            }
//        });
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
            finish();
        }
        backPressedTime = System.currentTimeMillis();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    public void getData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv.setText(name);
        check = name;
//        questionList = new ArrayList<>();
//        questionList = (ArrayList<Question>) intent.getSerializableExtra("questions");
//        Collections.shuffle(questionList);
    }
}