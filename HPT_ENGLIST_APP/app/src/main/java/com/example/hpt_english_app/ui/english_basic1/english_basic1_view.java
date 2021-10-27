package com.example.hpt_english_app.ui.english_basic1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class english_basic1_view extends  ViewModel {

    private MutableLiveData<String> mText;

    public english_basic1_view() {
        mText = new MutableLiveData<>();
        mText.setValue("");

    }
    public LiveData<String> getText() {
        return mText;
    }

}