package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.repositories;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
