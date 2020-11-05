package com.aviator.festa;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aviator.festa.abstracts.BaseModel;
import com.aviator.festa.adapters.EventsRecAdapter;
import com.aviator.festa.fsta.MyDecorator;
import com.aviator.festa.helpers.MainActivityHelper;
import com.aviator.festa.models.MainEventsModel;

import java.util.ArrayList;

import reubensousa.GravitySnapHelper;
import spencerstudios.com.bungeelib.Bungee;
import wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import wasabeef.recyclerview.animators.ScaleInAnimator;

public class MainActivity extends MainActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 6/1/2019
        initViews();
        setSupportActionBar(toolbar);

        Initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_create: {
                NextActivity(AddEvent.class);
                Bungee.inAndOut(this);
                break;
            }
            case R.id.nav_explore: {
                break;
            }
            case R.id.nav_search: {
                NextActivity(Search.class);
                Bungee.card(this);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private ImageView imgMainImg;
    private Toolbar toolbar;
    private ImageView navIcon;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private AHBottomNavigation bottomNavigation;

    public void initViews() {
        imgMainImg = findViewById(R.id.imgMainImg);
        toolbar = findViewById(R.id.toolbar);
        navIcon = findViewById(R.id.navIcon);
        swipeRefresh = findViewById(R.id.swipeRefresh);
        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView3 = findViewById(R.id.recyclerView3);
        bottomNavigation = findViewById(R.id.bottomNavigation);
    }


    @Override
    public void Initialize() {
        navIcon.setOnClickListener(v -> {
            if (simpleSideDrawer != null)
                simpleSideDrawer.toggleLeftDrawer();
        });

        swipeRefresh.setOnRefreshListener(() -> {
            swipeRefresh.setRefreshing(false);
            LoadData(recyclerView1);
            LoadData(recyclerView2);
            LoadData(recyclerView3);
        });
        initRec(recyclerView1);
        initRec(recyclerView2);
        initRec(recyclerView3);

        LoadData(recyclerView1);
        LoadData(recyclerView2);
        LoadData(recyclerView3);
    }


    void initRec(@NonNull RecyclerView recyclerView) {
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.addItemDecoration(new MyDecorator(8));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        new GravitySnapHelper(Gravity.START)
                .attachToRecyclerView(recyclerView);
    }

    void LoadData(@NonNull RecyclerView recyclerView) {
        new Handler().postDelayed(() -> {
            recyclerView.setAdapter(new AlphaInAnimationAdapter(
                    new EventsRecAdapter(MainActivity.this, getArrayList())
            ));
        }, 4000);
    }

    ArrayList<BaseModel> getArrayList() {
        ArrayList<BaseModel> arrayList = new ArrayList<>();
        arrayList.add(new MainEventsModel(R.mipmap.events));
        arrayList.add(new MainEventsModel(R.mipmap.dia));
        arrayList.add(new MainEventsModel(R.mipmap.chris));
        arrayList.add(new MainEventsModel(R.mipmap.dia));
        arrayList.add(new MainEventsModel(R.mipmap.events));
        arrayList.add(new MainEventsModel(R.mipmap.chris));
        return arrayList;
    }
}
