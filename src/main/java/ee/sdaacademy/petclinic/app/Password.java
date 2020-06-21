package ee.sdaacademy.petclinic.app;

import java.util.Scanner;

public class Password {
    public static void addPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        printResult(validatePassword(password));
    }

    //this method validates password
    //valid password example: $password@
    static boolean validatePassword(String password){
        int length = password.length();
        if ((length>5 && length<26) && (password.charAt(0)=='$')
                && (password.charAt(length-1)== '@')){
            return true;
        }else{
            return false;}
    }

    //this method prints out the result of boolean method
    static void printResult(boolean value){
        if(value){
            System.out.println("Valid");
        }else{
            System.out.println("Not valid");}
    }
}


