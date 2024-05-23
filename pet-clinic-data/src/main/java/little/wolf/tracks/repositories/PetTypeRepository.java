package little.wolf.tracks.repositories;

import little.wolf.tracks.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
