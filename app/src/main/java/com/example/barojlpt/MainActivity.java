package com.example.barojlpt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
    private MainMenuLearnFragment fragmentLearn = new MainMenuLearnFragment();
    private MainMenuRecordFragment fragmentRecord = new MainMenuRecordFragment();
    private MainMenuRankFragment fragmentRank = new MainMenuRankFragment();
    private MainMenuSettingsFragment fragmentSettings = new MainMenuSettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());

    }

    class ItemSelectedListener implements BottomNavigationView.OnItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.menu_home:
                    transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.menu_learn:
                    transaction.replace(R.id.menu_frame_layout, fragmentLearn).commitAllowingStateLoss();
                    break;
                case R.id.menu_record:
                    transaction.replace(R.id.menu_frame_layout, fragmentRecord).commitAllowingStateLoss();
                    break;
                case R.id.menu_rank:
                    transaction.replace(R.id.menu_frame_layout, fragmentRank).commitAllowingStateLoss();
                    break;
                case R.id.menu_settings:
                    transaction.replace(R.id.menu_frame_layout, fragmentSettings).commitAllowingStateLoss();
                    break;

            }

            return true;
        }
    }
}