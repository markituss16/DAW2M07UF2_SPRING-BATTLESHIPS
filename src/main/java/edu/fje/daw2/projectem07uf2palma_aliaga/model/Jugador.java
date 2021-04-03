package edu.fje.daw2.projectem07uf2palma_aliaga.model;

import javax.persistence.*;

@Entity
public class Jugador {
    @Id String usuario;
    private String contraseña;
    private String puntuacio;

}
