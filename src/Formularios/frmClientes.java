package Formularios;

import Clases.Datos;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by DanielQuirozV on 10/23/2015.
 */
public class frmClientes extends JInternalFrame {
    //Obejtos de JLabel
    private JLabel lbelIDCliente;
    private JLabel lbelTipoIdenty;
    private JLabel lbelNombres;
    private JLabel lbelApellidos;
    private JLabel lbelDireccion;
    private JLabel lbelTelefono;
    private JLabel lbelFechaN;
    private JLabel lbelCuidad;
    private JLabel lbelFechaIng;
    private JLabel lbelMensaje;


    //Objetos de TextField
    private JTextField txtIDCliente;
    private JComboBox cbTipoIdentity;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JComboBox cbCuidad;
    //Objetos de tipo Fecha
    private JDateChooser dateNacimiento;
    private JDateChooser dateIngreso;
    //Botones
    private JButton btnPrimero;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JButton btnNuevo;
    private JButton btnModificar;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnBorrar;
    private JButton btnBuscar;
    //Tabla
    private JTable tblTable;
    private JScrollPane scrollTable;
    //Perfiles
    private String tiposId[] = {"No.Cedula", "Tarjeta de Identidad", "DNI", "Pasaporte", "Seguro Social"};
    private String cuidades[] = {"Santo Domingo", "Santiago", "La Vega", "Constanza", "San Francisco de Macoris",
            "San Juan de la Maguana"};
    //Atributos
    private Datos misDatos;
    private int clientActual = 0;
    private boolean isNew = false;
    //Objeto Privado
    private DefaultTableModel miTablaC;

    //Metodos
    public void setDatos(Datos datos) {
        misDatos = datos;
    }

