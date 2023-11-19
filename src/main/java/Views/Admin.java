
package Views;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

import DAO.*;
import JPA.JPAUtils;
import Models.*;


public class Admin extends JPanel {
    public Admin() {
        initComponents();
    }

    public void setUser(User user){
        this.user = user;
        userName.setText(user.getUsername());
    }
    public void agregarCliente(){

        ClientDao clientDao = new ClientDao(new JPAUtils().getEntityManager());
        Client client = (idCliente.getText().isEmpty())? new Client(nombreCliente.getText(), txtcorreoCliente.getText(), contraCliente.getText(), Role.CLIENT, teltxt.getText()): clientDao.getClient(Integer.parseInt( idCliente.getText()));
        if(idCliente.getText().isEmpty()){
            clientDao.saveClient(client);
            JOptionPane.showMessageDialog(null, "Cliente agregado");
        }else{
            //set de los nuevos atributos
            client.setUsername(nombreCliente.getText());
            client.setE_mail(txtcorreoCliente.getText());
            client.setPassword(contraCliente.getText());
            client.setTelephone(teltxt.getText());
            clientDao.updateClient(client);
            JOptionPane.showMessageDialog(null, "Cliente actualizado");
        }
        limpiarCliente();
        tablaClientes();

    }
    public void agregarVehiculo(){
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        Vehicle vehicle = (idCar.getText().isEmpty())? new Vehicle(modelCar.getText(), fabriCar.getText(), annoCar.getText(), carColor.getText(), Double.parseDouble(carPrice.getText()), Integer.parseInt(carStock.getText())): vehicleDao.getVehicle(Integer.parseInt(idCar.getText()));
        if(idCar.getText().isEmpty()){
            vehicleDao.saveVehicle(vehicle);
            JOptionPane.showMessageDialog(null, "Vehiculo agregado");
        }else{
            //set de los nuevos atributos
            vehicle.setModel(modelCar.getText());
            vehicle.setFabricant(fabriCar.getText());
            vehicle.setYear(annoCar.getText());
            vehicle.setColor(carColor.getText());
            vehicle.setPrice(Double.parseDouble(carPrice.getText()));
            vehicle.setStock(Integer.parseInt(carStock.getText()));
            vehicleDao.updateVehicle(vehicle);
            JOptionPane.showMessageDialog(null, "Vehiculo actualizado");
        }
        limpiarVehiculo();
        tablaVehiculos();
    }
    public void eliminarCliente(){
        ClientDao clientDao = new ClientDao(new JPAUtils().getEntityManager());
        if (idCliente.getText().isEmpty() || clientDao.getClient(Integer.parseInt(idCliente.getText())) == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado o no ha seleccionado uno");
        }else {
            clientDao.deleteClient(clientDao.getClient(Integer.parseInt(idCliente.getText())));
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        }
        limpiarCliente();
        tablaClientes();
    }
    public void limpiarCliente(){
        idCliente.setText("");
        nombreCliente.setText("");
        txtcorreoCliente.setText("");
        contraCliente.setText("");
        teltxt.setText("");
    }
    public void limpiarVehiculo(){
        idCar.setText("");
        modelCar.setText("");
        fabriCar.setText("");
        annoCar.setText("");
        carColor.setText("");
        carPrice.setText("");
        carStock.setText("");
    }
    public void buscarClienteTabla(){
        ClientDao clientDao = new ClientDao(new JPAUtils().getEntityManager());
        Client client = clientDao.getClientNombre(nombreCliente.getText());
        if (client != null) {
            idCliente.setText(String.valueOf(client.getId()));
            nombreCliente.setText(client.getUsername());
            txtcorreoCliente.setText(client.getE_mail());
            contraCliente.setText(client.getPassword());
            teltxt.setText(client.getTelephone());
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }

    public void eliminarVehiculo(){
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        if (idCar.getText().isEmpty() || vehicleDao.getVehicle(Integer.parseInt(idCar.getText())) == null) {
            JOptionPane.showMessageDialog(null, "Vehiculo no encontrado o no ha seleccionado uno");
        }else {
            vehicleDao.deleteVehicle(vehicleDao.getVehicle(Integer.parseInt(idCar.getText())));
            JOptionPane.showMessageDialog(null, "Vehiculo eliminado");
        }
        limpiarVehiculo();
        tablaVehiculos();
    }
    public void buscarVehiculoTabla(){
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        Vehicle vehicle = vehicleDao.getVehiclebyModel(modelCar.getText());
        if (vehicle != null) {
            idCar.setText(String.valueOf(vehicle.getId()));
            modelCar.setText(vehicle.getModel());
            fabriCar.setText(vehicle.getFabricant());
            annoCar.setText(vehicle.getYear());
            carColor.setText(vehicle.getColor());
            carPrice.setText(String.valueOf(vehicle.getPrice()));
            carStock.setText(String.valueOf(vehicle.getStock()));
        }else{
            JOptionPane.showMessageDialog(null, "Vehiculo no encontrado");
        }
    }
    public void tablaVentas(){
        SaleDao saleDao = new SaleDao(new JPAUtils().getEntityManager());
        DefaultTableModel model = (DefaultTableModel) list3.getModel();
        model.setRowCount(0);
        for (int i = 0; i < saleDao.getSales().size(); i++) {
            model.addRow(new Object[]{saleDao.getSales().get(i).getClient().getUsername(), saleDao.getSales().get(i).getVehicle().getModel(), saleDao.getSales().get(i).getDate(), saleDao.getSales().get(i).getTotal(), saleDao.getSales().get(i).getPayment_method()});
        }
    }
    public void tablaClientes(){
        ClientDao clientDao = new ClientDao(new JPAUtils().getEntityManager());
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < clientDao.getClients().size(); i++) {
            model.addRow(new Object[]{clientDao.getClients().get(i).getId(), clientDao.getClients().get(i).getUsername(), clientDao.getClients().get(i).getE_mail(), clientDao.getClients().get(i).getPassword(), clientDao.getClients().get(i).getRole(), clientDao.getClients().get(i).getTelephone()});
        }
    }
    public void tablaVehiculos(){
        VehicleDao vehicleDao = new VehicleDao(new JPAUtils().getEntityManager());
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        for (int i = 0; i < vehicleDao.getVehicles().size(); i++) {
            model.addRow(new Object[]{vehicleDao.getVehicles().get(i).getId(), vehicleDao.getVehicles().get(i).getModel(), vehicleDao.getVehicles().get(i).getFabricant(), vehicleDao.getVehicles().get(i).getYear(), vehicleDao.getVehicles().get(i).getColor(), vehicleDao.getVehicles().get(i).getPrice(), vehicleDao.getVehicles().get(i).getStock()});
        }
    }
    public void rellenaCamposconTablaCli(){
        int row = table1.getSelectedRow();
        idCliente.setText(table1.getModel().getValueAt(row, 0).toString());
        nombreCliente.setText(table1.getModel().getValueAt(row, 1).toString());
        txtcorreoCliente.setText(table1.getModel().getValueAt(row, 2).toString());
        contraCliente.setText(table1.getModel().getValueAt(row, 3).toString());
        roltxt.setText(table1.getModel().getValueAt(row, 4).toString());
        teltxt.setText(table1.getModel().getValueAt(row, 5).toString());
    }
    public void rellenaCamposconTablaVeh(){
        int row = table2.getSelectedRow();
        idCar.setText(table2.getModel().getValueAt(row, 0).toString());
        modelCar.setText(table2.getModel().getValueAt(row, 1).toString());
        fabriCar.setText(table2.getModel().getValueAt(row, 2).toString());
        annoCar.setText(table2.getModel().getValueAt(row, 3).toString());
        carColor.setText(table2.getModel().getValueAt(row, 4).toString());
        carPrice.setText(table2.getModel().getValueAt(row, 5).toString());
        carStock.setText(table2.getModel().getValueAt(row, 6).toString());
    }

