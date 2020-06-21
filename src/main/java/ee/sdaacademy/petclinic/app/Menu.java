package ee.sdaacademy.petclinic.app;

import ee.sdaacademy.petclinic.repositories.ConsultantRepository;
import ee.sdaacademy.petclinic.repositories.OwnerRepository;
import ee.sdaacademy.petclinic.repositories.PetRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static String[] owners = new String[10];
    static String[] pets = new String[10];

    public static void menuOptions() {
        System.out.println("Choose suitable option for you: ");

        displayMenu();

        int option = getOption();

        do {
            switch (option) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    ConsultantRepository.consultation();
                    break;
                case 3:
                    OwnerRepository.ownerRegistration();
                    break;
                case 4:
                    PetRepository.petRegistration();
                    break;
                case 5:
                    removeOwner();
                    break;
                case 6:
                    removePet();
                    break;
                case 7:
                    displayAllPetTypes();
                    break;
                case 8:
                    displayAllOwners();
                    break;
                case 9:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("There is no such an option!");
            }
        }while (true);
    }

    static void displayMenu() {
        do {
            System.out.println("______________________________\n-Menu-\n");
            System.out.println();
            System.out.println("1 - Display menu");
            System.out.println("2 - Consultation");
            System.out.println("3 - Owner registration");
            System.out.println("4 - Pet registration");
            System.out.println("5 - Remove owner");
            System.out.println("6 - Remove pet");
            System.out.println("7 - Display all pet types");
            System.out.println("8 - Display all owners");
            System.out.println("9 - Exit");
        }while (getOption() != 9);

    }

    static void removeOwner() {
        System.out.print("Name: ");
        String name = scanner.next();
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null && owners[i].equals(name)) {
                owners[i] = null;
                break;
            }
        }
    }

    static void removePet() {
        System.out.print("Name: ");
        String name = scanner.next();
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null && pets[i].equals(name)) {
                pets[i] = null;
                break;
            }
        }
    }

    static void displayAllPetTypes(){
        System.out.println("______________________________\n-Owners-\n");
        boolean isEmpty = true;
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null) {
                System.out.println((i + 1) + ". " + pets[i]);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("List is empty.");
        }


        String[] temp = new String[pets.length];
        int ti = 0;
        for (int i = 0; i < owners.length; i++) {
            if (pets[i] != null) {
                temp[ti] = pets[i];
                ti++;
            }
        }
        pets = temp;
    }

    static void displayAllOwners() {
        System.out.println("______________________________\n-Owners-\n");
        boolean isEmpty = true;
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null) {
                System.out.println((i + 1) + ". " + owners[i]);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("List is empty.");
        }


        String[] temp = new String[owners.length];
        int ti = 0;
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null) {
                temp[ti] = owners[i];
                ti++;
            }
        }
        owners = temp;
    }

    static int getOption() {
        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }
}
