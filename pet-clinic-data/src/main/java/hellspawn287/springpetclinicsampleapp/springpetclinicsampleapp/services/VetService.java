package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services;


import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
