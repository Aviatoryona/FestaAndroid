package com.aviator.festa;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;

import android.widget.GridView;

import com.aviator.festa.abstracts.BaseActivity;
import com.joooonho.SelectableRoundedImageView;

import spencerstudios.com.bungeelib.Bungee;

public class AddEvent extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        initViews();

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // TODO: 5/26/2019

        Initialize();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideDown(this);
    }

    private Toolbar toolbar;
    private SelectableRoundedImageView imgMainImg;
    private GridView gridView;
    private FloatingActionButton fab;

    public void initViews() {
        toolbar = findViewById(R.id.toolbar);
        imgMainImg = findViewById(R.id.imgMainImg);
        gridView = findViewById(R.id.gridView);
        fab = findViewById(R.id.fab);
    }


    @Override
    public void Initialize() {
        fab.setOnClickListener(v -> {
            finish();
            Bungee.slideDown(AddEvent.this);
        });
    }
}
