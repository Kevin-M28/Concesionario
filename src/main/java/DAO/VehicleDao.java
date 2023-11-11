package DAO;

import Models.Vehicle;
import jakarta.persistence.EntityManager;

public class VehicleDao {

    private EntityManager em;

    public VehicleDao(EntityManager em) {
        this.em = em;
    }

    public void saveVehicle(Vehicle vehicle) {
        em.getTransaction().begin();
        em.persist(vehicle);
        em.getTransaction().commit();
    }

    public void updateVehicle(Vehicle vehicle) {
        em.getTransaction().begin();
        em.merge(vehicle);
        em.getTransaction().commit();
    }

    public void deleteVehicle(Vehicle vehicle) {
        em.getTransaction().begin();
        em.remove(vehicle);
        em.getTransaction().commit();
    }

    public Vehicle getVehicle(int id) {
        return em.find(Vehicle.class, id);
    }
}
