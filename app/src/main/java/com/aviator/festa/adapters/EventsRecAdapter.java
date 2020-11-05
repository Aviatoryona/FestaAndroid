package com.aviator.festa.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseActivity;
import com.aviator.festa.abstracts.BaseFragment;
import com.aviator.festa.abstracts.BaseModel;
import com.aviator.festa.abstracts.BaseRecAdapter;
import com.aviator.festa.fsta.CustomCl;
import com.aviator.festa.vholders.EventsRecVHolder;

import java.util.ArrayList;

public class EventsRecAdapter extends BaseRecAdapter {
    public EventsRecAdapter(BaseFragment baseFragment, ArrayList<BaseModel> arrayList) {
        this.fragment = baseFragment;
        this.arrayList = arrayList;
        this.context = this.fragment.getContext();
    }

    public EventsRecAdapter(BaseActivity baseActivity, ArrayList<BaseModel> arrayList) {
        this.activity = baseActivity;
        this.arrayList = arrayList;
        this.context = this.activity.getApplicationContext();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = new CustomCl.Builder(context).getView(viewGroup, R.layout.hori_main_event_model);
        return new EventsRecVHolder(view);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
