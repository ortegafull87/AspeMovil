package com.example.victordavid.aspemovil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormIncidenciaFragment extends Fragment {

    View v;

    public FormIncidenciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_form_incidencia, container, false);

        EditText edit = (EditText)v.findViewById(R.id.fecha);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setElement((TextView)v.findViewById(R.id.fecha));
                newFragment.show(getFragmentManager(), "datePicker");
            }

        });

        /*
        edit.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setElement((TextView)v.findViewById(R.id.fecha));
                newFragment.show(getFragmentManager(), "datePicker");
                return false;
            }
        });
        */
        return v;
    }
}
