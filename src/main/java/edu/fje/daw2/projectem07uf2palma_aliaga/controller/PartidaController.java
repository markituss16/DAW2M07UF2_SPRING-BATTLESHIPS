package edu.fje.daw2.projectem07uf2palma_aliaga.controller;

import edu.fje.daw2.projectem07uf2palma_aliaga.repository.PartidaRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import edu.fje.daw2.projectem07uf2palma_aliaga.model.Partida;

@Controller
@SessionAttributes("partides")
public class PartidaController {
    @Autowired
    private PartidaRepositori repositoriPartida;

    @RequestMapping(value="/crearPartida", method = RequestMethod.POST)
    String crearPartida(@RequestParam(defaultValue = "") int codiPartida,
                            @RequestParam(defaultValue = "") String nomJugador1,
                            ModelMap model) {
        Partida p = new Partida(codiPartida,nomJugador1);
        repositoriPartida.save(p);

        model.addAttribute("codiPartida", codiPartida);
        model.addAttribute("nomJugador1", nomJugador1);

        return("llistaPartides"); //añadir nuevo archivo
    }

    @RequestMapping(value="/accesPartida", method = RequestMethod.POST)
    public String accesPartida(@RequestParam int codiPartida,
                               @RequestParam String nomJugador1,
                               Model model){

        var resultat=repositoriPartida.findByCodiPartida(codiPartida);
        if(resultat.equals("")) return "inicio";
        else{
            model.addAttribute("codiPartida", resultat);
            model.addAttribute("nomJugador1", nomJugador1);
            return "accesPartida";
        }

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
