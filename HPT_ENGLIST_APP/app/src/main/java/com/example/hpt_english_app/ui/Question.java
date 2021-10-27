package com.example.hpt_english_app.ui;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String nameGrammar;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;

    public Question() {
    }
//    public Question(int id, String question, String option1, String option2, String option3, int answerNr) {
//        this.id = id;
//        this.question = question;
//        this.option1 = option1;
//        this.option2 = option2;
//        this.option3 = option3;
//        this.answerNr = answerNr;
//    }


    public Question(int id, String nameGrammar, String question, String option1, String option2, String option3, int answerNr) {
        this.id = id;
        this.nameGrammar = nameGrammar;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
    }

    public String getNameGrammar() { return nameGrammar; }
    public void setNameGrammar(String nameGrammar) { this.nameGrammar = nameGrammar; }
    public int getId() {
        return id;
    }
    public void setId(int connect) { this.id = id; }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public int getAnswerNr() {
        return answerNr;
    }
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
