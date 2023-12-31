package DAO;


import Models.Sale;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SaleDao {

    EntityManager em;

    public SaleDao(EntityManager em) {
        this.em = em;
    }

    public void saveSale(Sale sale) {
        em.getTransaction().begin();
        em.merge(sale);
        em.getTransaction().commit();
    }

    public void updateSale(Sale sale) {
        em.getTransaction().begin();
        em.merge(sale);
        em.getTransaction().commit();
    }

    public void deleteSale(Sale sale) {
        em.getTransaction().begin();
        em.remove(sale);
        em.getTransaction().commit();
    }

    public Sale getSale(int id) {
        return em.find(Sale.class, id);
    }

    public List<Sale> getSales() {
        return em.createQuery("SELECT s FROM Sale s").getResultList();
    }

}
