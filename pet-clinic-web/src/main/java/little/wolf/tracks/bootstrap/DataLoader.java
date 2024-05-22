package little.wolf.tracks.bootstrap;

import little.wolf.tracks.model.Owner;
import little.wolf.tracks.model.Pet;
import little.wolf.tracks.model.PetType;
import little.wolf.tracks.model.Vet;
import little.wolf.tracks.services.OwnerService;
import little.wolf.tracks.services.PetTypeService;
import little.wolf.tracks.services.VetService;
import little.wolf.tracks.services.map.OwnerServiceMap;
import little.wolf.tracks.services.map.VetServiceMap;
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
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setAddress("123 Main Street");
        owner1.setCity("Miami");
        owner1.setTelephone("1569875353");

        Pet johnsPet = new Pet();
        johnsPet.setPetType(savedDogPetType);
        johnsPet.setOwner(owner1);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setName("Luigi");
        owner1.getPets().add(johnsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jane");
        owner2.setLastName("Doe");
        owner2.setAddress("123 Main Street");
        owner2.setCity("Miami");
        owner2.setTelephone("1569875220");

        Pet JanesPet = new Pet();
        JanesPet.setPetType(savedCatPetType);
        JanesPet.setOwner(owner2);
        JanesPet.setBirthDate(LocalDate.now());
        JanesPet.setName("Buttercup");
        owner2.getPets().add(JanesPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Friddy");
        vet1.setLastName("Shrimp");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alli");
        vet2.setLastName("Gator");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
