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
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
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
                /**
                Intent intent = new Intent(this,Incidencia.class);
                startActivity(intent);
                action(R.string.action_add);
                 */
                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                FormIncidenciaFragment fragment = new FormIncidenciaFragment();
                transaction.add(R.id.contenedor, fragment);

                //Paso 4: Confirmar el cambio
                transaction.commit();
                //myToolbar.setTitle("Incidencia");
                return true;
            case R.id.action_edit:
                action(R.string.action_edit);
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
}
