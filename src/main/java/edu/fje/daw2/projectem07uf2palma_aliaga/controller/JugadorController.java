package edu.fje.daw2.projectem07uf2palma_aliaga.controller;

import
        edu.fje.daw2.projectem07uf2palma_aliaga.controller.JugadorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.fje.daw2.projectem07uf2palma_aliaga.model.Jugador;
import edu.fje.daw2.projectem07uf2palma_aliaga.repository.JugadorRepository;

import java.util.HashSet;
import java.util.Set;

public class JugadorController {
    Set<Jugador> jugadors = new HashSet<>();

    @PostMapping("/afegirJugador")
    public String afegirAlumne(@RequestParam String usuario,
                               @RequestParam String contrasena,
                               Model model){
        return "hola";
    }
}