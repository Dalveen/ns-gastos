/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class CampoEntidad {
    public static final int MODO_LECTURA = 1;
    public static final int MODO_ESCRITURA = 2;
    public static final int MODO_LECTURA_ESCRITURA = 3;
    
    private Entidad entidad;
    private Object variable;
    private Boolean requerido;
    private int modo;
    
    public CampoEntidad(Entidad entidad, Object variable, Boolean requerido, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            modo = CampoEntidad.MODO_LECTURA;
        }
        this.entidad = entidad;
        this.variable = variable;
        this.requerido = requerido;
        this.modo = modo;
    }

    public CampoEntidad(Entidad entidad, Boolean requerido, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            modo = CampoEntidad.MODO_LECTURA;
        }
        this.entidad = entidad;
        this.variable = null;
        this.requerido = requerido;
        this.modo = modo;
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
}


