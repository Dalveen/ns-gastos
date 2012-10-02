/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class ListaCampoEntidad extends ArrayList<CampoEntidad> {
    private Entidad entidad;
    
    public ListaCampoEntidad(Entidad entidad) {
        super();
        this.entidad = entidad;
    }
    
    public ListaCampoEntidad(Entidad entidad, int capacidadInicial) {
        super(capacidadInicial);
        this.entidad = entidad;
    }
    
    public CampoEntidad getPorIdentificador(String identificador) {
        if(identificador == null || "".equals(identificador)) {
            return null;
        }
        try {
            CampoEntidad campo = this.get(this.indexOf(new CampoEntidad(entidad, identificador, Boolean.TRUE)));
            return campo;
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
        
        
    }
}
