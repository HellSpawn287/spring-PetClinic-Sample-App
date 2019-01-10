package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.repositories;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
