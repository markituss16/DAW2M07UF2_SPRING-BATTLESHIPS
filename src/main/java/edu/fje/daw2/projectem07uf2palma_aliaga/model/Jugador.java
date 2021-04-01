package edu.fje.daw.projectem07uf2aliagapalma.model;

import javax.persistence.*;

@Entity
public class Jugador {
    @Id String usuario;
    private String contraseña;
    private String puntuacio;

}
