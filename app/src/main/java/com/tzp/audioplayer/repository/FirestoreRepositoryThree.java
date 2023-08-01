package com.tzp.audioplayer.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.tzp.audioplayer.data.SongMode;

import java.util.List;

public class FirestoreRepositoryThree {
    private FirebaseFirestore firestore;

    public FirestoreRepositoryThree() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void getDataFromFirestore(DataCallback callback) {
        firestore.collection("category_three")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            callback.onSuccess(querySnapshot.toObjects(SongMode.class));
                        }
                    } else {
                        callback.onError(task.getException());
                    }
                });
    }

    public interface DataCallback {
        void onSuccess(List<SongMode> documents);
        void onError(Exception e);
    }
}
