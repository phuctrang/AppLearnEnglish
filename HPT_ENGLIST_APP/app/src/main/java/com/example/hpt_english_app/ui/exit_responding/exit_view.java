package com.example.hpt_english_app.ui.exit_responding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class exit_view extends ViewModel {

    private MutableLiveData<String> mText;

    public exit_view() {
        mText = new MutableLiveData<>();
        mText.setValue("This is exit fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}