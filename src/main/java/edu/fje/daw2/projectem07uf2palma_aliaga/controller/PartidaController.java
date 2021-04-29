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

    @RequestMapping(value="/crearPartida", method = RequestMethod.POST)
    String crearPartida(@SessionAttribute("partides") List<Partida> partides,
                            @RequestParam(defaultValue = "") int codiPartida,
                            @RequestParam(defaultValue = "") String nomJugador1,
                            ModelMap model) {
        Partida p = new Partida(codiPartida,nomJugador1);
        repositori.save(p);

        if(!model.containsAttribute("partides")) {
            model.addAttribute("partides", partides);
        }
        partides.add(p);

        return("llistaPartides"); //añadir nuevo archivo
    }

   /* @RequestMapping(value="/esborrarPartida", method = RequestMethod.GET)
    String esborrarPartida(@SessionAttribute("partides") List<Partida> partides,
                          @RequestParam (defaultValue = "") int codiPartida){
        System.out.println(codiPartida);
        repositori.deleteById(id);
        Partida pa = new Partida(id);
        pa.setId(id);
        partides.remove(pa);

        return("llistaPartides");
    }*/
}
