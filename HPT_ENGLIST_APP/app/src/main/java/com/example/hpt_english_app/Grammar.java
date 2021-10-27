package com.example.hpt_english_app;

import java.io.Serializable;

public class Grammar implements Serializable{
    private int ID;
    private String nameGrammar;
    private String title;
    private String content;
    private String examples;

    public Grammar(int ID, String nameGrammar, String title, String content, String examples) {
        this.ID = ID;
        this.nameGrammar = nameGrammar;
        this.title = title;
        this.content = content;
        this.examples = examples;
    }

    public Grammar(){

    }
    public Grammar(String nameGrammar){
        this.nameGrammar = nameGrammar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameGrammar() {
        return nameGrammar;
    }

    public void setNameGrammar(String nameGrammar) {
        this.nameGrammar = nameGrammar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExamples() {
        return examples;
    }

    public void setExamples(String examples) {
        this.examples = examples;
    }
}
