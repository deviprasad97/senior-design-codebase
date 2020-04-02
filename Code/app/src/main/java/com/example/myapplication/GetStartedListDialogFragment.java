package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     GetStartedListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class GetStartedListDialogFragment extends BottomSheetDialogFragment {

    public static GetStartedListDialogFragment newInstance() {
        return new GetStartedListDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.get_started_bottom_sheet, container,
                false);
        Button mobileUser = view.findViewById(R.id.mobile_user);
        mobileUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // get the views and attach the listener

        return view;

    }

}
