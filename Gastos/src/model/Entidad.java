/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public abstract class Entidad {
    protected UUID uuid;
    protected boolean activo;
    protected boolean borrado;
    protected Date fechaDeCreacion;
    protected List<ModificacionEntidad> modificaciones;
    protected List<CampoEntidad> camposAdicionales;

    public Entidad(boolean activo) {
        this.uuid = UUID.randomUUID();
        this.activo = activo;
        this.borrado = false;
        this.fechaDeCreacion = new Date();
        this.modificaciones = new ArrayList<>();
        this.camposAdicionales = new ArrayList<>();
    }
    
    public Entidad() {
        this.uuid = UUID.randomUUID();
        this.activo = true;
        this.borrado = false;
        this.fechaDeCreacion = new Date();
        this.modificaciones = new ArrayList<>();
        this.camposAdicionales = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        if(this.uuid == null) {
            ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "UUID", null, uuid.toString());
            this.modificaciones.add(modificacion);
            this.uuid = uuid;
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        if(this.activo != activo) {
            ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Activo", Boolean.toString(this.activo), Boolean.toString(activo));
            this.modificaciones.add(modificacion);
        }
        this.activo = activo;        
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        if(this.borrado != borrado) {
            ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Borrado", Boolean.toString(this.borrado), Boolean.toString(borrado));
            this.modificaciones.add(modificacion);
        }
        this.borrado = borrado;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    
    public void insertarModificacion(String propiedad, String valorActual, String valorNuevo) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), propiedad, valorActual, valorNuevo);
        this.modificaciones.add(modificacion);
    }
    
    public void insertarModificacion(ModificacionEntidad modificacion) {
        this.modificaciones.add(modificacion);
    }

    public List<ModificacionEntidad> getModificaciones() {
        return modificaciones;
    }

    public List<CampoEntidad> getCamposAdicionales() {
        return camposAdicionales;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.uuid);
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
        final Entidad other = (Entidad) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad{" + "uuid=" + uuid + ", activo=" + activo + ", borrado=" + borrado + ", fechaDeCreacion=" + fechaDeCreacion + '}';
    }
    
}
