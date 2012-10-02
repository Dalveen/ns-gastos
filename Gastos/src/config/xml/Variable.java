/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config.xml;

import config.Configuracion;
import org.jdom2.Element;

/**
 *
 * @author nightshade
 */
public class Variable extends Element{
    public Variable(Configuracion configuracion) {
        super("variable");
        this.addContent(new Element("identificador").setText(configuracion.getIdentificador()));
        this.addContent(new Element("clase").setText(configuracion.getValor().getClass().getName()));
        this.addContent(new Element("valor").setText(configuracion.getValor().toString()));
    }
}
