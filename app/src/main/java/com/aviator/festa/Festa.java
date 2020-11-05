package com.aviator.festa;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aviator.festa.abstracts.BaseActivity;
import com.aviator.festa.abstracts.BaseFragment;
import com.aviator.festa.frags.Explore;
import com.aviator.festa.frags.Home;
import com.aviator.festa.frags.LiveLocation;

public class Festa extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festa);

        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Initialize();
        setDisplayFragment(new Home(), TAG_HOME);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private FrameLayout baseContainer;
    private AHBottomNavigation bottomNav;

    public void initViews() {
        baseContainer = findViewById(R.id.baseContainer);
        bottomNav = findViewById(R.id.bottomNav);
    }

    // TODO: 10/4/2019
    AHBottomNavigation.OnTabSelectedListener onTabSelectedListener
            = (position, wasSelected) -> {
        switch (position) {
            case 0: {
                BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(TAG_HOME);
                if (fragment == null) {
                    fragment = new Home();
                }
                setDisplayFragment(fragment, TAG_HOME);
                break;
            }
            case 1: {
                BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(TAG_EXPLORE);
                if (fragment == null) {
                    fragment = new Explore();
                }
                setDisplayFragment(fragment, TAG_EXPLORE);
                break;
            }
            case 2: {
                BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(TAG_LIVE);
                if (fragment == null) {
                    fragment = new LiveLocation();
                }
                setDisplayFragment(fragment, TAG_LIVE);
                break;
            }
        }
        return true;
    };


    AHBottomNavigationAdapter ahBottomNavigationAdapter;
    public static final String TAG_FESTA = "TAG_FESTA";
    public static final String TAG_HOME = "TAG_HOME";
    public static final String TAG_EXPLORE = "TAG_EXPLORE";
    public static final String TAG_LIVE = "TAG_LIVE";

    @Override
    public void Initialize() {
        bottomNav.setTranslucentNavigationEnabled(true);
        bottomNav.setOnTabSelectedListener(onTabSelectedListener);
        bottomNav.setAccentColor(getResources().getColor(R.color.colorAccent));

        // TODO: 4/30/2019
        ahBottomNavigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_menu);
        ahBottomNavigationAdapter.setupWithBottomNavigation(bottomNav, getResources().getIntArray(R.array.tab_colors));

    }

    // TODO: 5/19/2019
    class MyVAdapter extends FragmentPagerAdapter {

        MyVAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0: {
                    return new Home();
                }
                case 1: {
                    return new Explore();
                }
                case 2: {
                    return new LiveLocation();
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    void setDisplayFragment(@NonNull BaseFragment baseFragment, @NonNull String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.baseContainer, baseFragment, tag);
        fragmentTransaction.commit();
    }
}
