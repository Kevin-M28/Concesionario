import DAO.UserDao;
import JPA.JPAUtils;
import jakarta.persistence.EntityManager;
import Models.*;
import DAO.*;
import Views.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Login());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
/*
        UserDao userDao = new UserDao(new JPAUtils().getEntityManager());
        userDao.saveUser(new User("admin", "admin", "admin@gmail.com", Role.ADMIN));
*/
    }
}
