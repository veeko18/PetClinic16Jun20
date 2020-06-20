package ee.sdaacademy.petclinic;

import java.util.Scanner;

public class Application {

    static String[] owners = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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



        do {
            displayMenu();
            int option = getOption();

            if (option == 1) {
                displayAllOwners();
            }
            else if(option == 2){
                addOwners();

                /*String [] temp = new String [owners.length];
                int ti = 0;
                for (int i = 0; i < owners.length; i++){
                    if(owners[i] != null){
                        temp[ti] = owners[i];
                        ti++;
                    }
                }*/
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
        for (int i = 0; i < owners.length; i++) {
            System.out.println((i+1) + ". " + (owners[i] == null ? "--" : owners[i]));
        }
    }

    static void addOwners(){
        for (int i = 0; i < owners.length; i++) {
            if(owners[i] == null){
                System.out.print("Name: ");
                owners[i] = scanner.next();
                break;
            }
        }
    }

    static  void removeOwners(){
        System.out.print("Name: ");
        String name = scanner.next();
        for(int i = 0; i < owners.length; i++){
            if(owners[i] != null && owners[i].equals(name)){
                owners[i] = null;
                break;
            }
        }
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
        System.out.println();
        return option;
    }
}
