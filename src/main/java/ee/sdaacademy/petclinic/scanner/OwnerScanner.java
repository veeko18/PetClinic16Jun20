package ee.sdaacademy.petclinic.scanner;

import ee.sdaacademy.petclinic.app.Password;
import ee.sdaacademy.petclinic.models.Owner;
import ee.sdaacademy.petclinic.repositories.OwnerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OwnerScanner {
    public static void ownerRegistration() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        Password.addPassword();
        System.out.print("Date of Birth: ");
        String date = scanner.nextLine();
        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Name for database: ");
        String fullName = scanner.next();
        System.out.println("Your registration is complete!\n");
    }
}

