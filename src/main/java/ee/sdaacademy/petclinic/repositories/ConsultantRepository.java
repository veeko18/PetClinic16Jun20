package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Consultant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Scanner;


public class ConsultantRepository {

        public static void consultation(){

            Scanner scanner = new Scanner(System.in);
            String [] owners = new String[10];

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
        }

    //find all consultants
    public List<Consultant> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Consultant> consultants = session.createQuery("select consultant " +
                "from Consultant consultant ", Consultant.class).getResultList();
        session.close();
        return consultants;
    }

    //find consultant by consultant alphabetically
    public List <Consultant> findAllAlphabetically() {
        Session session = HibernateUtils.openSession();
        List<Consultant> consultant = session.createQuery("select consultant" +
                " from Consultant consultant order by consultant.firstName", Consultant.class)
                .getResultList();
        return consultant;
    };

    //find consultants by id
    public Consultant findById(Integer id){
        Session session = HibernateUtils.openSession();
        Consultant consultant = session.find(Consultant.class, id);
        session.close();
        return consultant;
    };

    //save to database
    public void save(Consultant consultant){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(consultant);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Consultant consultant){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultant);
        transaction.commit();
        session.close();
    };

    //delete from database by consultants id
    public void deleteById(Consultant consultantId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultantId);
        transaction.commit();
        session.close();
    };

    //update database
    public void update(Consultant consultant){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(consultant);
        transaction.commit();
        session.close();
    };

}

