package com.example.hpt_english_app.ui.SetTime;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class settime_view extends ViewModel {

    private MutableLiveData<String> mText;

    public settime_view() {
        mText = new MutableLiveData<>();
        mText.setValue("This is settime fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}