package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
