package com.example.gopherway.ui.savedlocations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SavedLocationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SavedLocationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Saved Locations");
    }

    public LiveData<String> getText() {
        return mText;
    }
}