/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import config.xml.Variable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author nightshade
 */
public class Configuracion {
    private String identificador;
    private Object valor;
    
    public Configuracion(String identificador, Object valor) {
        this.identificador = identificador;
        this.valor = valor;
    }
    
    public Configuracion(String identificador, String clase, String valor) throws ClassNotFoundException, ParseException {
        this.identificador = identificador;
        switch (Class.forName(clase).getSimpleName()) {
            case "Boolean":
                this.valor = Boolean.parseBoolean(valor);
                break;
            case "Integer":
                this.valor = Integer.parseInt(valor);
                break;
            case "Float":
                this.valor = Float.parseFloat(valor);
                break;
            case "Date":
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = df.parse(valor);
                this.valor = fecha;
                break;
            case "String":
                this.valor = valor;
                break;
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Configuracion other = (Configuracion) obj;
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "identificador=" + identificador + ", clase=" + valor.getClass().getName() + ", valor=" + valor + '}';
    }
    
    public static ListaConfiguracion cargarConfiguracion() {
        ListaConfiguracion configuraciones = new ListaConfiguracion();
        try {
            SAXBuilder constructor = new SAXBuilder();
            Document doc = constructor.build("config/configuracion.xml");
            Element raiz = doc.getRootElement();
            if(raiz.getName().equals("configuracion")) {

                List configs = raiz.getChildren();
                Iterator itConfigs = configs.iterator();
                while(itConfigs.hasNext()) {
                    Element eConfig = (Element) itConfigs.next();
                    
                    String identificador = eConfig.getChildText("identificador");
                    String clase = eConfig.getChildText("clase");
                    String valor = eConfig.getChildText("valor");
                    
                    configuraciones.add(new Configuracion(identificador,clase,valor));
                }
            }
        } catch(ParseException | ClassNotFoundException | JDOMException | IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        
        return configuraciones;
    }
    
    public static void grabarConfiguracion(ListaConfiguracion configuraciones) {
        boolean valido = false;
        Element root = new Element("configuracion");
        Iterator itConfigs = configuraciones.iterator();
        while(itConfigs.hasNext()) {
            root.addContent(new Variable((Configuracion) itConfigs.next()));
        }

        //Creamos el DocType que almacena el DTD para incluirlo en el XML
        DocType dt = new DocType("departamentos","dtd/configuracion.dtd");

        //Creamos el documento almacenando todo el arbol y el doctype
        Document doc = new Document(root,dt);

        //Lo almacenamos en un fichero dado por argumento
        try {
            XMLOutputter salidaXml = new XMLOutputter(Format.getPrettyFormat());
            try (FileOutputStream archivo = new FileOutputStream("config/configuracion.xml")) {
                salidaXml.output(doc, archivo);
                archivo.flush();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ListaConfiguracion configs = Configuracion.cargarConfiguracion();
        
        Configuracion nueva = new Configuracion("prueba lalala", "hola que tal");
        
        configs.add(nueva);
        Configuracion.grabarConfiguracion(configs);
        
        ListaConfiguracion configsNuevas = Configuracion.cargarConfiguracion();
        Iterator itConfigs = configsNuevas.iterator();
        while(itConfigs.hasNext()) {
            System.out.println(itConfigs.next().toString());
        }
    }
}
