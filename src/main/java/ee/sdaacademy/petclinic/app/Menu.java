package ee.sdaacademy.petclinic.app;

import ee.sdaacademy.petclinic.models.Owner;
import ee.sdaacademy.petclinic.models.Pet;
import ee.sdaacademy.petclinic.repositories.ConsultantRepository;
import ee.sdaacademy.petclinic.repositories.OwnerRepository;
import ee.sdaacademy.petclinic.repositories.PetRepository;
import ee.sdaacademy.petclinic.scanner.ConsultationScanner;
import ee.sdaacademy.petclinic.scanner.OwnerScanner;
import ee.sdaacademy.petclinic.scanner.PetScanner;
import ee.sdaacademy.petclinic.scanner.PetTypeScanner;

<<<<<<< HEAD

=======
>>>>>>> c666ce9aa3f40279f8640ec97ef0c37d5a8513f8
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public Menu() {
        System.out.println("Choose suitable option for you: ");
        System.out.println("______________________________\n-Menu-\n");
        System.out.println();
        System.out.println("1 - Consultation");
        System.out.println("2 - Owner registration");
        System.out.println("3 - Pet registration");
        System.out.println("4 - Remove owner");
        System.out.println("5 - Remove pet");
        System.out.println("6 - Display all pet types");
        System.out.println("7 - Display all owners");
        System.out.println("8 - Exit");

        menuOptions();
    }

    private static void menuOptions() {
        switch (getOption()) {
            case 1:
<<<<<<< HEAD
                ConsultationScanner.consultation();
                break;
            case 2:
                OwnerScanner.ownerRegistration();
                break;
            case 3:
                PetScanner.petRegistration();
                break;
            case 4:
                removeOwner();
                break;
            case 5:
                removePet();
                break;
            case 6:
                PetTypeScanner.displayAllPetTypes();
                break;
            case 7:
                displayAllOwners();
                break;
            case 8:
                System.out.println("Exiting..");
                System.out.println("Thanks for using pet clinic service!");
                break;
=======
                ConsultantRepository.consultation();
                break;
            case 2:
                OwnerRepository.ownerRegistration();
                break;
            case 3:
                PetRepository.petRegistration();
                break;
            case 4:
                removeOwner();
                break;
            case 5:
                removePet();
                break;
            case 6:
                displayAllPetTypes();
                break;
            case 7:
                displayAllOwners();
                break;
            case 8:
                System.out.println("Exiting..");
                System.out.println("Thanks for using pet clinic service!");
                break;
>>>>>>> c666ce9aa3f40279f8640ec97ef0c37d5a8513f8
            default:
                System.out.println("There is no such an option! Please try again.");
                menuOptions();
        }
    }

    private static int getOption() {
        System.out.println("Option: ");
        return scanner.nextInt();
    }

    private static void removeOwner() {
        System.out.println("Enter Owner ID: ");
        int ownerId = scanner.nextInt();
        OwnerRepository ownerRepository = new OwnerRepository();

        if (ownerRepository.findById(ownerId) == null) {
            System.out.println("Owner " + ownerId + " not found! Try again.");
            removeOwner();
        } else {
            ownerRepository.deleteById(ownerId);
            System.out.println("Owner deleted successfully.");
        }
    }

    static void removePet() {
        System.out.println("Enter Pet ID: ");
        int petId = scanner.nextInt();
        PetRepository petRepository = new PetRepository();

        if (petRepository.findById(petId) == null) {
            System.out.println("Pet " + petId + " not found! Try again.");
            removePet();
        } else {
            petRepository.deleteById(petId);
            System.out.println("Pet deleted successfully.");
        }
    }

    private static void displayAllPetTypes() {
        System.out.println("______________________________\n-Pets-\n");
        PetRepository petRepository = new PetRepository();
        List<Pet> petList = petRepository.findAll();

        if (petList.isEmpty()) {
            System.out.println("No pets found!");
        } else {
            petList.forEach(pet -> System.out.println(pet.getPetId() + " " + pet.getName() + " " +
                    pet.getPetType() + " " + pet.getOwner().getFirstName().concat(" ").concat(pet.getOwner().getLastName())));
        }
    }

<<<<<<< HEAD
    public static void displayAllOwners() {
=======
    private static void displayAllOwners() {
>>>>>>> c666ce9aa3f40279f8640ec97ef0c37d5a8513f8
        System.out.println("______________________________\n-Owners-\n");
        OwnerRepository ownerRepository = new OwnerRepository();
        List<Owner> ownerList = ownerRepository.findAll();

        if (ownerList.isEmpty()) {
            System.out.println("No owners found!");
        } else {
            ownerList.forEach(owner -> System.out.println(owner.getOwnerId() + " " + owner.getFirstName() + " " +
                    owner.getLastName()));
        }
    }
}