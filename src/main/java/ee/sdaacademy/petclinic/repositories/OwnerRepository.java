package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.app.Password;
import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Consultant;
import ee.sdaacademy.petclinic.models.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OwnerRepository {

    static Scanner scanner = new Scanner(System.in);
    static String[] owners = new String[10];

    public static void OwnerInput() {
        do {
            displayMenu();
            int option = getOption();

            if (option == 1) {
                displayAllOwners();
            } else if (option == 2) {
                addOwners();
            } else if (option == 3) {
                removeOwners();
            } else if (option == 4) {
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

        if (isEmpty) {
            System.out.println("List is empty.");
        }
    }

    static void addOwners() {
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] == null) {
                System.out.print("Enter username: ");
                owners[i] = scanner.nextLine();
                Password.addPassword();
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
                owners[i] = scanner.next();
                System.out.print("Name for database: ");
                System.out.println("Your registration is complete!\n");
                System.out.print("Would you like to register your pet now? yes/no ");
                String petReg = scanner.next();
                if (petReg.equalsIgnoreCase("yes")) {
                    System.out.print("What is your pet's name? ");
                    String petName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Pet's DOB: ");
                    String petDate = scanner.nextLine();
                    LocalDate localDate2 = LocalDate.parse(petDate);
                    System.out.print("What is your pet type? ");
                    String petType = scanner.nextLine();
                    System.out.println("Thank you for your pet details!\n" +
                            "Registration of your pet is complete!");
                    break;
                } else {
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

    static void removeOwners() {
        System.out.print("Name: ");
        String name = scanner.next();
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null && owners[i].equals(name)) {
                owners[i] = null;
                break;
            }
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

    static void displayMenu() {
        System.out.println("______________________________\n-Menu-\n");
        System.out.println();
        System.out.println("1 - Display All owners");
        System.out.println("2 - Add owners");
        System.out.println("3 - Remove owners");
        System.out.println("4 - Exit");
    }

    static int getOption() {
        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }



    //find all Owners
    public List<Owner> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> owner = session.createQuery("select owner " +
                "from Owner owner ", Owner.class).getResultList();
        session.close();
        return owner;
    }

    //find Owner by Owner alphabetically
    public List <Owner> findAllAlphabetically() {
        Session session = HibernateUtils.openSession();
        List<Owner> owner = session.createQuery("select owner" +
                " from Owner owner order by owner.firstName", Owner.class)
                .getResultList();
        return owner;
    };

    //find Owners by id
    public Owner findById(Integer id){
        Session session = HibernateUtils.openSession();
        Owner owner = session.find(Owner.class, id);
        session.close();
        return owner;
    };

    //save to database
    public void save(Owner owner){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Owner owner){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(owner);
        transaction.commit();
        session.close();
    };

    //delete from database by Owners id
    public void deleteById(Owner ownerId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ownerId);
        transaction.commit();
        session.close();
    };

    //update database
    public void update(Owner owner){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(owner);
        transaction.commit();
        session.close();
    };
}
