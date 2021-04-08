package edu.fje.daw2.projectem07uf2palma_aliaga;

import edu.fje.daw2.projectem07uf2palma_aliaga.model.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidaRepositori extends MongoRepository<Partida, String> {
}
