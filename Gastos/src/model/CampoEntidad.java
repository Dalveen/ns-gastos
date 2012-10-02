/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class CampoEntidad {
    public static final int MODO_LECTURA = 1;
    public static final int MODO_ESCRITURA = 2;
    public static final int MODO_LECTURA_ESCRITURA = 3;
    
    private Entidad entidad;
    private String identificador;
    private Object variable;
    private Boolean requerido;
    private Date fechaDeCreacion;
    private int modo;
    
    public CampoEntidad(Entidad entidad, String identificador, Object variable, Boolean requerido, Date fechaDeCreacion, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            modo = CampoEntidad.MODO_LECTURA;
        }
        this.entidad = entidad;
        this.identificador = identificador;
        this.variable = variable;
        this.requerido = requerido;
        this.modo = modo;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public CampoEntidad(Entidad entidad, String identificador, Boolean requerido, Date fechaDeCreacion, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            modo = CampoEntidad.MODO_LECTURA;
        }
        this.entidad = entidad;
        this.identificador = identificador;
        this.variable = null;
        this.requerido = requerido;
        this.fechaDeCreacion = fechaDeCreacion;
        this.modo = modo;
    }
    
    public CampoEntidad(Entidad entidad, String identificador, Boolean requerido, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            modo = CampoEntidad.MODO_LECTURA;
        }
        this.entidad = entidad;
        this.identificador = identificador;
        this.variable = null;
        this.requerido = requerido;
        this.fechaDeCreacion = new Date();
        this.modo = modo;
    }
    
    public CampoEntidad(Entidad entidad, String identificador, Boolean requerido) {
        this.entidad = entidad;
        this.identificador = identificador;
        this.variable = null;
        this.requerido = requerido;
        this.fechaDeCreacion = new Date();
        this.modo = CampoEntidad.MODO_LECTURA;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Object getVariable() {
        return variable;
    }

    public boolean setVariable(Object variable) {
        if(this.variable == null || variable.getClass() == this.variable.getClass()) {
            this.variable = variable;
            return true;
        } else {
            return false;
        }
    }

    public boolean isRequerido() {
        return requerido.booleanValue();
    }

    public void setRequerido(Boolean requerido) {
        this.requerido = requerido;
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.entidad);
        hash = 67 * hash + Objects.hashCode(this.identificador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CampoEntidad other = (CampoEntidad) obj;
        if (!Objects.equals(this.entidad, other.entidad)) {
            return false;
        }
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CampoEntidad{" + "entidad=" + entidad + ", identificador=" + identificador + ", variable=" + variable + ", requerido=" + requerido + ", fechaDeCreacion=" + fechaDeCreacion + ", modo=" + modo + '}';
    }
}