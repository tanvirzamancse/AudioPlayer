package com.tzp.audioplayer.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.tzp.audioplayer.R;
import com.tzp.audioplayer.databinding.ActivityMainBinding;
import com.tzp.audioplayer.view.adapter.ViewStateAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializations();
        body();
        clickEvent();
    }

    private void initializations() {
        FragmentManager fm = getSupportFragmentManager();
        ViewStateAdapter sa = new ViewStateAdapter(fm, getLifecycle());
        binding.pager.setAdapter(sa);

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("One"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Two"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Three"));

    }
    private void body() {
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });
    }
    private void clickEvent() {
    }

}