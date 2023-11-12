package DAO;

import Models.Client;
import jakarta.persistence.EntityManager;

public class ClientDao {

    EntityManager em;

    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public void saveClient(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public void updateClient(Client client) {
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public void deleteClient(Client client) {
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();
    }

    public Client getClient(int id) {
        return em.find(Client.class, id);
    }
}
