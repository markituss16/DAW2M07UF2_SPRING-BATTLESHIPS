package edu.fje.daw.projectem07uf2aliagapalma.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;

public class Partida implements Serializable {
    @Id
    private int id;
    private String jugador1;
    private String jugador2;
    private List<Integer> taulellJ1 = new ArrayList<>();
    private List<Integer> taulellJ2 = new ArrayList<>();
    private List<Vaixell> vaixellsJ1 = new ArrayList<>();
    private List<Vaixell> vaixellsJ2 = new ArrayList<>();
    private List<Vaixell> vaixellsEliminatsJ1 = new ArrayList<>();
    private List<Vaixell> vaixellsEliminatsJ2 = new ArrayList<>();
    private boolean acabada;

    public Partida() {}


}
