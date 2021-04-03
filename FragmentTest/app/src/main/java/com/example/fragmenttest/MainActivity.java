package com.example.fragmenttest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tab;
ViewPager viewPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tb);
        viewPage=findViewById(R.id.myviewpager);
        tab.setupWithViewPager(viewPage);

    }
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
        String tabTitles[]={"chats","status","calls"};

        public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm,behavior);
        }

        public MyFragmentPagerAdapter() {
            super();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0)
            {
                return new ChatsFragment();
            }
            if (position==1)
            {
                return new StatusFragment();
            }
            if (position==2)
            {
                return  new CallsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}