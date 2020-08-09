package com.example.optic.ui.gallery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.optic.R;
import com.example.optic.addorder;
import com.example.optic.complete;
import com.example.optic.pending;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GalleryFragment extends Fragment  implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    AlertDialog.Builder builder;
    Fragment fragment;
    FloatingActionButton fb1;
    FragmentManager manager;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.order, container, false);

        fb1 = root.findViewById(R.id.fab);
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(), addorder.class);
                startActivity(i);
//
            }
        });


        tabLayout = root.findViewById(R.id.tab);

        viewPager = root.findViewById(R.id.viewpage);
        manager = getFragmentManager();
        viewPager.setAdapter(new GalleryFragment.adapter(manager));
        viewPager.setOffscreenPageLimit(2);
        tabLayout.addOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return root;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    public class adapter extends FragmentStatePagerAdapter {

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            fragment = null;
            if (position == 0) {

                fragment = new pending();


            }
            if (position == 1) {

                fragment = new complete();

            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}

