package little.wolf.tracks.repositories;

import little.wolf.tracks.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
