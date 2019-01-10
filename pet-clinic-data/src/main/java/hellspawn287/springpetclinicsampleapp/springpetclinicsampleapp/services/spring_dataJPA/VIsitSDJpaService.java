package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.spring_dataJPA;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Visit;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.repositories.VisitRepository;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("spring_dataJPA")
public class VIsitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VIsitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
