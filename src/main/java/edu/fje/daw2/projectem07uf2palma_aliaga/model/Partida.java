package edu.fje.daw2.projectem07uf2palma_aliaga.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;

@Document(collection = "partida")
public class Partida implements Serializable {
    @Id
    private String id;
    private String jugador1;
    private String jugador2;
    private List<Integer> taulellJ1 = new ArrayList<>();
    private List<Integer> taulellJ2 = new ArrayList<>();
    private List<Vaixell> vaixellsJ1 = new ArrayList<>();
    private List<Vaixell> vaixellsJ2 = new ArrayList<>();
    private List<Vaixell> vaixellsEliminatsJ1 = new ArrayList<>();
    private List<Vaixell> vaixellsEliminatsJ2 = new ArrayList<>();
    private boolean acabada;

    public Partida(String id) {}

    public Partida(String id, String jugador1, String jugador2) {
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
}
