package DAO;

import Models.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserDao {
    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void saveUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteUser(User user) {
        //elimina todas las ventas del usuario

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    //busca usuario por nombre y contraseña
    public User getUser(String username, String password) {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }

    public List<User> getUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }
}