package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.bootstrap;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Owner;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Vet;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.OwnerService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michał");
        owner1.setLastName("Kulus");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Kasia");
        owner2.setLastName("Kulus");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.... \n . . .  .  .");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Piotr");
        vet1.setLastName("Wujda");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ewelina");
        vet2.setLastName("Wujda");

        vetService.save(vet2);
        System.out.println("Loaded Vets.... \n . . .  .  .");
    }
}
