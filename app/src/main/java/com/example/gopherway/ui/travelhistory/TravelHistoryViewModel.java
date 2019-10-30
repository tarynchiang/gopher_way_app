package com.example.gopherway.ui.travelhistory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TravelHistoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TravelHistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Travel History");
    }

    public LiveData<String> getText() {
        return mText;
    }
}