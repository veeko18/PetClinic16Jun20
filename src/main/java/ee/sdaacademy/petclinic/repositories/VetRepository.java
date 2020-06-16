package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Consultant;
import ee.sdaacademy.petclinic.models.Owner;
import ee.sdaacademy.petclinic.models.Vet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VetRepository {

    //find all vets
    public List<Vet> findAll() {
        Session session = HibernateUtils.openSession();
        List<Vet> vet =
                session.createQuery("select vet from Vet vet", Vet.class)
                        .getResultList();
        session.close();
        return vet;
    }

    //find vet by vet id
    public Vet findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Vet vet = session.find(Vet.class, id);
        session.close();
        return vet;
    };

    //save to database
    public void save(Vet vet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vet);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Vet vet){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(vet);
        transaction.commit();
        session.close();
    };

    //delete from database by vet id
    public void deleteById(Vet vetId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(vetId);
        transaction.commit();
        session.close();
    }

    //update database
    public void update(Vet vet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(vet);
        transaction.commit();
        session.close();
    };
}

