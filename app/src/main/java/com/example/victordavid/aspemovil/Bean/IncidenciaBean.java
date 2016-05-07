package com.example.victordavid.aspemovil.Bean;

import com.example.victordavid.aspemovil.Bean.GastosBean;

import java.util.ArrayList;

/**
 * Created by VictorDavid on 06/05/2016.
 */
public class IncidenciaBean {

    private String claveIncidencia;
    private String fechaIncidencia;
    private String guardiaFalto;
    private String guardiaSuple;
    private String fechaHoraInicia;
    private String fechaHoraTErmina;
    private ArrayList<GastosBean> gastos;
    private String uriFirma;
    private String observaciones;

    public String getClaveIncidencia() {
        return claveIncidencia;
    }

    public void setClaveIncidencia(String claveIncidencia) {
        this.claveIncidencia = claveIncidencia;
    }

    public String getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(String fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    public String getGuardiaFalto() {
        return guardiaFalto;
    }

    public void setGuardiaFalto(String guardiaFalto) {
        this.guardiaFalto = guardiaFalto;
    }

    public String getGuardiaSuple() {
        return guardiaSuple;
    }

    public void setGuardiaSuple(String guardiaSuple) {
        this.guardiaSuple = guardiaSuple;
    }

    public String getFechaHoraInicia() {
        return fechaHoraInicia;
    }

    public void setFechaHoraInicia(String fechaHoraInicia) {
        this.fechaHoraInicia = fechaHoraInicia;
    }

    public String getFechaHoraTErmina() {
        return fechaHoraTErmina;
    }

    public void setFechaHoraTErmina(String fechaHoraTErmina) {
        this.fechaHoraTErmina = fechaHoraTErmina;
    }

    public ArrayList<GastosBean> getGastos() {
        return gastos;
    }

    public void setGastos(ArrayList<GastosBean> gastos) {
        this.gastos = gastos;
    }

    public String getUriFirma() {
        return uriFirma;
    }

    public void setUriFirma(String uriFirma) {
        this.uriFirma = uriFirma;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
