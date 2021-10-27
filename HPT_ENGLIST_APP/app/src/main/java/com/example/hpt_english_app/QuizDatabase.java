package com.example.hpt_english_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hpt_english_app.ui.Question;
import com.example.hpt_english_app.ui.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DATABASE_EB1.db";
    private static final int DATABASE_VERSION = 1;
    //
    private SQLiteDatabase db;

    public QuizDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        // quiz table.
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                Questions_Grammar_Table.TABLE_NAME + " ( " +
                Questions_Grammar_Table.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Questions_Grammar_Table.COLUMN_CONNECT + " TEXT, " +
                Questions_Grammar_Table.COLUMN_QUESTION + " TEXT, " +
                Questions_Grammar_Table.COLUMN_OPTION1 + " TEXT, " +
                Questions_Grammar_Table.COLUMN_OPTION2 + " TEXT, " +
                Questions_Grammar_Table.COLUMN_OPTION3 + " TEXT, " +
                Questions_Grammar_Table.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        // grammar table.
        final String SQL_CREATE_QUESTIONS_TABLE_GRAMMAR = "CREATE TABLE " +
                Questions_Grammar_Table.TABLE_NAME_GRAMMAR + " ( " +
                Questions_Grammar_Table.COLUMN_ID_GR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Questions_Grammar_Table.COLUMN_NAMEGRAMMAR + " TEXT, " +
                Questions_Grammar_Table.COLUMN_TITTLE + " TEXT, " +
                Questions_Grammar_Table.COLUMN_CONTENT + " TEXT, " +
                Questions_Grammar_Table.COLUMN_EXAMPLES + " TEXT " +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE_GRAMMAR);

        fillQuestionsTable();
        fillGrammarTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Questions_Grammar_Table.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Questions_Grammar_Table.TABLE_NAME_GRAMMAR);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question q1 = new Question(  1,"I_am"," I'm ... to call my family.", "A. Tries",
                "B. Trying", "C. Try", 3);
        Question q2 = new Question(  2,"I_am"," I'm twenty ... year old.", "A. three",
                "B. there", "C. tree", 1);
        Question q3 = new Question(  3,"I_am"," I'm so ....", "A. tired",
                "B. tire", "C. tiring", 1);
        Question q4 = new Question(  4,"I_am"," I'm ... bad.", "A. veries",
                "B. very", "C. veried", 2);
        Question q5 = new Question(  5,"I_am"," I'm ... to call my family.", "A. Tries",
                "B. Trying", "C. Try", 3);
        addQuestion(q1);addQuestion(q2);addQuestion(q3);addQuestion(q4);addQuestion(q5);

        Question q11 = new Question(  1,"I_have"," I have ... cat.", "A. a",
                "B. on", "C. in", 1);
        Question q12 = new Question(  2,"I_have"," I have ... computer.", "A. a",
                "B. was", "C. at", 1);
        Question q13 = new Question(  3,"I_have"," I have it ... other way.", "A. animal",
                "B. any", "C. every", 2);
        Question q14 = new Question(  4,"I_have"," I have ... House", "A. in",
                "B. on", "C. a", 3);
        Question q15 = new Question(  5,"I_have"," I have you over ... ", "A. tonight",
                "B. tonine", "C. tonice", 1);
        addQuestion(q11);addQuestion(q12);addQuestion(q13);addQuestion(q14);addQuestion(q15);
    }

    private void fillGrammarTable() {
        Grammar g1 = new Grammar(1, "I_am","I_am","I am is an abbreviation for the word [i am] It is used in combination with other words to tell someone about yourself or to describe some thing you are doing.","I am in car.\n I am in house.\n I am in school.");
        Grammar g2 = new Grammar(2, "I_have","Basic usage of [i have]","I have is an abbreviation for the word [i have] It is used in combination with other words to tell someone about yourself or to describe some thing you are doing","I have a car.\n I have lunch.\n I have lover.");
        Grammar g3 = new Grammar(3, "I_am_good_at","Basic usage of [i am good at]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g4 = new Grammar(3, "I_am_getting","Basic usage of [I_am_getting]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g5 = new Grammar(3, "I_am_trying","Basic usage of [I_am_trying]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g6 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g7 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g8 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g9 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g10 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");
        Grammar g11 = new Grammar(3, "I_am_sorry_to","Basic usage of [I_am_sorry_to]","I am is an abbreviation for the word [i am good at], informs someone what you excel at and arecomfortable doing","I am good at drawing.\n I am good at sports.\n I am good at math.");

        addGrammar(g1);addGrammar(g2);addGrammar(g3);addGrammar(g4);addGrammar(g5);addGrammar(g6);
        addGrammar(g7);addGrammar(g8);addGrammar(g9);addGrammar(g10);addGrammar(g11);
    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(Questions_Grammar_Table.COLUMN_CONNECT, question.getNameGrammar());
        cv.put(Questions_Grammar_Table.COLUMN_QUESTION, question.getQuestion());
        cv.put(Questions_Grammar_Table.COLUMN_OPTION1, question.getOption1());
        cv.put(Questions_Grammar_Table.COLUMN_OPTION2, question.getOption2());
        cv.put(Questions_Grammar_Table.COLUMN_OPTION3, question.getOption3());
        cv.put(Questions_Grammar_Table.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(Questions_Grammar_Table.TABLE_NAME, null, cv);
    }
    private void addGrammar(Grammar grammar) {
        ContentValues cv = new ContentValues();
        cv.put(Questions_Grammar_Table.COLUMN_NAMEGRAMMAR, grammar.getNameGrammar());
        cv.put(Questions_Grammar_Table.COLUMN_TITTLE, grammar.getTitle());
        cv.put(Questions_Grammar_Table.COLUMN_CONTENT, grammar.getContent());
        cv.put(Questions_Grammar_Table.COLUMN_EXAMPLES, grammar.getExamples());
        db.insert(Questions_Grammar_Table.TABLE_NAME_GRAMMAR, null, cv);
    }
    public ArrayList<Question> Check_getAllQuestions(String check) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM quiz_questionsEB1 WHERE TRIM(connect) = '"+check.trim()+"'", null);
        if (c.moveToFirst()) {
                do {
                    Question question = new Question();
                    question.setQuestion(c.getString(2));
                    question.setOption1(c.getString(3));
                    question.setOption2(c.getString(4));
                    question.setOption3(c.getString(5));
                    question.setAnswerNr(c.getInt(6));
                    questionList.add(question);
                } while (c.moveToNext());
            }
        c.close();
        db.close();
        return questionList;
    }
    public ArrayList<Grammar> getAllGrammar() {
        ArrayList<Grammar> grammarList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Questions_Grammar_Table.TABLE_NAME_GRAMMAR, null);
        if (c.moveToNext()) {
            do {
                Grammar grammar = new Grammar();
                grammar.setNameGrammar(c.getString(1));
                grammar.setTitle(c.getString(2));
                grammar.setContent(c.getString(3));
                grammar.setExamples(c.getString(4));
                grammarList.add(grammar);
            } while (c.moveToNext());
        }
        c.close();
        return grammarList;
    }
}