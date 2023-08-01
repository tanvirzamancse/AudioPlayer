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
import com.tzp.audioplayer.databinding.FragmentOneBinding;
import com.tzp.audioplayer.databinding.FragmentThreeBinding;
import com.tzp.audioplayer.databinding.FragmentTwoBinding;
import com.tzp.audioplayer.view.adapter.CategoryOneAdapter;
import com.tzp.audioplayer.view.adapter.CategoryThreeAdapter;
import com.tzp.audioplayer.view.adapter.CategoryTwoAdapter;
import com.tzp.audioplayer.viewmodel.ViewModelOne;
import com.tzp.audioplayer.viewmodel.ViewModelThree;

import java.util.List;

public class ThreeFragment extends Fragment {
    private FragmentThreeBinding binding;
    private FirebaseFirestore db;
    private ViewModelThree viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThreeBinding.inflate(getLayoutInflater());
        initializations();
        body();
        clickEvent();
        return binding.getRoot();

    }

    private void initializations() {
        db = FirebaseFirestore.getInstance();
        viewModel = new ViewModelProvider(this).get(ViewModelThree.class);
    }

    private void body() {

        viewModel.getData().observe(requireActivity(), new Observer<List<SongMode>>() {
            @Override
            public void onChanged(List<SongMode> documents) {
                CategoryThreeAdapter adapter = new CategoryThreeAdapter(documents, requireContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                binding.songCategoryThree.setLayoutManager(layoutManager);
                binding.songCategoryThree.setAdapter(adapter);
            }
        });


       /* db.collection("category_three").get().
                addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {

                            List<SongMode> types = queryDocumentSnapshots.toObjects(SongMode.class);
                            CategoryThreeAdapter adapter = new CategoryThreeAdapter(types, requireContext());
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                            binding.songCategoryThree.setLayoutManager(layoutManager);
                            binding.songCategoryThree.setAdapter(adapter);

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