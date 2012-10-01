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
    private boolean requerido;
    private int modo;

    public CampoEntidad(Entidad entidad, Object variable, boolean requerido, int modo) {
        if(modo != CampoEntidad.MODO_LECTURA || modo != CampoEntidad.MODO_ESCRITURA || modo != CampoEntidad.MODO_LECTURA_ESCRITURA) {
            throw new IllegalArgumentException();
        }
        this.entidad = entidad;
        this.variable = variable;
        this.requerido = requerido;
        this.modo = modo;
    }
    
    
}
