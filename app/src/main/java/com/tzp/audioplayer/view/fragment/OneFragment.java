package com.tzp.audioplayer.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.FirebaseFirestore;
import com.tzp.audioplayer.data.SongMode;
import com.tzp.audioplayer.databinding.FragmentOneBinding;
import com.tzp.audioplayer.view.adapter.CategoryOneAdapter;
import com.tzp.audioplayer.viewmodel.ViewModelOne;

import java.util.List;

public class OneFragment extends Fragment {
    private FragmentOneBinding binding;
    private FirebaseFirestore db;
    private ViewModelOne viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOneBinding.inflate(getLayoutInflater());
        initializations();
        body();
        clickEvent();
        return binding.getRoot();

    }

    private void initializations() {
        //  DatabaseReference databaseReference=
        db = FirebaseFirestore.getInstance();
        viewModel = new ViewModelProvider(this).get(ViewModelOne.class);



    }

    private void body() {
        viewModel.getData().observe(requireActivity(), new Observer<List<SongMode>>() {
            @Override
            public void onChanged(List<SongMode> documents) {
                CategoryOneAdapter adapter = new CategoryOneAdapter(documents, requireContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                binding.songCategoryOne.setLayoutManager(layoutManager);
                binding.songCategoryOne.setAdapter(adapter);
            }
        });


      /*  db.collection("category_one").get().
                addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {

                            List<SongMode> types = queryDocumentSnapshots.toObjects(SongMode.class);

                            CategoryOneAdapter adapter = new CategoryOneAdapter(types, requireContext());
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                            binding.songCategoryOne.setLayoutManager(layoutManager);
                            binding.songCategoryOne.setAdapter(adapter);

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });*/

    }

    private void clickEvent() {

    }
}