package com.app.armynote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView name_w;
    TextView rank_w;
    TabLayout tabLayout;
    ViewPager pager;

    ArrayList<Fragment> frag_list = new ArrayList<Fragment>();
    ArrayList<String> title_list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);

        LocationStateFragment locationStateFragment = new LocationStateFragment();
        PXFragment pxFragment = new PXFragment();

        frag_list.add(locationStateFragment);
        frag_list.add(pxFragment);

        title_list.add("위치현황판");
        title_list.add("PX");

        pager = (ViewPager)findViewById(R.id.pager);
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        name_w = (TextView)findViewById(R.id.name);

        Intent member_info = getIntent();

        String serial_number = getIntent().getStringExtra("serial_number");
        String name = getIntent().getStringExtra("name");
        String rank = getIntent().getStringExtra("rank");
        String assignment = getIntent().getStringExtra("assignment");
        String location = getIntent().getStringExtra("location");
    }

    class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount(){
            return frag_list.size();
        }

        @Override
        public Fragment getItem(int i){
            return frag_list.get(i);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            return title_list.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }
}
