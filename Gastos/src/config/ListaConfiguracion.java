/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;

/**
 *
 * @author nightshade
 */
public class ListaConfiguracion extends ArrayList<Configuracion> {
    public ListaConfiguracion() {
        super();
    }
    
    public ListaConfiguracion(int capacidadInicial) {
        super(capacidadInicial);
    }
    
    public Configuracion getPorIdentificador(String identificador) {
        if(identificador == null || "".equals(identificador)) {
            return null;
        }
        try {
            Configuracion config = this.get(this.indexOf(new Configuracion(identificador)));
            return config;
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
        
        
    }
}
