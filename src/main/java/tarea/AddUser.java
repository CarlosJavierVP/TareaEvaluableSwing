package tarea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddUser extends JFrame{
    private JPanel panel1;
    private JButton save;
    private JButton back;
    private JTable table1;
    private JTextField fieldCorreo;
    private JComboBox comboBox1;
    private JCheckBox checkBox1;
    private JLabel labelInformacion;

    private DefaultTableModel model;


    public AddUser (){

        String[] cabecera ={"Correo", "Idioma", "Rol"};

        model = new DefaultTableModel(cabecera, 0);
        table1.setModel(model);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Añadir Usuario");
        pack();
        setLocationRelativeTo(null);

        var opcionesCombo = new DefaultComboBoxModel<String>();
        comboBox1.setModel(opcionesCombo);

        opcionesCombo.addElement("Inglés");
        opcionesCombo.addElement("Español");
        opcionesCombo.addElement("Francés");
        opcionesCombo.addElement("Alemán");

        save.addActionListener( (e) ->{
            if (fieldCorreo.getText().isEmpty()){
                labelInformacion.setText("Falta por indicar el correo electrónico");
            }else{
                Object[] row = {fieldCorreo.getText(), comboBox1.getSelectedItem(), checkBox1.isSelected()};
                model.addRow(row);

                var correo = fieldCorreo.getText();
                var idioma = comboBox1.getSelectedItem();
                var admin = checkBox1.isSelected();
                var administrador = "";

                if (admin){
                    administrador = "[Administrador]";
                }


                JOptionPane.showMessageDialog(this, "Usuario "+administrador+" almacenado correctamente '\n" +
                        "Correo electrónico: "+correo);
            }


        });








    }
}
