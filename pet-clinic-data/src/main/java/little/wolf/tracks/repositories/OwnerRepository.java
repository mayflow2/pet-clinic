package little.wolf.tracks.repositories;

import little.wolf.tracks.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
