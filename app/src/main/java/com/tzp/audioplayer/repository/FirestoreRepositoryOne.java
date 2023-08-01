package com.tzp.audioplayer.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.tzp.audioplayer.data.SongMode;

import java.util.List;

public class FirestoreRepositoryOne {
    private FirebaseFirestore firestore;

    public FirestoreRepositoryOne() {

        firestore = FirebaseFirestore.getInstance();

    }

    public void getDataFromFirestore(DataCallback callback) {

        firestore.collection("category_one")
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
