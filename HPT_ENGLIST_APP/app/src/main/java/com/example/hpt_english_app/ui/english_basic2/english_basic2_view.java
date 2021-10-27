package com.example.hpt_english_app.ui.english_basic2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class english_basic2_view extends ViewModel {

    private MutableLiveData<String> mText;

    public english_basic2_view() {
        mText = new MutableLiveData<>();
        mText.setValue("This is english basic 2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}