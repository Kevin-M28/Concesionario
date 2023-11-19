
package Views;

import DAO.ClientDao;
import DAO.SaleDao;
import DAO.VehicleDao;
import Models.Client;
import JPA.JPAUtils;
import Models.Sale;
import Models.Vehicle;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.awt.*;

public class Cliente extends JPanel {
    public Cliente() {
        initComponents();
    }
    void setCliente(Client client){
        this.client = client;
        nombreUser.setText(client.getUsername());
    }
    public void llenarTablaHisorial(){
        if (client.getSales_hisory() != null) {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            for (int i = 0; i < client.getSales_hisory().size(); i++) {
                model.addRow(new Object[]{client.getSales_hisory().get(i).getId(), client.getSales_hisory().get(i).getVehicle().getModel(), client.getSales_hisory().get(i).getDate(), client.getSales_hisory().get(i).getTotal(), client.getSales_hisory().get(i).getPayment_method()});
            }
        }

    }

    public void  llenarTablaVehiculos(){
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        List<Vehicle> vehicles = vehicleDao.getVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getStock() > 0) {
                model.addRow(new Object[]{vehicles.get(i).getId(), vehicles.get(i).getModel(), vehicles.get(i).getFabricant(), vehicles.get(i).getYear(), vehicles.get(i).getColor(), vehicles.get(i).getPrice()});
            }
        }
    }
    public void comprar(){
        int id = (int) table2.getValueAt(table2.getSelectedRow(), 0);
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        Vehicle vehicle = vehicleDao.getVehicle(id);
        SaleDao saleDao = new SaleDao(new JPAUtils().getEntityManager());
        Sale sale = new Sale(client, vehicle, "2021-05-05", vehicle.getPrice(), JcomboboxPago.getSelectedItem().toString());
        saleDao.saveSale(sale);
        if (vehicle.getStock() > 0) {
            vehicle.setStock(vehicle.getStock() - 1);
            vehicleDao.updateVehicle(vehicle);
            client.getSales_hisory().add(sale);
            ClientDao clientDao = new ClientDao(new JPAUtils().getEntityManager());
            clientDao.updateClient(client);
            llenarTablaHisorial();
            llenarTablaVehiculos();
        }
    }
    private void initComponents() {
        client = new Client();
        setPreferredSize(new Dimension(750 , 650));
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label2 = new JLabel();
        button1 = new JButton();
        label1 = new JLabel();
        nombreUser = new JTextField();
        nombreUser.setEditable(false);
        nombreUser.setFocusable(false);

        //======== this ========

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {

                        },
                        new String[] {
                            "ID", "Vehiculo", "Fecha", "Total", "Forma de pago"
                        }
                    ));
                    table1.setDefaultEditor(Object.class, null);
                    scrollPane1.setViewportView(table1);
                }


                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 26, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(25, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Historial de compra", panel1);

            //======== panel2 ========
            {

                //======== scrollPane2 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Modelo", "fabricante", "A\u00f1o", "Color", "Precio"
                        }
                    ));
                    table2.setDefaultEditor(Object.class, null);
                    scrollPane2.setViewportView(table2);

                }
                llenarTablaVehiculos();
                //---- label2 ----
                label2.setText("Forma de pago");

                //---- button1 ----
                button1.setText("Comprar");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(JcomboboxPago, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(251, 251, 251)
                                    .addComponent(button1)))
                            .addContainerGap(17, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(JcomboboxPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(button1)
                            .addContainerGap(22, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Comprar", panel2);
        }

        //---- label1 ----
        label1.setText("Usuario");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1)
                        .addComponent(nombreUser, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nombreUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        button1.addActionListener(e -> comprar());

    }

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label2;
    private JComboBox JcomboboxPago = new JComboBox(new String[]{"Efectivo", "Tarjeta"});
    private JButton button1;
    private JLabel label1;
    private JTextField nombreUser;
    private Client client;
}
