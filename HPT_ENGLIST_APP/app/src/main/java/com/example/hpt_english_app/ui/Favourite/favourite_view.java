package com.example.hpt_english_app.ui.Favourite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class favourite_view extends ViewModel {

    private MutableLiveData<String> mText;

    public favourite_view() {
        mText = new MutableLiveData<>();
        mText.setValue("This is favourite fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}