    private void initComponents() {
        user = new User();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label2 = new JLabel();
        idCliente = new JTextField();
        label3 = new JLabel();
        nombreCliente = new JTextField();
        label4 = new JLabel();
        txtcorreoCliente = new JTextField();
        label5 = new JLabel();
        contraCliente = new JTextField();
        label6 = new JLabel();
        roltxt = new JTextField();
        label7 = new JLabel();
        teltxt = new JTextField();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel2 = new JPanel();
        label12 = new JLabel();
        idCar = new JTextField();
        label13 = new JLabel();
        modelCar = new JTextField();
        label14 = new JLabel();
        fabriCar = new JTextField();
        label15 = new JLabel();
        annoCar = new JTextField();
        label16 = new JLabel();
        carColor = new JTextField();
        label17 = new JLabel();
        carPrice = new JTextField();
        label18 = new JLabel();
        carStock = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        panel3 = new JPanel();
        label19 = new JLabel();
        scrollPane4 = new JScrollPane();
        list3 = new JTable();
        label1 = new JLabel();
        userName = new JTextField();

        idCliente.setEditable(false);
        roltxt.setText("CLIENT");
        roltxt.setEditable(false);
        idCar.setEditable(false);
        userName.setEditable(false);
        //======== this ========
        setPreferredSize(new Dimension(750 , 650));

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //---- label2 ----
                label2.setText("ID");

                //---- label3 ----
                label3.setText("Nombre");

                //---- label4 ----
                label4.setText("Correo");

                //---- label5 ----
                label5.setText("Contrase\u00f1a");

                //---- label6 ----
                label6.setText("Rol");

                //---- label7 ----
                label7.setText("Telefono");

                //======== scrollPane2 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Nombre", "Correo", "Contrase\u00f1a", "Rol", "Telefono"
                        }
                    ));
                    table1.setDefaultEditor(Object.class, null);
                    table1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            rellenaCamposconTablaCli();
                        }
                    });
                    scrollPane2.setViewportView(table1);
                }

                //---- button1 ----
                button1.setText("Agregar");
                button1.addActionListener(e -> agregarCliente());

                //---- button2 ----
                button2.setText("Eliminar");
                button2.addActionListener(e -> eliminarCliente());

                //---- button5 ----
                button5.setText("Buscar");
                button5.addActionListener(e -> buscarClienteTabla());

                //---- button6 ----
                button6.setText("limpiar");
                button6.addActionListener(e -> limpiarCliente());

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(idCliente, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(label3)
                                                .addComponent(label4)
                                                .addComponent(nombreCliente, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtcorreoCliente, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label5)
                                                .addComponent(contraCliente, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                            .addGap(43, 43, 43)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label6)
                                                .addComponent(label7)
                                                .addComponent(teltxt, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(roltxt, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(button1)
                                    .addGap(18, 18, 18)
                                    .addComponent(button2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(button5)
                                            .addGap(18, 18, 18)
                                            .addComponent(button6)))))
                            .addContainerGap(141, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(idCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(22, 22, 22)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roltxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(teltxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtcorreoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(contraCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(button5)
                                .addComponent(button6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("Clientes", panel1);

            //======== panel2 ========
            {

                //---- label12 ----
                label12.setText("ID");

                //---- label13 ----
                label13.setText("Modelo");

                //---- label14 ----
                label14.setText("Fabricante");

                //---- label15 ----
                label15.setText("A\u00f1o");

                //---- label16 ----
                label16.setText("Color");

                //---- label17 ----
                label17.setText("Precio");

                //---- label18 ----
                label18.setText("Cantidad");

                //---- button7 ----
                button7.setText("Agregar");
                button7.addActionListener(e -> agregarVehiculo());

                //---- button8 ----
                button8.setText("Eliminar");
                button8.addActionListener(e -> eliminarVehiculo());


                //---- button9 ----
                button9.setText("Buscar");
                button9.addActionListener(e -> buscarVehiculoTabla());

                //---- button10 ----
                button10.setText("Limpiar");
                button10.addActionListener(e -> limpiarVehiculo());

                //======== scrollPane3 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "ID", "Modelo", "Fabricante", "A\u00f1o", "Color", "Precio", "Cantidad"
                        }
                    ));
                    table2.setDefaultEditor(Object.class, null);
                    table2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            rellenaCamposconTablaVeh();
                        }
                    });
                    scrollPane3.setViewportView(table2);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(label12)
                                            .addGap(18, 18, 18)
                                            .addComponent(idCar, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label13)
                                        .addComponent(label14)
                                        .addComponent(fabriCar, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(label15)
                                        .addComponent(annoCar, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(modelCar, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(label16)
                                                .addComponent(label17)))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label18)
                                                .addComponent(carPrice, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(carColor, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(carStock, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(button7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button8)
                                    .addGap(18, 18, 18)
                                    .addComponent(button9)
                                    .addGap(18, 18, 18)
                                    .addComponent(button10))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(31, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label12)
                                .addComponent(idCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label13)
                                .addComponent(label16))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(modelCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(carColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label14)
                                .addComponent(label17))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fabriCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(carPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label15)
                                .addComponent(label18))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(annoCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(carStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button10)
                                .addComponent(button9)
                                .addComponent(button8)
                                .addComponent(button7))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Vehiculo", panel2);

            //======== panel3 ========
            {

                //---- label19 ----
                label19.setText("Lista de ventas");

                //======== scrollPane4 ========
                {
                    //table 3
                    list3.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "Cliente", "Vehiculo", "Fecha", "Total", "Metodo de pago"
                        }
                    ));
                    list3.setDefaultEditor(Object.class, null);
                    scrollPane4.setViewportView(list3);
                }

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addComponent(label19)
                                    .addGap(0, 591, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(label19)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(18, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Ventas", panel3);
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
                        .addComponent(label1)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(label1)
                    .addGap(3, 3, 3)
                    .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        tablaClientes();
        tablaVentas();
        tablaVehiculos();
    }
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField idCliente;
    private JLabel label3;
    private JTextField nombreCliente;
    private JLabel label4;
    private JTextField txtcorreoCliente;
    private JLabel label5;
    private JTextField contraCliente;
    private JLabel label6;
    private JTextField roltxt;
    private JLabel label7;
    private JTextField teltxt;
    private JLabel label8;
    private JTextField diretxt;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel2;
    private JLabel label12;
    private JTextField idCar;
    private JLabel label13;
    private JTextField modelCar;
    private JLabel label14;
    private JTextField fabriCar;
    private JLabel label15;
    private JTextField annoCar;
    private JLabel label16;
    private JTextField carColor;
    private JLabel label17;
    private JTextField carPrice;
    private JLabel label18;
    private JTextField carStock;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel panel3;
    private JLabel label19;
    private JScrollPane scrollPane4;
    private JTable list3;
    private JLabel label1;
    private JTextField userName;
    private User user;

}
