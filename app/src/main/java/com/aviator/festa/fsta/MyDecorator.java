package com.aviator.festa.fsta;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by Aviator on 1/26/2018.
 */

public class MyDecorator extends RecyclerView.ItemDecoration {
    public final int mSpace;

    public MyDecorator(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            outRect.left = mSpace;
            outRect.right = mSpace;
        } else if (parent.getLayoutManager() instanceof GridLayoutManager) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
// Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        } else if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;
// Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = mSpace;
            }
        } else {
            outRect.bottom = mSpace;
            outRect.top = mSpace;
        }

    }
}
