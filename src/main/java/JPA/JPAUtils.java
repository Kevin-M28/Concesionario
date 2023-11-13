package JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils implements AutoCloseable{
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public JPAUtils(){
        emf = Persistence.createEntityManagerFactory("concesionario");
        em = emf.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return em;
    }

    @Override
    public void close(){
        em.close();
        emf.close();
    }
}
