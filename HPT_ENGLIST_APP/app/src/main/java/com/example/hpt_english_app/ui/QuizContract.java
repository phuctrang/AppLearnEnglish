package com.example.hpt_english_app.ui;

import android.provider.BaseColumns;
public final class QuizContract {

    private QuizContract() {
    }
    public static class Questions_Grammar_Table implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questionsEB1";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CONNECT = "connect";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";

        public static final String COLUMN_ID_GR = "id";
        public static final String TABLE_NAME_GRAMMAR = "GrammarEB1";
        public static final String COLUMN_NAMEGRAMMAR = "nameGrammar";
        public static final String COLUMN_TITTLE = "title";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_EXAMPLES = "examples";
    }
}
