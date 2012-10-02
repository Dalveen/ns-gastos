/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Rodrigo Núñez Mujica
 */
public class Usuario extends Entidad {
    private String nombre;
    private String apellidos;
    private String email;
    private String auth;
    private boolean validado;

    public Usuario(String email, String auth) {
        this.email = email;
        this.auth = auth;
        this.validado = false;
    }

    public Usuario(String nombre, String apellidos, String email, String auth, boolean validado, boolean activo) {
        super(activo);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.auth = auth;
        this.validado = validado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Nombre", this.nombre, nombre);
        this.modificaciones.add(modificacion);
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Apellidos", this.apellidos, apellidos);
        this.modificaciones.add(modificacion);
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Email", this.email, email);
        this.modificaciones.add(modificacion);
        this.email = email;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Auth", this.auth, auth);
        this.modificaciones.add(modificacion);
        this.auth = auth;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        ModificacionEntidad modificacion = new ModificacionEntidad(this, new Date(), "Validado", Boolean.toString(this.validado), Boolean.toString(validado));
        this.modificaciones.add(modificacion);
        this.validado = validado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Usuario other = (Usuario) obj;
        if(Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "uuid="+ uuid +", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", auth=" + auth + ", validado=" + validado + '}';
    }
    
    public static void main(String args[]) {
        Usuario user = new Usuario("Nombre", "Apes", "email@email.com", "asdf", true, true);
        
        System.out.println(user.toString());
        user.setApellidos("Apes nuevos");
        user.setActivo(false);
        user.setEmail("test@test.com");
        user.cargarCamposAdicionales();

        
        Iterator itCampos = user.getCamposAdicionales().iterator();
        
        while(itCampos.hasNext()) {
            System.out.println(itCampos.next().toString());
        }
    }
    
}
