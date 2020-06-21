package ee.sdaacademy.petclinic.scanner;

import java.time.LocalDate;
import java.util.Scanner;

public class PetScanner {
    public static void petRegistration() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to register you pet? yes/no");
        String reply = scanner.next();
        if (reply.equalsIgnoreCase("yes")) {
            System.out.println("What is your pet's name?");
            String petName = scanner.nextLine();
            String petRegistration = scanner.nextLine();
            System.out.println("What is the type of you pet?");
            String petType = scanner.nextLine();
            System.out.println("Your pets date of birth?");
            String petsDoB = scanner.nextLine();
            LocalDate localDate = LocalDate.parse(petsDoB);

            System.out.println("Registration of your pet is complete!");
        } else {
            System.out.println("You quit registration!");
        }
    }
}
