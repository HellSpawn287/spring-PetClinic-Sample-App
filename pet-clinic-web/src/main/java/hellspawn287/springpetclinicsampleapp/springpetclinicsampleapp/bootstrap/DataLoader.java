package hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.bootstrap;

import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.model.*;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.OwnerService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.PetTypeService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.SpecialtyService;
import hellspawn287.springpetclinicsampleapp.springpetclinicsampleapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        while (count == 0) {
            loadData();
            break;
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ewelina");
        vet2.setLastName("Wujda");
        vet2.getSpecialties().add(savedSurgery);

        Vet vet3 = new Vet();
        vet3.setFirstName("Justyna");
        vet3.setLastName("Lak");
        vet3.getSpecialties().add(savedRadiology);

        vetService.save(vet2);
        System.out.println("Loaded Vets.... \n . . .  .  .");
    }
}
