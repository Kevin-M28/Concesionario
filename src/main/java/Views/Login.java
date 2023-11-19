
package Views;

import DAO.ClientDao;
import Models.Role;
import Models.User;
import DAO.UserDao;
import JPA.JPAUtils;

import javax.swing.*;
import javax.swing.GroupLayout;


public class Login extends JPanel {
    public Login() {
        initComponents();
    }
    void ButtonEntrar(){
        UserDao userDao = new UserDao(new JPAUtils().getEntityManager());
        try {
            User usuario = userDao.getUser(textField1.getText(), textField2.getText());
            if (usuario.getRole() == Role.ADMIN) {
                JFrame frame = new JFrame("Main");
                frame.setContentPane(new Admin());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,750);
                frame.pack();
                frame.setVisible(true);

            } else if (usuario.getRole() == Role.CLIENT) {
                JFrame frame = new JFrame("Main");
                frame.setContentPane(new Cliente());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,750);
                frame.pack();
                frame.setVisible(true);
                System.out.println(usuario.getId());
                ((Cliente) frame.getContentPane()).setCliente(new ClientDao(new JPAUtils().getEntityManager()).getClient(usuario.getId()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }

    }
    private void initComponents() {
        Login = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========

        //---- Login ----
        Login.setText("          Login");

        //---- label1 ----
        label1.setText("Usuario");

        //---- label2 ----
        label2.setText("Contrase\u00f1a");

        //---- button1 ----
        button1.setText("Entrar");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(textField1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(102, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(Login, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(button1)))
                    .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(Login, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)
                    .addComponent(label2)
                    .addGap(18, 18, 18)
                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(button1)
                    .addContainerGap(78, Short.MAX_VALUE))
        );
        button1.addActionListener(e -> ButtonEntrar());
    }

    private JLabel Login;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
}
