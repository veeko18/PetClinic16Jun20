package ee.sdaacademy.petclinic.scanner;

import java.util.Scanner;

public class PetTypeScanner {

   public static void displayAllPetTypes(){

       Scanner scanner = new Scanner(System.in);
       System.out.println("Select number according to the pet you have: ");
       int num = scanner.nextInt();
       if(num == 1){
           System.out.println("1 - Amphibians");
       }
       else if (num == 2){
           System.out.println("2 - Fishes");
       }
       else if (num == 3){
           System.out.println("3 - Fishes");
       }
       else if (num == 4){
           System.out.println("4 - Fishes");
       }
       else if (num == 5){
           System.out.println("5 - Fishes");
       }
       else if (num == 6){
           System.out.println("6 - Fishes");
       }
       else if (num == 7){
           System.out.println("7 - Fishes");
       }
       else {
           System.out.println("There is no such option. Try again");
       }

        System.out.println("3 - Birds");
        System.out.println("4 - Cats");
        System.out.println("5 - Dogs");
        System.out.println("6 - Rodents");
        System.out.println("7 - Reptiles");
    }
}
