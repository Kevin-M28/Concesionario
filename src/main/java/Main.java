import DAO.UserDao;
import JPA.JPAUtils;
import Models.Role;
import Models.User;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        User user = new User("Kevin2", "1232","kef2@gmail.com",Role.CLIENT);
        try (JPAUtils jpaUtils = new JPAUtils()){
            UserDao userDao = new UserDao((jpaUtils.getEntityManager()));
            userDao.saveUser(user);
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    }
}
