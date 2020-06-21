package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Scanner;

public class PetRepository {

    public static void petRegistration(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to register you pet? yes/no");
        String reply = scanner.next();
        if(reply.equalsIgnoreCase("yes")){
            System.out.println("What is your pet's name?");
            String petName = scanner.nextLine();
            String petRegistration = scanner.nextLine();
            System.out.println("What is the type of you pet?");
            String petType = scanner.nextLine();
            System.out.println("Your pets date of birth?");

            System.out.println("Registration of your pet is complete!");
        } else {
            System.out.println("You quit registration!");
        }
    }

    //find all Pets
    public List<Pet> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Pet> pet = session.createQuery("select pet " +
                "from Pet pet ", Pet.class).getResultList();
        session.close();
        return pet;
    }

    //find Pet by Pet alphabetically
    public List <Pet> findAllAlphabetically() {
        Session session = HibernateUtils.openSession();
        List<Pet> pet = session.createQuery("select pet" +
                " from Pet pet order by pet.firstName", Pet.class)
                .getResultList();
        return pet;
    };

    //find Pets by id
    public Pet findById(Integer id){
        Session session = HibernateUtils.openSession();
        Pet pet = session.find(Pet.class, id);
        session.close();
        return pet;
    };

    //save to database
    public void save(Pet pet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pet);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Pet pet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pet);
        transaction.commit();
        session.close();
    };

    //delete from database by Pets id
    public void deleteById(int petId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(petId);
        transaction.commit();
        session.close();
    };

    //update database
    public void update(Pet pet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(pet);
        transaction.commit();
        session.close();
    };
}

