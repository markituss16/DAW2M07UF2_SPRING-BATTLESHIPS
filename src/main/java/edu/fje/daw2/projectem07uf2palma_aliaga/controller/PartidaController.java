package edu.fje.daw2.projectem07uf2palma_aliaga.controller;

import edu.fje.daw2.projectem07uf2palma_aliaga.PartidaRepositori;
import edu.fje.daw2.projectem07uf2palma_aliaga.controller.JugadorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import edu.fje.daw2.projectem07uf2palma_aliaga.model.Partida;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("partides")
public class PartidaController {
    @Autowired
    private PartidaRepositori repositori;

    @ModelAttribute("partides")
    public List<Partida> mostrarPartides() {
        List<Partida> partides = new ArrayList<>();
        for (Partida p : repositori.findAll()) {
            partides.add(p);
        }
        return partides;
    }

    @RequestMapping(value="/desarPartida", method = RequestMethod.POST)
    String desarPartida(@SessionAttribute("partides") List<Partida> partides,
                            @RequestParam(defaultValue = "") String id,
                            @RequestParam(defaultValue = "") String jugador1,
                            @RequestParam(defaultValue = "") String jugador2,
                            ModelMap model) {
        Partida p = new Partida(id,jugador1,jugador2);
        repositori.save(p);

        if(!model.containsAttribute("partides")) {
            model.addAttribute("partides", partides);
        }
        partides.add(p);

        return("llistaPartides");
    }

    @RequestMapping(value="/esborrarPartida", method = RequestMethod.GET)
    String esborrarPartida(@SessionAttribute("partides") List<Partida> partides,
                          @RequestParam (defaultValue = "") String id){
        System.out.println(id);
        repositori.deleteById(id);
        Partida pa = new Partida(id);
        pa.setId(id);
        partides.remove(pa);

        return("llistaPartides");
    }
}
