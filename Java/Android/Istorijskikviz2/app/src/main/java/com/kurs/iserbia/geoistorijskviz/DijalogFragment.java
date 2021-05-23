package com.kurs.iserbia.geoistorijskviz;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 25-May-17.
 */

public class DijalogFragment extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NORMAL, 0);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dijalog, container, false);
    }


}
