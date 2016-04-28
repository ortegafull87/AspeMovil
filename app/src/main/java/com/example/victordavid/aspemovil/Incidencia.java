package com.example.victordavid.aspemovil;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class Incidencia extends AppCompatActivity {

    private InputMethodManager im ;
    //private static Utils utils =  new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidencia);
    }

    public void hideKeyboard(View view) {
        im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    /**
     *
     * @param v
     */
    public void setFechaIncidencia(View v){
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setElement((TextView)findViewById(R.id.fecha));
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /**
     *
     * @param v
     */
    public void setFechaInicia(View v){
        this.hideKeyboard(v);
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setElement((TextView)findViewById(R.id.fechaInicia));
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    /**
     *
     * @param v
     */
    public void setFechaTermina(View v){

        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setElement((TextView)findViewById(R.id.fechaTermina));
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    /**
     *
     * @param view
     */
    public void registraIncidencia(View view){
        Intent intent = new Intent(this,Signature.class);
        startActivity(intent);
    }
}


