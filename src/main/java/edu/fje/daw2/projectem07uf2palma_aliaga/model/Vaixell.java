package edu.fje.daw.projectem07uf2aliagapalma.model;

import java.io.Serializable;

public class Vaixell implements Serializable {
    private String tipus;
    private int vida;
    private int mida;

    public Vaixell(){}

    public Vaixell (String tipus, int vida) {
        this.tipus = tipus;
        this.vida = vida;
    }
}
