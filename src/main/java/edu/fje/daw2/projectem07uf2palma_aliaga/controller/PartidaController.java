package edu.fje.daw2.projectem07uf2palma_aliaga.controller;

import edu.fje.daw2.projectem07uf2palma_aliaga.repository.PartidaRepositori;
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
    private PartidaRepositori repositoriPartida;

    @RequestMapping(value="/crearPartida", method = RequestMethod.POST)
    String crearPartida(@RequestParam(defaultValue = "") int codiPartida,
                            @RequestParam(defaultValue = "") String nomJugador1,
                            ModelMap model) {
        Partida p = new Partida(codiPartida,codiPartida,nomJugador1);
        repositoriPartida.save(p);

        model.addAttribute("codiPartida", codiPartida);
        model.addAttribute("nomJugador", nomJugador1);

        return("accesPartida"); //añadir nuevo archivo
    }

    @RequestMapping(value="/unirPartida", method = RequestMethod.POST)
    public String accesPartida(@RequestParam int codiPartida,
                               @RequestParam String nomJugador2,
                               Model model){

        var resultat=repositoriPartida.findByCodiPartida(codiPartida);


        if(resultat.getNomJugador1().equals("")) return "inicio";
        else{
            Partida partidatemp=new Partida(resultat.get_id(),resultat.getCodiPartida(),resultat.getNomJugador1(),resultat.getNomJugador2(),resultat.getPosicionsJ1(),
                    resultat.getPosicionsJ2(),resultat.getPosicionsAcertadesJ1(),resultat.getPosicionsAcertadesJ2(),resultat.getPosicionsErrorsJ1(),
                    resultat.getPosicionsErrorsJ2(),resultat.isAcabada());
            partidatemp.setNomJugador2(nomJugador2);

            repositoriPartida.save(partidatemp);

            model.addAttribute("codiPartida", codiPartida);
            model.addAttribute("nomJugador", nomJugador2);
            return "accesPartida";
        }

    }

    @RequestMapping(value="/posarPosicions", method = RequestMethod.POST)
    public String posarPosicions(@RequestParam int codiPartida,
                                 @RequestParam String nomJugador2,
                                 @RequestParam String b1p1,
                                 @RequestParam String b2p1,
                                 @RequestParam String b2p2,
                                 @RequestParam String b3p1,
                                 @RequestParam String b3p2,
                                 @RequestParam String b3p3,
                                 @RequestParam String b4p1,
                                 @RequestParam String b4p2,
                                 @RequestParam String b4p3,
                                 @RequestParam String b4p4,
                                 @RequestParam String b5p1,
                                 @RequestParam String b5p2,
                                 @RequestParam String b5p3,
                                 @RequestParam String b5p4,
                                 @RequestParam String b5p5,
                                 Model model) {

        var resultat = repositoriPartida.findByCodiPartida(codiPartida);


        if (resultat.getNomJugador1().equals("")) return "inicio";
        else {
            Partida partidatemp = new Partida(resultat.get_id(), resultat.getCodiPartida(), resultat.getNomJugador1(), resultat.getNomJugador2(), resultat.getPosicionsJ1(),
                    resultat.getPosicionsJ2(), resultat.getPosicionsAcertadesJ1(), resultat.getPosicionsAcertadesJ2(), resultat.getPosicionsErrorsJ1(),
                    resultat.getPosicionsErrorsJ2(), resultat.isAcabada());

            List<String> list1= new ArrayList<>();
            list1.add(b1p1);
            list1.add(b2p1);
            list1.add(b2p2);
            list1.add(b3p1);
            list1.add(b3p2);
            list1.add(b3p3);
            list1.add(b4p1);
            list1.add(b4p2);
            list1.add(b4p3);
            list1.add(b4p4);
            list1.add(b5p1);
            list1.add(b5p2);
            list1.add(b5p3);
            list1.add(b5p4);
            list1.add(b5p5);

            if(partidatemp.getPosicionsJ1().size()==0) resultat.setPosicionsJ1(list1);
            else resultat.setPosicionsJ2(list1);
            repositoriPartida.save(partidatemp);

            model.addAttribute("lerrors", resultat.getPosicionsErrorsJ1());
            model.addAttribute("lacerts", resultat.getPosicionsAcertadesJ1());
            model.addAttribute("nomJugador", resultat.getPosicionsAcertadesJ1());

            return "partida";
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
