package ee.sdaacademy.petclinic.scanner;

import java.util.Scanner;

public class ConsultationScanner {

    public static void consultation(){

        Scanner scanner = new Scanner(System.in);
        String [] owners = new String[10];

        System.out.print("Please enter your name: ");
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
    }
}
