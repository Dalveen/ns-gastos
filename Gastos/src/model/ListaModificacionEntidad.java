/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author nightshade
 */
public class ListaModificacionEntidad extends ArrayList<ModificacionEntidad> {
    private Entidad entidad;
    
    public ListaModificacionEntidad(Entidad entidad) {
        super();
        this.entidad = entidad;
    }
    
    public ListaModificacionEntidad(Entidad entidad, int capacidadInicial) {
        super(capacidadInicial);
        this.entidad = entidad;
    }    
}