    //Contructor
    public frmClientes() {
            setTitle("Clientes");
            setClosable(true);
            setResizable(false);
            setIconifiable(true);
            setSize(800, 650);
            setLayout(null);


        //Iconos Botones

        Icon icoBtonPrimero = new ImageIcon(getClass().getResource("/images/rewind.png"));
        Icon icoBtonAnterior = new ImageIcon(getClass().getResource("/images/last.png"));
        Icon icoBtonSiguiente = new ImageIcon(getClass().getResource("/images/next.png"));
        Icon icoBtonUltimo = new ImageIcon(getClass().getResource("/images/lastest.png"));
        Icon icoBtonNuevo = new ImageIcon(getClass().getResource("/images/new.png"));
        Icon icoBtnModificar = new ImageIcon(getClass().getResource("/images/edit.png"));
        Icon icoBtnGuardar = new ImageIcon(getClass().getResource("/images/save.png"));
        Icon icoBtnCancelar = new ImageIcon(getClass().getResource("/images/cancelformUser.png"));
        Icon icoBtnBorrar = new ImageIcon(getClass().getResource("/images/delete.png"));
        Icon icoBtnBuscar = new ImageIcon(getClass().getResource("/images/search.png"));

        //Creacion de los Objetos del Form
        //Formulario
        lbelIDCliente = new JLabel("ID Cliente: *");
        lbelIDCliente.setFont(new Font("Serif", Font.BOLD, 16));
        txtIDCliente = new JTextField(8);
        lbelTipoIdenty = new JLabel("Tipo de Identificacion: ");
        lbelTipoIdenty.setFont(new Font("Serif", Font.BOLD, 16));
        cbTipoIdentity = new JComboBox(tiposId);
        lbelNombres = new JLabel("Nombres: *");
        lbelNombres.setFont(new Font("Serif", Font.BOLD, 16));
        txtNombres = new JTextField(25);
        lbelApellidos = new JLabel("Apellidos: *");
        lbelApellidos.setFont(new Font("Serif", Font.BOLD, 16));
        txtApellidos = new JTextField(25);
        lbelDireccion = new JLabel("Direccion: *");
        lbelDireccion.setFont(new Font("Serif", Font.BOLD, 16));
        txtDireccion = new JTextField(50);
        lbelTelefono = new JLabel("Telefono: ");
        lbelTelefono.setFont(new Font("Serif", Font.BOLD, 16));
        txtTelefono = new JTextField(11);
        lbelCuidad = new JLabel("Cuidad: *");
        lbelCuidad.setFont(new Font("Serif", Font.BOLD, 16));
        cbCuidad = new JComboBox(cuidades);
        lbelFechaN = new JLabel("Fecha de Nacimiento: *");
        lbelFechaN.setFont(new Font("Serif", Font.BOLD, 16));
        dateNacimiento = new JDateChooser();
        lbelFechaIng = new JLabel("Fecha de Ingreso: *");
        lbelFechaIng.setFont(new Font("Serif", Font.BOLD, 16));
        dateIngreso = new JDateChooser();
        lbelMensaje = new JLabel("Los campos marcados con * son obligatorios");
        lbelMensaje.setFont(new Font("Serif", Font.BOLD, 16));

        //Botones
        btnPrimero = new JButton(icoBtonPrimero);
        btnAnterior = new JButton(icoBtonAnterior);
        btnSiguiente = new JButton(icoBtonSiguiente);
        btnUltimo = new JButton(icoBtonUltimo);
        btnNuevo = new JButton(icoBtonNuevo);
        btnModificar = new JButton(icoBtnModificar);
        btnGuardar = new JButton(icoBtnGuardar);
        btnCancelar = new JButton(icoBtnCancelar);
        btnBorrar = new JButton(icoBtnBorrar);
        btnBuscar = new JButton(icoBtnBuscar);

        //Tabla
        tblTable = new JTable();
        scrollTable = new JScrollPane();
        scrollTable.setViewportView(tblTable);

        //Adicion de objetos al Formulario

        //Elemetos del Formulario
        add(lbelIDCliente);
        add(txtIDCliente);
        add(lbelTipoIdenty);
        add(cbTipoIdentity);
        add(lbelNombres);
        add(txtNombres);
        add(lbelApellidos);
        add(txtApellidos);
        add(lbelDireccion);
        add(txtDireccion);
        add(lbelTelefono);
        add(txtTelefono);
        add(lbelCuidad);
        add(cbCuidad);
        add(lbelFechaN);
        add(dateNacimiento);
        add(lbelFechaIng);
        add(dateIngreso);
        add(lbelMensaje);

        //Botones del Formularios
        add(btnPrimero);
        add(btnAnterior);
        add(btnSiguiente);
        add(btnUltimo);
        add(btnNuevo);
        add(btnModificar);
        add(btnGuardar);
        add(btnCancelar);
        add(btnBorrar);
        add(btnBuscar);

        //Tabla
        add(scrollTable);

        //Propiedades de los Objetos
        btnPrimero.setToolTipText("Primera Pagina");
        btnAnterior.setToolTipText("Pagina Anterior");
        btnSiguiente.setToolTipText("Pagina Siguiente");
        btnUltimo.setToolTipText("Ultima Pagina");
        btnNuevo.setToolTipText("Nuevo Usuario");
        btnModificar.setToolTipText("Modificar Usuario");
        btnGuardar.setToolTipText("Guardar Cambios");
        btnCancelar.setToolTipText("Cancelar Cambios");
        btnBorrar.setToolTipText("Borrar Usuario");
        btnBuscar.setToolTipText("Buscar Usuario");

        //Ubicacion de los objetos en el Formulario
        lbelIDCliente.setBounds(120, 20, 110, 20);
        txtIDCliente.setBounds(230, 20, 100, 20);
        lbelTipoIdenty.setBounds(400, 20, 160, 20);
        cbTipoIdentity.setBounds(560, 20, 160, 20);

        lbelNombres.setBounds(120, 50, 110, 20);
        txtNombres.setBounds(230, 50, 370, 20);
        lbelApellidos.setBounds(120, 80, 110, 20);
        txtApellidos.setBounds(230, 80, 370, 20);

        lbelDireccion.setBounds(120, 110, 110, 20);
        txtDireccion.setBounds(230, 110, 370, 20);

        lbelTelefono.setBounds(120, 140, 100, 20);
        txtTelefono.setBounds(230, 140, 120, 20);
        lbelCuidad.setBounds(460, 140, 100, 20);
        cbCuidad.setBounds(560, 140, 160, 20);


        lbelFechaN.setBounds(120, 180, 170, 20);
        dateNacimiento.setBounds(280, 180, 130, 20);
        lbelFechaIng.setBounds(460, 180, 150, 20);
        dateIngreso.setBounds(595, 180, 130, 20);


        lbelMensaje.setBounds(120, 210, 400, 20);

        //Ubicacion de los Botones
        btnPrimero.setBounds(150, 250, 45, 45);
        btnAnterior.setBounds(200, 250, 45, 45);
        btnSiguiente.setBounds(250, 250, 45, 45);
        btnUltimo.setBounds(300, 250, 45, 45);
        btnNuevo.setBounds(350, 250, 45, 45);
        btnModificar.setBounds(400, 250, 45, 45);
        btnGuardar.setBounds(450, 250, 45, 45);
        btnCancelar.setBounds(500, 250, 45, 45);
        btnBorrar.setBounds(550, 250, 45, 45);
        btnBuscar.setBounds(600, 250, 45, 45);

        //Ubicacion de la tabla
        scrollTable.setBounds(50, 310, 700, 300);
        //Metodos


        //Eventos

        addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                formInternalOpened(e);
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {

            }
        });

        //Eventos de los Botones
        btnPrimero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonPrimeroAction(e);
            }
        });
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonAnteriorAction(e);
            }
        });
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonSiguienteAction(e);
            }
        });
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonUltimoAction(e);
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonNuevoAction(e);
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonModificarAction(e);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonGuardarAction(e);
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonCancelarAction(e);
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonBorrarAction(e);
            }
        });
        btnBuscar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btonBuscarAction(e);
            }
        });

    }

    public String tipoId(int id) {
        switch (id) {
            case 0:
                return "No.Cedula";

            case 1:
                return "Tarjeta de Identidad";

            case 2:
                return "DNI";
            case 3:

                return "Pasaporte";
            case 4:

                return "Seguro Social";

            default:
                return "Desconocido";

        }
    }

    public String cuidad(int id) {
        switch (id) {
            case 0:
                return "Santo Domingo";
            case 1:
                return "Santiago";
            case 2:
                return "La Vega";
            case 3:
                return "Constanza";
            case 4:
                return "San Francisco de Macoris";
            case 5:
                return "San Juan de la Maguana";
            default:
                return "Desconocido";
        }
    }


    private void formInternalOpened(InternalFrameEvent e) {
        cargarTabla();
        mostrarRegistro();
        deshabilidarCampos();

    }

    private void cargarTabla() {
        String titulos[] = {"ID", "Tipo ID ", "Nombres", "Apellidos", "Telefono", "Direccion", "Cuidad",
                "Fecha de Ingreso"};
        String registro[] = new String[9];
        miTablaC = new DefaultTableModel(null, titulos);
        for (int i = 0; i < misDatos.getnumeroClientes(); i++) {
            registro[0] = misDatos.getMyClientes()[i].getIdCliente();
            registro[1] = tipoId(misDatos.getMyClientes()[i].getTipoIdenty());
            registro[2] = misDatos.getMyClientes()[i].getNombres();
            registro[3] = misDatos.getMyClientes()[i].getApellidos();
            registro[4] = misDatos.getMyClientes()[i].getTelefono();
            registro[5] = misDatos.getMyClientes()[i].getDireccion();
            registro[6] = cuidad(misDatos.getMyClientes()[i].getCuidad());
            registro[7] = "" + misDatos.getMyClientes()[i].getFechaIngreso();
            miTablaC.addRow(registro);
        }
        tblTable.setModel(miTablaC);
    }

    private void mostrarRegistro() {
        txtIDCliente.setText(misDatos.getMyClientes()[clientActual].getIdCliente());
        cbTipoIdentity.setSelectedIndex(misDatos.getMyClientes()[clientActual].getTipoIdenty());
        txtNombres.setText(misDatos.getMyClientes()[clientActual].getNombres());
        txtApellidos.setText(misDatos.getMyClientes()[clientActual].getApellidos());
        txtTelefono.setText(misDatos.getMyClientes()[clientActual].getTelefono());
        txtDireccion.setText(misDatos.getMyClientes()[clientActual].getDireccion());
        cbCuidad.setSelectedIndex(misDatos.getMyClientes()[clientActual].getCuidad());
        dateIngreso.setDate(misDatos.getMyClientes()[clientActual].getFechaIngreso());
        dateNacimiento.setDate(misDatos.getMyClientes()[clientActual].getFechaNacimiento());

    }

    private void deshabilidarCampos() {
        //Desabilitar Campos
        txtIDCliente.setEnabled(false);
        cbTipoIdentity.setEnabled(false);
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        cbCuidad.setEnabled(false);
        dateIngreso.setEnabled(false);
        dateNacimiento.setEnabled(false);
        //Desabilitar Botones
        btnPrimero.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBorrar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }

    private void habilitarCampos() {
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnBuscar.setEnabled(false);

        txtIDCliente.setEnabled(true);
        cbTipoIdentity.setEnabled(true);
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        cbCuidad.setEnabled(true);
        dateIngreso.setEnabled(true);
        dateNacimiento.setEnabled(true);
    }

    private void limpiarCampos() {
        txtIDCliente.setText("");
        cbTipoIdentity.setSelectedIndex(-1);
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cbCuidad.setSelectedIndex(-1);
        dateIngreso.setDate(null);
        dateNacimiento.setDate(null);

    }


    private void btonPrimeroAction(ActionEvent e) {

    }

    private void btonAnteriorAction(ActionEvent e) {

    }

    private void btonSiguienteAction(ActionEvent e) {

    }

    private void btonUltimoAction(ActionEvent e) {
    }

    private void btonNuevoAction(ActionEvent e) {

    }

    private void btonModificarAction(ActionEvent e) {
    }

    private void btonGuardarAction(ActionEvent e) {
    }

    private void btonCancelarAction(ActionEvent e) {
    }

    private void btonBorrarAction(ActionEvent e) {
    }

    private void btonBuscarAction(ActionEvent e) {
    }


}


