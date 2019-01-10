package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.repositories;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
