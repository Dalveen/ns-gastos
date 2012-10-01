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
public class ModificacionEntidad {
    private Entidad entidad;
    private Date fechaRegistro;
    private String propiedad;
    private String valorAnterior;
    private String valorNuevo;

    public ModificacionEntidad(Entidad entidad, Date fechaRegistro, String propiedad, String valorAnterior, String valorNuevo) {
        this.entidad = entidad;
        this.fechaRegistro = fechaRegistro;
        this.propiedad = propiedad;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
    }
    
    public ModificacionEntidad(ModificacionEntidad original, String propiedad, String valorAnterior, String valorNuevo) {
        this.entidad = original.getEntidad();
        this.fechaRegistro = original.getFechaRegistro();
        this.propiedad = propiedad;
        this.valorAnterior = valorAnterior;
        this.valorNuevo = valorNuevo;
    }                  

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        if(this.entidad == null) {
            this.entidad = entidad;
        }
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        if(this.fechaRegistro == null) {
            this.fechaRegistro = fechaRegistro;
        }
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        if(this.propiedad == null) {
            this.propiedad = propiedad;
        }
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        if(this.valorAnterior == null) {
            this.valorAnterior = valorAnterior;
        }
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        if(this.valorNuevo == null) {
            this.valorNuevo = valorNuevo;
        }
    }

    @Override
    public String toString() {
        return "ModificacionEntidad{" + "entidad=" + entidad.toString() + ", fechaRegistro=" + fechaRegistro + ", propiedad=" + propiedad + ", valorAnterior=" + valorAnterior + ", valorNuevo=" + valorNuevo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.entidad);
        hash = 41 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 41 * hash + Objects.hashCode(this.propiedad);
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
        final ModificacionEntidad other = (ModificacionEntidad) obj;
        if (!Objects.equals(this.entidad, other.entidad)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        if (!Objects.equals(this.propiedad, other.propiedad)) {
            return false;
        }
        return true;
    }
}