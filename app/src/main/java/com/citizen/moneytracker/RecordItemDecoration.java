package com.citizen.moneytracker;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordItemDecoration extends RecyclerView.ItemDecoration {
    private int offset;

    public RecordItemDecoration(int offset) {
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.top = offset;
        outRect.left = offset;
        outRect.right = offset;
    }
}
