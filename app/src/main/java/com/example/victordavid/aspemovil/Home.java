package com.example.victordavid.aspemovil;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.victordavid.aspemovil.Bean.GastosBean;
import com.example.victordavid.aspemovil.Bean.IncidenciaBean;
import com.example.victordavid.aspemovil.Fragment.ErrorFragment;
import com.example.victordavid.aspemovil.Fragment.FormIncidenciaFragment;
import com.example.victordavid.aspemovil.Fragment.SignaturePadFragment;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    //Obtener la instancia del administrador de fragmentos
    FragmentManager fragmentManager = getSupportFragmentManager();
    //Crear una nueva transacción
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    private IncidenciaBean incidenciaBean;
    private ArrayList<GastosBean> gastosBeanArrayList;

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

                Toast.makeText(getApplicationContext(),"Fecha:"+getFormIncidencia().getFechaIncidencia(), Toast.LENGTH_SHORT).show();
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

    private IncidenciaBean getFormIncidencia(){
        //Fecha Incidencia.
        EditText formElement = (EditText) findViewById(R.id.fecha);
        incidenciaBean = new IncidenciaBean();
        incidenciaBean.setFechaIncidencia(formElement.getText().toString());
        //Guardia Faltó
        formElement = (EditText)findViewById(R.id.guardiaF);
        incidenciaBean.setGuardiaFalto(formElement.getText().toString());
        //Guardia Suple.
        formElement = (EditText)findViewById(R.id.guardiaS);
        incidenciaBean.setGuardiaSuple(formElement.getText().toString());
        //Fecha y Hora Inicia
        StringBuilder elementoCompuesto = new StringBuilder();
        formElement = (EditText)findViewById(R.id.fechaInicio);
        elementoCompuesto.append(formElement.getText().toString());
        elementoCompuesto.append(" ");
        formElement = (EditText)findViewById(R.id.horaInicio);
        elementoCompuesto.append(formElement.getText().toString());
        incidenciaBean.setFechaHoraInicia(elementoCompuesto.toString());
        //Fecha y Hora Termina
        elementoCompuesto = new StringBuilder();
        formElement = (EditText)findViewById(R.id.fechaTermino);
        elementoCompuesto.append(formElement.getText().toString());
        elementoCompuesto.append(" ");
        formElement = (EditText)findViewById(R.id.horaTermino);
        elementoCompuesto.append(formElement.getText().toString());
        //Gastos
        incidenciaBean.setGastos(this.getGastosForm());
        //Observaciones
        /*formElement = (EditText)findViewById(R.id.observaciones);
        incidenciaBean.setObservaciones(formElement.getText().toString());*/
        return incidenciaBean;

    }

    /**
     *
     */
    private void setListaGastos(){

    }

    /**
     *
     * @return
     */
    private ArrayList<GastosBean> getGastosForm(){
        return new ArrayList<GastosBean>();
    }
}
