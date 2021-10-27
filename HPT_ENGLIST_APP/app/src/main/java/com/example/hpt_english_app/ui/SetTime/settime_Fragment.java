package com.example.hpt_english_app.ui.SetTime;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hpt_english_app.R;
import com.example.hpt_english_app.ui.settime;

public class settime_Fragment extends Fragment{

    private com.example.hpt_english_app.ui.SetTime.settime_view slideshowViewModel;
    private TextView mTextView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(settime_view.class);
        View root = inflater.inflate(R.layout.set_time, container, false);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        mTextView = root.findViewById(R.id.textView);
        Button change = root.findViewById(R.id.changeactivity);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), settime.class);
                startActivity(it);
//                DialogFragment timePicker = new TimePickerFragment();
//                timePicker.show(getActivity().getFragmentManager(), "time picker");
//                TimePickerFragment dialog = new TimePickerFragment();time
//                dialog.show(getActivity().getFragmentManager(), DIALOG_TIME);
            }
        });
        return root;
    }
}