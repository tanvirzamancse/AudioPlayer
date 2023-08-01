package com.tzp.audioplayer.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tzp.audioplayer.view.fragment.OneFragment;
import com.tzp.audioplayer.view.fragment.ThreeFragment;
import com.tzp.audioplayer.view.fragment.TwoFragment;

public class ViewStateAdapter extends FragmentStateAdapter {
    public ViewStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new OneFragment();
        } else if (position==1) {
            return new TwoFragment();
        }
        return new ThreeFragment();
    }

    @Override
    public int getItemCount() {
        // Hardcoded, use lists
        return 3;
    }
}
