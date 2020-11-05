package com.aviator.festa;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.aviator.festa.abstracts.BaseActivity;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

import spencerstudios.com.bungeelib.Bungee;

public class Start extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initViews();

        Initialize();
    }

    private ImageView imgLogo;
    private ImageView imageWrds;

    public void initViews() {
        imgLogo = findViewById(R.id.imgLogo);
        imageWrds = findViewById(R.id.imageWrds);
    }

    DisplayMetrics displayMetrics;

    @Override
    public void Initialize() {
        ViewAnimator.animate(imgLogo)
                .translationY(-1000, 0)
                .alpha(0, 1)
                .andAnimate(imageWrds)
                .translationX(-200, 0)
                .interpolator(new DecelerateInterpolator())
                .duration(2500)

                .thenAnimate(imgLogo)
                .scale(1f, 0.5f, 1f)
                .interpolator(new AccelerateInterpolator())
                .duration(2500)
                .onStop(() -> {
                    finish();
                    NextActivity(Festa.class);
                    Bungee.split(Start.this);
                })
                .start();
//        displayMetrics = getResources().getDisplayMetrics();
//        imgLogo.animate().setStartDelay(5000).setDuration(2000).alpha(1).start();
//        imageWrds.animate().setStartDelay(5000).setDuration(2000).alpha(0.6f).setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                finish();
//                NextActivity(Festa.class);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        }).start();
//        label_signup.animate().setStartDelay(6000).setDuration(2000).alpha(1).start();
//        form_login.animate().translationY(dm.heightPixels).setStartDelay(0).setDuration(0).start();
//        form_login.animate().translationY(0).setDuration(1500).alpha(1).setStartDelay(6000).start();

    }
}
