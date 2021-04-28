package edu.fje.daw2.projectem07uf2palma_aliaga.controller;

import edu.fje.daw2.projectem07uf2palma_aliaga.controller.JugadorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.fje.daw2.projectem07uf2palma_aliaga.model.Jugador;
import edu.fje.daw2.projectem07uf2palma_aliaga.repository.JugadorRepository;
import edu.fje.daw2.projectem07uf2palma_aliaga.service.JugadorService;

import java.util.HashSet;
import java.util.Set;
@Controller
public class JugadorController {
    Set<Jugador> jugadors = new HashSet<>();

    @Autowired
    private JugadorService serveijugador;

    @PostMapping("/afegirJugador")
    public void afegirJugador(@RequestParam String usuario,
                               @RequestParam String contrasena,
                               Model model){
        System.out.println("hollla");

        serveijugador.afegirJugador(usuario,contrasena);
    }

    @PostMapping("/loginJugador")
    public String loginJugador(@RequestParam String usuario,
                              @RequestParam String contrasena,
                              Model model){
        System.out.println("hollla");

        var resultat=serveijugador.loginJugador(usuario,contrasena);
        if(resultat.equals("0")) return "index";
        else{
            model.addAttribute("nomJugador", resultat);
            return "inicio";
        }

    }
}