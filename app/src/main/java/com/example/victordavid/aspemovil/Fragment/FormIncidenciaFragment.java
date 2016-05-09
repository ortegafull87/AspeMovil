package com.example.victordavid.aspemovil.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.victordavid.aspemovil.Bean.IncidenciaBean;
import com.example.victordavid.aspemovil.Fragment.DatePickerFragment;
import com.example.victordavid.aspemovil.Fragment.TimePickerFragment;
import com.example.victordavid.aspemovil.Home;
import com.example.victordavid.aspemovil.R;
import com.example.victordavid.aspemovil.Util.Utils;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormIncidenciaFragment extends Fragment  {

    private View v;
    private String NOMBRE_FRAGMENT = "Incidencia";

    public FormIncidenciaFragment() {
        // Required empty public constructor
    }

    public interface Empacable {

        public IncidenciaBean getFormIncidencia();
    }

    private ActionBar getActionBar() {
        return ((Home) getActivity()).getSupportActionBar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActionBar().setTitle(NOMBRE_FRAGMENT);
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_form_incidencia, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.gastos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setTop(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemIdAtPosition(position)!= 0) {
                    Toast.makeText(
                            parent.getContext(),
                            "Seleccionaaste: " + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*Listener Para Fecha*/
        EditText fecha = (EditText) v.findViewById(R.id.fecha);
        /*Se precarga este campo con la fecha actual*/
        fecha.setText(new Utils().getToDay());
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setElement((TextView) v.findViewById(R.id.fecha));
                newFragment.show(getFragmentManager(), "datePicker");
            }

        });

        /*Listener Para Fecha Inicio*/
        EditText fechaInicio = (EditText) v.findViewById(R.id.fechaInicio);
        /*Se precarga este campo con la fecha actual*/
        fechaInicio.setText(new Utils().getToDay());
        fechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setElement((TextView) v.findViewById(R.id.fechaInicio));
                newFragment.show(getFragmentManager(), "datePicker");
            }

        });

        /*Listener Para Hora Inicio*/
        EditText horaInicio = (EditText) v.findViewById(R.id.horaInicio);
        horaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment newFragment = new TimePickerFragment();
                newFragment.setElement((TextView) v.findViewById(R.id.horaInicio));
                newFragment.show(getFragmentManager(), "timePicker");
            }

        });

        /*Listener Para Fecha Termino*/
        EditText fechaTermino = (EditText) v.findViewById(R.id.fechaTermino);
        fechaTermino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setElement((TextView) v.findViewById(R.id.fechaTermino));
                newFragment.show(getFragmentManager(), "datePicker");
            }

        });

        /*Listener Para Hora Termino*/
        EditText horaTermino = (EditText) v.findViewById(R.id.horaTermino);
        horaTermino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment newFragment = new TimePickerFragment();
                newFragment.setElement((TextView) v.findViewById(R.id.horaTermino));
                newFragment.show(getFragmentManager(), "timePicker");
            }

        });
        return v;
    }

    public IncidenciaBean getFormIncidencia(View view) {
        IncidenciaBean incidenciaBean = new IncidenciaBean();
        EditText fecha = (EditText) view.findViewById(R.id.fecha);
        incidenciaBean.setFechaIncidencia("10/12/2016");
        return incidenciaBean;
    }

}