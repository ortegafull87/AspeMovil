package com.example.victordavid.aspemovil;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by VictorDavid on 26/04/2016.
 */
public class Utils extends AppCompatActivity {

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
    public void showMessage(String messaje){
        Toast.makeText(getApplicationContext(), messaje, Toast.LENGTH_SHORT).show();
    }
}
