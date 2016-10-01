package Formularios;

import javax.swing.*;
import java.util.Date;

/**
 * Created by DanielQuirozV on 10/23/2015.
 */
public class frmProductos extends JInternalFrame {
     //Objetos Label

    private JLabel lbelId;
    private JLabel lbelNombre;
    private JLabel lbelMarca;
    private JLabel lbelTipo;
    private JLabel lbelFechaVencimiento;
    private JLabel lbelPrecio;
    private JLabel lbelCantidad;

    //Objetos TextField
    private  JTextField txtId;
    private  JTextField txtNombre;
    private  JTextField txtMarca;
    private  JComboBox  cbTipo;
    private  JTextField txtFechaVencimiento;
    private  JTextField txtPrecio;
    private  JTextField txtCantidad;

    //Atributos del Form Productos
    public frmProductos(){
       setTitle("Productos");
       setClosable(true);
       setIconifiable(true);
       setSize(550,490);
       setLayout(null);
       setResizable(false);
   }
}

