package edu.fje.daw2.projectem07uf2palma_aliaga.repository;

import edu.fje.daw2.projectem07uf2palma_aliaga.model.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepositori extends MongoRepository<Partida, String> {
    Partida findByCodiPartida(int codiPartida);

}
