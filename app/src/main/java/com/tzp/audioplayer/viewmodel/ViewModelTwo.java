package com.tzp.audioplayer.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tzp.audioplayer.data.SongMode;
import com.tzp.audioplayer.repository.FirestoreRepositoryOne;
import com.tzp.audioplayer.repository.FirestoreRepositoryTwo;

import java.util.List;

public class ViewModelTwo extends ViewModel {
    private MutableLiveData<List<SongMode>> data;
    private FirestoreRepositoryTwo firestoreRepository;

    public ViewModelTwo() {
        data = new MutableLiveData<>();
        firestoreRepository = new FirestoreRepositoryTwo();
        fetchDataFromFirestore();
    }

    public LiveData<List<SongMode>> getData() {
        return data;
    }

    private void fetchDataFromFirestore() {
        firestoreRepository.getDataFromFirestore(new FirestoreRepositoryTwo.DataCallback() {
            @Override
            public void onSuccess(List<SongMode> documents) {
                data.setValue(documents);
            }

            @Override
            public void onError(Exception e) {
                // Handle error here
            }
        });
    }
}
