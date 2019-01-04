package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.bootstrap;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Owner;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Pet;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.PetType;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.Vet;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.OwnerService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.PetTypeService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michał");
        owner1.setLastName("Kulus");
        owner1.setAddress("Pomorska 2");
        owner1.setCity("Wrocław");
        owner1.setTelephone("509621");

        Pet michalsPet = new Pet();
        michalsPet.setPetType(savedDogPetType);
        michalsPet.setOwner(owner1);
        michalsPet.setBirthDate(LocalDate.now());
        michalsPet.setName("Bruno");
        owner1.getPets().add(michalsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kasia");
        owner2.setLastName("Kulus");
        owner2.setAddress("Pomorska 2");
        owner2.setCity("Wrocław");
        owner2.setTelephone("6098787");

        Pet katesPet = new Pet();
        katesPet.setPetType(savedCatPetType);
        katesPet.setOwner(owner2);
        katesPet.setBirthDate(LocalDate.now());
        katesPet.setName("Fiona");
        owner2.getPets().add(katesPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.... \n . . .  .  .");

        Vet vet1 = new Vet();
        vet1.setFirstName("Piotr");
        vet1.setLastName("Wujda");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ewelina");
        vet2.setLastName("Wujda");

        vetService.save(vet2);
        System.out.println("Loaded Vets.... \n . . .  .  .");
    }
}
