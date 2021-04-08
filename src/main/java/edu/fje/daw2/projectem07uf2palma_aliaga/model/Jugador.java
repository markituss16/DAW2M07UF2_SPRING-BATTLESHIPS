package edu.fje.daw2.projectem07uf2palma_aliaga.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Jugador implements Serializable {
    @Column(length = 25)
    @Id String usuario;
    @Column(length = 25)
    private String contrasena;
    private int puntuacio=0;

    //constructor
    public Jugador() {}
    public Jugador(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //getters i setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
    
}
