package ee.sdaacademy.petclinic;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {

    static String[] owners = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Welcome to the Consultation room!");
        System.out.println("You are starting consultation");
        System.out.println("(1)  For consultation");
        System.out.println("(-1) Exit");
        System.out.print("Please input your choice: ");
        int choice = scanner.nextInt();
        if(choice == 1) {
            System.out.println("Please, start the consultation ");
        } else {
            System.out.println("Exit");
        }
        while(scanner.hasNext())
        {
            System.out.println("Consultation Ended ");
            break;
        }
        /*PetTypeRepository petTypeRepository = new PetTypeRepository();
        petTypeRepository.findAll().stream().forEach(petTypes -> {
            System.out.println(petTypes.getPetTypeId() + " " + petTypes.getName());
        });*/
        //AdminRepository adminRepository = new AdminRepository();
        //System.out.println(adminRepository.findById(2).getFirstName());


        //Admin admin = new Admin();
        /*admin.setFirstName("Eric");
        admin.setLastName("Bass");
        admin.setTelephoneNumber("890-678-909");
        admin.setEmail("eric@bass.com");
        adminRepository.save(admin);*/

        /*Admin admin1 = adminRepository.findById(3);
        admin1.setLastName("Jack");
        adminRepository.delete(admin1);*/


        //VetRepository vetRepository = new VetRepository();
        /*vetRepository.findAll().stream().forEach(vet -> {
            System.out.println(vet.getFirstName() + " " + vet.getLastName() + " " + vet.getTelephoneNumber()
             + " " + vet.getAddress() + " " + vet.getEmail());
        });*/

        //System.out.println(vetRepository.findById(2).getFirstName());

        /*AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.findAll().stream().forEach(appointment -> {
            System.out.println(appointment.getConsultant().getName());
        });*/

        /*OwnerRepository ownerRepository = new OwnerRepository();
        ownerRepository.findAll().stream().forEach(owner -> {
            System.out.println(owner.getFirstName() + " " + owner.getLastName() + " " + owner.getAddress());});*/


        /*ownerRepository.findAllAlphabetically().stream().forEach(owner1 -> {
            System.out.println(owner1.getFirstName() + " " + owner1.getLastName());
        });*/

        //insertTestNames();

        do {
            displayMenu();
            int option = getOption();

            if (option == 1) {
                displayAllOwners();
            }
            else if(option == 2){
                addOwners();
            }
            else if(option == 3){
                removeOwners();
            }
            else if (option == 4){
                break;
            }
        } while (true);
        System.out.println("Exiting...");
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

        if(isEmpty){
            System.out.println("List is empty.");
        }
    }

    static void addOwners(){
        for (int i = 0; i < owners.length; i++) {
            if(owners[i] == null){
                System.out.print("Name: ");
                owners[i] = scanner.nextLine();
                System.out.print("Date of Birth: ");
                String date = scanner.nextLine();
                //default, ISO_LOCAL_DATE
                LocalDate localDate = LocalDate.parse(date);
                System.out.print("Address: ");
                owners[i] = scanner.nextLine();
                System.out.print("Phone number: ");
                owners[i] = scanner.nextLine();
                System.out.print("Email: ");
                owners[i] = scanner.nextLine();
                System.out.println("Would you like to register your pet now? yes/no");
                String petReg = scanner.next();
                if(petReg.equalsIgnoreCase("yes")){
                    System.out.print("What is your pet's name? ");
                    String petName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Pet's DOB: ");
                    String petDate = scanner.nextLine();
                    LocalDate localDate2 = LocalDate.parse(petDate);
                    System.out.print("What is your pet type? ");
                    String petType = scanner.nextLine();
                    System.out.println("Thank you for your pet details!");
                    break;
                }else{
                    System.out.println("Registration is over!");
                    break;
                }
            }
        }

        /*String petRegistration = scanner.nextLine();
        System.out.println("What is the type of you pet?");
        String petType = scanner.nextLine();
        System.out.println("Your pets date of birth?");*/
    }

    static void removeOwners(){
        System.out.print("Name: ");
        String name = scanner.next();
        for(int i = 0; i < owners.length; i++){
            if(owners[i] != null && owners[i].equals(name)){
                owners[i] = null;
                break;
            }
        }

        String [] temp = new String [owners.length];
        int ti = 0;
        for (int i = 0; i < owners.length; i++){
            if(owners[i] != null){
                temp[ti] = owners[i];
                ti++;
            }
        }
        owners = temp;
    }

    static void displayMenu(){
        System.out.println("______________________________\n-Menu-\n");
        System.out.println();
        System.out.println("1 - Display All owners");
        System.out.println("2 - Add owners");
        System.out.println("3 - Remove owners");
        System.out.println("4 - Exit");
    }

    static int getOption(){
        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    /*static void insertTestNames(){
        owners[0] = "Tom";
        owners[1] = "Mike";
        owners[2] = "Sue";
        owners[3] = "Fiona";
        owners[4] = "Valerie";
    }*/
}
