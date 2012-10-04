/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Configuracion;
import config.ListaConfiguracion;
import db.Mysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    protected ListaModificacionEntidad modificaciones;
    protected ListaCampoEntidad camposAdicionales;

    public Entidad(boolean activo) {
        this.uuid = UUID.randomUUID();
        this.activo = activo;
        this.borrado = false;
        this.fechaDeCreacion = new Date();
        this.modificaciones = new ListaModificacionEntidad(this);
        this.camposAdicionales = new ListaCampoEntidad(this);
    }
    
    public Entidad() {
        this.uuid = UUID.randomUUID();
        this.activo = true;
        this.borrado = false;
        this.fechaDeCreacion = new Date();
        this.modificaciones = new ListaModificacionEntidad(this);
        this.camposAdicionales = new ListaCampoEntidad(this);
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

    public ListaModificacionEntidad getModificaciones() {
        return modificaciones;
    }

    public ListaCampoEntidad getCamposAdicionales() {
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
    
    protected void cargarCamposAdicionales() {
        ListaCampoEntidad campos = new ListaCampoEntidad(this);
        String clase = this.getClass().getName();
        ListaConfiguracion configuraciones = Configuracion.cargarConfiguracion("mysql.xml");
        Mysql conexion = new Mysql(
                (String) configuraciones.getPorIdentificador("mysql_server").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_port").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_db").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_user").getValor(),
                (String) configuraciones.getPorIdentificador("mysql_password").getValor()
                );
        try {     
            conexion.openConnection();
            PreparedStatement ps = conexion.getConnection().prepareStatement("SELECT * FROM estructura_campo_entidad ece WHERE ece.claseTipo = ?");
            ps.setString(1, this.getClass().getName());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                CampoEntidad campo = new CampoEntidad(this, rs.getString("identificador"), rs.getBoolean("requerido"));
                campos.add(campo);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }               
        this.camposAdicionales = campos;
    }
}
