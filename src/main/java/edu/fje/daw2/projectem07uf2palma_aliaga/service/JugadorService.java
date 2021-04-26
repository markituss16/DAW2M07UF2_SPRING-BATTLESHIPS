package edu.fje.daw2.projectem07uf2palma_aliaga.service;

import edu.fje.daw2.projectem07uf2palma_aliaga.model.Jugador;
import edu.fje.daw2.projectem07uf2palma_aliaga.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class JugadorService {
    private  JugadorRepository ju;

    //llistar jugadors
    public List<Jugador> findAll() {
        var it = ju.findAll();
        var Jugadors = new ArrayList<Jugador>();
        it.forEach(e -> Jugadors.add(e));
        return Jugadors;
    }
    //eliminar jugador
    public void deleteById(Long JugadorUsername) {
        ju.deleteById(JugadorUsername);
    }

    //afegir jugadors
    public void afegirJugador(String username, String contrasena){
        var p1 = new Jugador(username, contrasena);
        ju.save(p1);
    }
    

}
