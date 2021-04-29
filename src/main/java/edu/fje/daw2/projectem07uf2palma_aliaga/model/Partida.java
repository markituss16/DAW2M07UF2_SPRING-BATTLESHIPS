package edu.fje.daw2.projectem07uf2palma_aliaga.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "partida")
public class Partida implements Serializable {
    private int codiPartida;
    private String nomJugador1;
    private String nomJugador2;
    private List<String> posicionsJ1 = new ArrayList<>();
    private List<String> posicionsJ2 = new ArrayList<>();
    private List<String> posicionsAcertadesJ1 = new ArrayList<>();
    private List<String> posicionsAcertadesJ2 = new ArrayList<>();
    private List<String> posicionsErrorsJ1 = new ArrayList<>();
    private List<String> posicionsErrorsJ2 = new ArrayList<>();
    private boolean acabada;

    public Partida(int codiPartida, String nomJugador1) {
        this.codiPartida = codiPartida;
        this.nomJugador1 = nomJugador1;
    }

    public int getCodiPartida() {
        return codiPartida;
    }

    public void setCodiPartida(int codiPartida) {
        this.codiPartida = codiPartida;
    }

    public String getNomJugador1() {
        return nomJugador1;
    }

    public void setNomJugador1(String nomJugador1) {
        this.nomJugador1 = nomJugador1;
    }

    public String getNomJugador2() {
        return nomJugador2;
    }

    public void setNomJugador2(String nomJugador2) {
        this.nomJugador2 = nomJugador2;
    }

    public List<String> getPosicionsJ1() {
        return posicionsJ1;
    }

    public void setPosicionsJ1(List<String> posicionsJ1) {
        this.posicionsJ1 = posicionsJ1;
    }

    public List<String> getPosicionsJ2() {
        return posicionsJ2;
    }

    public void setPosicionsJ2(List<String> posicionsJ2) {
        this.posicionsJ2 = posicionsJ2;
    }

    public List<String> getPosicionsAcertadesJ1() {
        return posicionsAcertadesJ1;
    }

    public void setPosicionsAcertadesJ1(List<String> posicionsAcertadesJ1) {
        this.posicionsAcertadesJ1 = posicionsAcertadesJ1;
    }

    public List<String> getPosicionsAcertadesJ2() {
        return posicionsAcertadesJ2;
    }

    public void setPosicionsAcertadesJ2(List<String> posicionsAcertadesJ2) {
        this.posicionsAcertadesJ2 = posicionsAcertadesJ2;
    }

    public List<String> getPosicionsErrorsJ1() {
        return posicionsErrorsJ1;
    }

    public void setPosicionsErrorsJ1(List<String> posicionsErrorsJ1) {
        this.posicionsErrorsJ1 = posicionsErrorsJ1;
    }

    public List<String> getPosicionsErrorsJ2() {
        return posicionsErrorsJ2;
    }

    public void setPosicionsErrorsJ2(List<String> posicionsErrorsJ2) {
        this.posicionsErrorsJ2 = posicionsErrorsJ2;
    }

    public boolean isAcabada() {
        return acabada;
    }

    public void setAcabada(boolean acabada) {
        this.acabada = acabada;
    }
}
