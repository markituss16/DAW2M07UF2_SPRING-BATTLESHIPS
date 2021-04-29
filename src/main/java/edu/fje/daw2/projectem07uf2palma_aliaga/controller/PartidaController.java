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
                                 @RequestParam String nomJugador,
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
            System.out.println(list1);
            if(partidatemp.getPosicionsJ1().size()==0) partidatemp.setPosicionsJ1(list1);
            else partidatemp.setPosicionsJ2(list1);
            repositoriPartida.save(partidatemp);

            model.addAttribute("lerrors", partidatemp.getPosicionsErrorsJ1());
            model.addAttribute("lacerts", partidatemp.getPosicionsAcertadesJ1());
            model.addAttribute("nomJugador", nomJugador);
            model.addAttribute("codiPartida", codiPartida);
            return "partida";
        }
    }


    @RequestMapping(value="/polsarPosicio", method = RequestMethod.POST)
    public String polsarPosicio(@RequestParam int codiPartida,
                               @RequestParam String nomJugador,
                                @RequestParam String posicio,
                               Model model){

        var resultat=repositoriPartida.findByCodiPartida(codiPartida);


        if(resultat.getNomJugador1().equals("")) return "inicio";
        else{
            Partida partidatemp=new Partida(resultat.get_id(),resultat.getCodiPartida(),resultat.getNomJugador1(),resultat.getNomJugador2(),resultat.getPosicionsJ1(),
                    resultat.getPosicionsJ2(),resultat.getPosicionsAcertadesJ1(),resultat.getPosicionsAcertadesJ2(),resultat.getPosicionsErrorsJ1(),
                    resultat.getPosicionsErrorsJ2(),resultat.isAcabada());

            if(partidatemp.getNomJugador1().equals(nomJugador)){
                if(partidatemp.getPosicionsJ2().size()==0){
                    repositoriPartida.delete(partidatemp);
                    return "/";
                }
                int trobat=0;
                List <String> listtemp=partidatemp.getPosicionsAcertadesJ1();
                List <String> listtempe=partidatemp.getPosicionsErrorsJ1();
                for(String posicio2 : partidatemp.getPosicionsJ2()) {

                    if(posicio2.equals(posicio)){
                        System.out.println();
                        trobat=1;
                        listtemp.add(posicio);

                        partidatemp.setPosicionsAcertadesJ1(listtemp);
                        posicio2=null;}
                };
                if(trobat==0){
                    listtempe.add(posicio);
                    partidatemp.setPosicionsErrorsJ1(listtempe);
                }else{
                    int in=partidatemp.getPosicionsJ2().indexOf(posicio);
                    List ltreu=partidatemp.getPosicionsJ2();
                    System.out.println(in);
                    ltreu.remove(in);
                    partidatemp.setPosicionsJ2(ltreu);
                }
                model.addAttribute("lerrors", partidatemp.getPosicionsErrorsJ1());
                model.addAttribute("lacerts", partidatemp.getPosicionsAcertadesJ1());
            }else{
                if(partidatemp.getPosicionsJ1().size()==0){
                    repositoriPartida.delete(partidatemp);
                    return "/";
                }
                int trobat=0;
                List <String> listtemp=partidatemp.getPosicionsAcertadesJ2();
                List <String> listtempe=partidatemp.getPosicionsErrorsJ2();
                for(String posicio1 : partidatemp.getPosicionsJ1()) {

                    if(posicio1.equals(posicio)){
                        trobat=1;
                        listtemp.add(posicio);
                        partidatemp.setPosicionsAcertadesJ2(listtemp);
                        posicio1=null;}
                };
                if(trobat==0){
                    listtempe.add(posicio);
                    partidatemp.setPosicionsErrorsJ2(listtempe);
                }else {
                    int in=partidatemp.getPosicionsJ1().indexOf(posicio);
                    List ltreu=partidatemp.getPosicionsJ1();
                    System.out.println(in);
                    ltreu.remove(in);
                    partidatemp.setPosicionsJ1(ltreu);
                }
                trobat=0;
                model.addAttribute("lerrors", partidatemp.getPosicionsErrorsJ2());
                model.addAttribute("lacerts", partidatemp.getPosicionsAcertadesJ2());
            };

            repositoriPartida.save(partidatemp);

            model.addAttribute("codiPartida", codiPartida);
            model.addAttribute("nomJugador", nomJugador);

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
