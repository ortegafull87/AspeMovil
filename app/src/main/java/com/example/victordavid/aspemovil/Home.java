package com.example.victordavid.aspemovil;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    //Obtener la instancia del administrador de fragmentos
    FragmentManager fragmentManager = getSupportFragmentManager();
    //Crear una nueva transacción
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(myToolbar);

        getDoneInstancias();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_fragment:

                //Paso 1: Obtener la instancia del administrador de fragmentos
                fragmentManager = getSupportFragmentManager();
                //Paso 2: Crear una nueva transacción
                transaction = fragmentManager.beginTransaction();
                //Paso 3: Crear un nuevo fragmento y añadirlo
                //Paso 4: Definir la acción que tendrá la carga
                transaction.replace(R.id.contenedor, new FormIncidenciaFragment());
                //Paso 5: Definir la accion goback
                transaction.addToBackStack(null);
                //Paso 6: Confirmar el cambio
                transaction.commit();

                return true;
            case R.id.action_edit:
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.contenedor, new SignaturePadFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            case R.id.action_settings:
                action(R.string.action_settings);
                return true;
            case R.id.action_help:
                action(R.string.action_help);
                return true;
            case R.id.action_about:
                action(R.string.action_about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void action(int resid) {
        Toast.makeText(this, getText(resid), Toast.LENGTH_SHORT).show();
    }
    private void getDoneInstancias(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        //VErifica a SQLit

        if(Boolean.FALSE){
            // si hay registros
        }else{
            // si no hay registros;
            transaction.replace(R.id.contenedor, new ErrorFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
