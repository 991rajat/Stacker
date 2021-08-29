package com.example.stacker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheet<V extends View> extends BottomSheetBehavior<V> {
    private boolean enableCollapse = true;

    public BottomSheet() {
    }

    public BottomSheet(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setEnableCollapse(boolean enableCollapse) {
        this.enableCollapse = enableCollapse;
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (enableCollapse==true) {
            return false;
        }

        return super.onInterceptTouchEvent(parent, child, event);

    }
}
