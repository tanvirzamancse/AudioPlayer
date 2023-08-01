package com.tzp.audioplayer.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tzp.audioplayer.data.SongMode;
import com.tzp.audioplayer.repository.FirestoreRepositoryOne;
import com.tzp.audioplayer.repository.FirestoreRepositoryThree;

import java.util.List;

public class ViewModelThree extends ViewModel {
    private MutableLiveData<List<SongMode>> data;
    private FirestoreRepositoryThree firestoreRepository;

    public ViewModelThree() {
        data = new MutableLiveData<>();
        firestoreRepository = new FirestoreRepositoryThree();
        fetchDataFromFirestore();
    }

    public LiveData<List<SongMode>> getData() {
        return data;
    }

    private void fetchDataFromFirestore() {
        firestoreRepository.getDataFromFirestore(new FirestoreRepositoryThree.DataCallback() {
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
