package DAO;

import Models.Client;
import jakarta.persistence.EntityManager;

import java.util.List;

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
        em.createQuery("DELETE FROM Sale s WHERE s.client = :user")
                .setParameter("user", client)
                .executeUpdate();
        em.remove(client);
        em.getTransaction().commit();
    }

    public Client getClient(int id) {
        return em.find(Client.class, id);
    }

    public Client getClientbyUsername(String username) {
        return (Client) em.createQuery("SELECT c FROM Client c WHERE c.username = :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    public List<Client> getClients() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }

    public Client getClientNombre(String nombre) {
        return (Client) em.createQuery("SELECT c FROM Client c WHERE c.username = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }
}
