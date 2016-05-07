package com.example.victordavid.aspemovil.Util;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by VictorDavid on 26/04/2016.
 */
public class Utils extends AppCompatActivity {

    private Calendar calendar = Calendar.getInstance();

    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * Muestra mensaje corto
     * @param messaje
     */
    public void showMessage(Context context,String messaje){
        Toast.makeText(context, messaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Obtine la fecha actual.
     * @return
     */
    public String getToDay(){
        StringBuilder date = new StringBuilder()
                .append(Integer.toString(calendar.get(Calendar.DATE)))
                .append("/")
                .append(Integer.toString(1+calendar.get(Calendar.DATE)))
                .append("/")
                .append(Integer.toString(calendar.get(Calendar.YEAR)));
        return date.toString();
    }

    /**
     * Incrementa a la fercha actual la cantidad asignada al parametro dayPlus
     * @param daysPlus
     * @return
     */
    public String addDay( int daysPlus){
        Calendar cal = Calendar.getInstance();
        cal.add( Calendar.DATE, daysPlus);

        StringBuilder date = new StringBuilder()
                .append(Integer.toString(cal.get(Calendar.DATE)))
                .append("/")
                .append(Integer.toString(1+cal.get(Calendar.DATE)))
                .append("/")
                .append(Integer.toString(cal.get(Calendar.YEAR)));
        return date.toString();
    }
}
