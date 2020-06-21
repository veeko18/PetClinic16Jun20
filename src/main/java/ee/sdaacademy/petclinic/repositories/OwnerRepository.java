package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.app.Password;
import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OwnerRepository {

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

    //find all Owners
    public List<Owner> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> owner = session.createQuery("select * from owner ", Owner.class).getResultList();
        session.close();
        return owner;
    }

    //find Owner by Owner alphabetically
    public List<Owner> findAllAlphabetically() {
        Session session = HibernateUtils.openSession();
        return session.createQuery("select owner" +
                " from Owner owner order by owner.firstName", Owner.class)
                .getResultList();
    }

    ;

    //find Owners by id
    public Owner findById(Integer id) {
        Session session = HibernateUtils.openSession();
        Owner owner = session.find(Owner.class, id);
        session.close();
        return owner;
    }

    ;

    //save to database
    public void save(Owner owner) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
    }

    ;

    //delete from database
    public void delete(Owner owner) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(owner);
        transaction.commit();
        session.close();
    }

    ;

    //delete from database by Owners id
    public void deleteById(int ownerId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ownerId);
        transaction.commit();
        session.close();
    }

    ;

    //update database
    public void update(Owner owner) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(owner);
        transaction.commit();
        session.close();
    }

    ;
}
