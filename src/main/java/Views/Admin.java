
package Views;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

public class Admin extends JPanel {
    public Admin() {
        initComponents();
    }

    private void initComponents() {
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField6 = new JTextField();
        label3 = new JLabel();
        textField7 = new JTextField();
        label4 = new JLabel();
        textField8 = new JTextField();
        label5 = new JLabel();
        textField9 = new JTextField();
        label6 = new JLabel();
        textField10 = new JTextField();
        label7 = new JLabel();
        textField11 = new JTextField();
        label8 = new JLabel();
        textField12 = new JTextField();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel2 = new JPanel();
        label12 = new JLabel();
        textField15 = new JTextField();
        label13 = new JLabel();
        textField16 = new JTextField();
        label14 = new JLabel();
        textField17 = new JTextField();
        label15 = new JLabel();
        textField18 = new JTextField();
        label16 = new JLabel();
        textField19 = new JTextField();
        label17 = new JLabel();
        textField20 = new JTextField();
        label18 = new JLabel();
        textField21 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        panel3 = new JPanel();
        label19 = new JLabel();
        scrollPane4 = new JScrollPane();
        list3 = new JList();
        label1 = new JLabel();
        textField5 = new JTextField();

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

                //---- label8 ----
                label8.setText("Direccion");

                //======== scrollPane2 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "Nombre", "Correo", "Rol", "Telefono", "Direccion"
                        }
                    ));
                    scrollPane2.setViewportView(table1);
                }

                //---- button1 ----
                button1.setText("Agregar");

                //---- button2 ----
                button2.setText("Eliminar");

                //---- button3 ----
                button3.setText("text");

                //---- button4 ----
                button4.setText("text");

                //---- button5 ----
                button5.setText("Buscar");

                //---- button6 ----
                button6.setText("limpiar");

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
                                                    .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(label3)
                                                .addComponent(label4)
                                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label5)
                                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                            .addGap(43, 43, 43)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label6)
                                                .addComponent(label7)
                                                .addComponent(textField11, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(textField10, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(label8)
                                                .addComponent(textField12, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(button1)
                                    .addGap(18, 18, 18)
                                    .addComponent(button2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(button3)
                                        .addComponent(button4)
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
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(22, 22, 22)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label8)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(button5)
                                .addComponent(button6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button3, GroupLayout.Alignment.TRAILING)
                                .addComponent(button4, GroupLayout.Alignment.TRAILING))
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

                //---- button8 ----
                button8.setText("Eliminar");

                //---- button9 ----
                button9.setText("Buscar");

                //---- button10 ----
                button10.setText("Limpiar");

                //======== scrollPane3 ========
                {

                    //---- table2 ----
                    table2.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "Modelo", "Fabricante", "A\u00f1o", "Color", "Color", "Precio", "Cantidad"
                        }
                    ));
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
                                            .addComponent(textField15, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label13)
                                        .addComponent(label14)
                                        .addComponent(textField17, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(label15)
                                        .addComponent(textField18, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                        .addComponent(textField16, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
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
                                                .addComponent(textField20, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(textField19, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                                .addComponent(textField21, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))))
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
                                .addComponent(textField15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label13)
                                .addComponent(label16))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label14)
                                .addComponent(label17))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label15)
                                .addComponent(label18))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(textField18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(label1)
                    .addGap(3, 3, 3)
                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE))
        );
    }
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField6;
    private JLabel label3;
    private JTextField textField7;
    private JLabel label4;
    private JTextField textField8;
    private JLabel label5;
    private JTextField textField9;
    private JLabel label6;
    private JTextField textField10;
    private JLabel label7;
    private JTextField textField11;
    private JLabel label8;
    private JTextField textField12;
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
    private JTextField textField15;
    private JLabel label13;
    private JTextField textField16;
    private JLabel label14;
    private JTextField textField17;
    private JLabel label15;
    private JTextField textField18;
    private JLabel label16;
    private JTextField textField19;
    private JLabel label17;
    private JTextField textField20;
    private JLabel label18;
    private JTextField textField21;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel panel3;
    private JLabel label19;
    private JScrollPane scrollPane4;
    private JList list3;
    private JLabel label1;
    private JTextField textField5;

}
