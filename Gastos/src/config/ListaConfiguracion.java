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
}
