package com.example.stacker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FrameLayout firstBottomSheet = findViewById(R.id.stack_1);
        FrameLayout secondBottomSheet = findViewById(R.id.stack_2);
        BottomSheet firstBottomSheetBehavior = (BottomSheet) BottomSheetBehavior.from(firstBottomSheet);
        BottomSheet secondBottomSheetBehaviour = (BottomSheet)BottomSheetBehavior.from(secondBottomSheet);


        MaterialButton Drop1 = findViewById(R.id.stack_1_btn);
        MaterialButton Drop2 = findViewById(R.id.stack_2_btn);

        firstBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING||newState==BottomSheetBehavior.STATE_EXPANDED) {
                    firstBottomSheetBehavior .setEnableCollapse(false);

                }else if(newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    firstBottomSheetBehavior .setEnableCollapse(true);

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });




        secondBottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(firstBottomSheetBehavior.getState()== BottomSheetBehavior.STATE_EXPANDED) {

                    if (newState == BottomSheetBehavior.STATE_DRAGGING || newState == BottomSheetBehavior.STATE_EXPANDED) {
                        secondBottomSheetBehaviour.setEnableCollapse(false);

                    } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                        secondBottomSheetBehaviour.setEnableCollapse(true);

                    }
                }else {
                    secondBottomSheetBehaviour.setState(BottomSheet.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


        Drop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    firstBottomSheetBehavior.setState(BottomSheet.STATE_EXPANDED);
                    secondBottomSheet.setVisibility(View.VISIBLE);
                }
                else {
                    firstBottomSheetBehavior.setState(BottomSheet.STATE_COLLAPSED);
                    secondBottomSheet.setVisibility(View.GONE);
                }
            }
        });

        Drop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    if (secondBottomSheetBehaviour.getState() != BottomSheetBehavior.STATE_EXPANDED)
                        secondBottomSheetBehaviour.setState(BottomSheet.STATE_EXPANDED);
                    else
                        secondBottomSheetBehaviour.setState(BottomSheet.STATE_COLLAPSED);
                }
            }
        });

    }
}