package com.aviator.festa.helpers;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseActivity;
import com.navdrawer.SimpleSideDrawer;

public abstract class MainActivityHelper extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSimpleSideDrawer();
    }

   protected SimpleSideDrawer simpleSideDrawer;

    protected void setSimpleSideDrawer() {
        simpleSideDrawer = new SimpleSideDrawer(this, new AccelerateDecelerateInterpolator(), 2000);
        simpleSideDrawer.setLeftBehindContentView(R.layout.left_slide);
    }
}
