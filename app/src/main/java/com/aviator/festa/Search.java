package com.aviator.festa;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.aviator.festa.abstracts.BaseActivity;
import com.aviator.festa.fsta.CustomCl;
import com.robertlevonyan.views.chip.Chip;

import hari.bounceview.BounceView;

public class Search extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initViews();
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Initialize();
    }

    private Toolbar toolbar;
    private LinearLayout chipContainer;
    private FloatingActionButton fab;

    public void initViews() {
        toolbar = findViewById(R.id.toolbar);
        chipContainer = findViewById(R.id.chipContainer);
        fab = findViewById(R.id.fab);
    }


    @Override
    public void Initialize() {
        String[] vals = getResources().getStringArray(R.array.categories_main);
        for (String val : vals) {
            chipContainer.addView(getChipView(val, Search.this));
        }
    }

    static View getChipView(@NonNull String title, @NonNull Context context) {
        View view = new CustomCl.Builder(context)
                .getView(R.layout.chipviewly);
        Chip chipView;
        chipView = view.findViewById(R.id.chipView);
        chipView.setChipText(title);
        chipView.setClickable(true);
        chipView.setTextColor(R.color.grey_0);
        view.offsetLeftAndRight(8);
        view.setBackground(new ColorDrawable(ContextCompat.getColor(context, R.color.colorPrimary)));
        BounceView.addAnimTo(view);
        return view;
    }
}
