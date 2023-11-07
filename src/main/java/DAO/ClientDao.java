package DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

public class ClientDao {

    EntityManager em;

    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public void saveClient(Entity client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public void updateClient(Entity client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public void deleteClient(Entity client) {
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();
    }

    public Entity getClient(int id) {
        return em.find(Entity.class, id);
    }
}
