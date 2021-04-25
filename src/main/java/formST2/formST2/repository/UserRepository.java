package formST2.formST2.repository;

import formST2.formST2.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceUnit(name = "allInfo")
    EntityManagerFactory entityManagerFactory;

    public List getallinfo() {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();
        TypedQuery<User> query=entityManager.createQuery("SELECT u FROM User u",User.class);
        List<User> user=query.getResultList();
        System.out.println(user);
        return user;


    }

    public void postinfo(User user) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();

        }
        catch (Exception e){
            System.out.println(e);
            entityTransaction.rollback();
        }

    }

    public void deleteInfo(String email) {
      EntityManager entityManager= entityManagerFactory.createEntityManager();
      EntityTransaction entityTransaction= entityManager.getTransaction();
      try{

          entityTransaction.begin();
          TypedQuery<User> query=entityManager.createQuery("SELECT u FROM User u WHERE u.email= :email",User.class).setParameter("email", email);
          User user= query.getSingleResult();
          entityManager.remove(user);
          entityTransaction.commit();


      }
      catch (Exception e){
          System.out.println(e);
          entityTransaction.rollback();
      }
    }

    public boolean findByEmail(String email) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try{

            TypedQuery<User> query=entityManager.createQuery("SELECT u FROM User u WHERE u.email= :email",User.class).setParameter("email", email);
            System.out.println(query.getResultList()+"***"+email);
            return true;



        }
        catch (Exception e){
            System.out.println(e);
            return true;
        }


    }
}
