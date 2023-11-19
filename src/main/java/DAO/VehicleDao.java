package DAO;

import Models.Vehicle;
import jakarta.persistence.EntityManager;

import java.util.List;

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

    public Vehicle getVehiclebyModel(String model) {
        return (Vehicle) em.createQuery("SELECT v FROM Vehicle v WHERE v.model = :model")
                .setParameter("model", model)
                .getSingleResult();
    }
    public List<Vehicle> getVehicles() {
        return em.createQuery("SELECT v FROM Vehicle v").getResultList();
    }

}
