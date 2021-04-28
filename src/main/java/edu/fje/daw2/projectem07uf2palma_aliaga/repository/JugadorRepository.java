package edu.fje.daw2.projectem07uf2palma_aliaga.repository;


import java.util.List;

import edu.fje.daw2.projectem07uf2palma_aliaga.model.Jugador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Long>{
    Jugador findByUsuarioAndContrasena(String usuario,String contrasena);
}
