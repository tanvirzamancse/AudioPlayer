package com.tzp.audioplayer.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.tzp.audioplayer.R;
import com.tzp.audioplayer.data.SongMode;
import com.tzp.audioplayer.databinding.FragmentThreeBinding;
import com.tzp.audioplayer.databinding.FragmentTwoBinding;
import com.tzp.audioplayer.view.adapter.CategoryOneAdapter;
import com.tzp.audioplayer.view.adapter.CategoryTwoAdapter;
import com.tzp.audioplayer.viewmodel.ViewModelOne;
import com.tzp.audioplayer.viewmodel.ViewModelTwo;

import java.util.List;


public class TwoFragment extends Fragment {
    private FragmentTwoBinding binding;
    private FirebaseFirestore db;
    private ViewModelTwo viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTwoBinding.inflate(getLayoutInflater());
        initializations();
        body();
        clickEvent();
        return binding.getRoot();

    }

    private void initializations() {
        db = FirebaseFirestore.getInstance();
        viewModel = new ViewModelProvider(this).get(ViewModelTwo.class);
    }

    private void body() {
        viewModel.getData().observe(requireActivity(), new Observer<List<SongMode>>() {
            @Override
            public void onChanged(List<SongMode> documents) {
                CategoryTwoAdapter adapter = new CategoryTwoAdapter(documents, requireContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                binding.songCategoryTwo.setLayoutManager(layoutManager);
                binding.songCategoryTwo.setAdapter(adapter);
            }
        });


   /*
        db.collection("category_two").get().
                addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {

                            List<SongMode> types = queryDocumentSnapshots.toObjects(SongMode.class);

                            CategoryTwoAdapter adapter = new CategoryTwoAdapter(types, requireContext());
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                            binding.songCategoryTwo.setLayoutManager(layoutManager);
                            binding.songCategoryTwo.setAdapter(adapter);

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