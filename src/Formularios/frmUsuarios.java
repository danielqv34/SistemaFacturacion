package Formularios;

import Clases.Datos;
import Clases.Usuario;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.out;

/**
 * Created by DanielQuirozV on 10/23/2015.
 */
public class frmUsuarios extends JInternalFrame {
    //Objetos Label
    private JLabel lbelIdUsuario;
    private JLabel lbelPerfl;
    private JLabel lbelNombres;
    private JLabel lbelApellidos;
    private JLabel lbelPassword;
    private JLabel lbelConfirmacion;
    private JLabel lbelMensaje;

    //Objetos TextFields
    private JTextField txtIDUsuarios;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmacionP;
    //ComboBox
    private JComboBox cbPerfil;

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
    private String perfiles[] = {"Administrador", "Empleado"};

    //Atributos
    private Datos misDatos;
    private int userActual = 0;
    private boolean isNew = false;
    //Objeto Privado
    private DefaultTableModel miTabla;

    //Metodos
    public void setDatos(Datos datos) {
        misDatos = datos;
    }

    //Contructor
    public frmUsuarios() {
        //Atributos del Form Usuarios

        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setTitle("Usuarios");
        setLayout(null);
        setSize(800, 500);

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
        lbelIdUsuario = new JLabel("ID Usuario: *");
        txtIDUsuarios = new JTextField(7);
        lbelPerfl = new JLabel("Perfil:");
        cbPerfil = new JComboBox(perfiles);
        lbelNombres = new JLabel("Nombres: *");
        txtNombres = new JTextField(25);
        lbelApellidos = new JLabel("Apellidos: *");
        txtApellidos = new JTextField(25);
        lbelPassword = new JLabel("Contraseña: *");
        txtPassword = new JPasswordField(11);
        lbelConfirmacion = new JLabel("Confirmar: *");
        txtConfirmacionP = new JPasswordField(11);
        lbelMensaje = new JLabel("Los campos marcados con * son obligatorios");

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
        add(lbelIdUsuario);
        add(txtIDUsuarios);
        add(lbelPerfl);
        add(cbPerfil);
        add(lbelNombres);
        add(txtNombres);
        add(lbelApellidos);
        add(txtApellidos);
        add(lbelPassword);
        add(txtPassword);
        add(lbelConfirmacion);
        add(txtConfirmacionP);
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
        lbelIdUsuario.setBounds(120, 20, 110, 20);
        txtIDUsuarios.setBounds(230, 20, 100, 20);
        lbelPerfl.setBounds(400, 20, 120, 20);
        cbPerfil.setBounds(480, 20, 120, 20);
        lbelNombres.setBounds(120, 50, 110, 20);
        txtNombres.setBounds(230, 50, 370, 20);
        lbelApellidos.setBounds(120, 80, 110, 20);
        txtApellidos.setBounds(230, 80, 370, 20);
        lbelPassword.setBounds(120, 110, 110, 20);
        txtPassword.setBounds(230, 110, 100, 20);
        lbelConfirmacion.setBounds(400, 110, 120, 20);
        txtConfirmacionP.setBounds(480, 110, 100, 20);
        lbelMensaje.setBounds(120, 150, 400, 20);

        //Ubicacion de los Botones
        btnPrimero.setBounds(110, 175, 45, 45);
        btnAnterior.setBounds(160, 175, 45, 45);
        btnSiguiente.setBounds(210, 175, 45, 45);
        btnUltimo.setBounds(260, 175, 45, 45);
        btnNuevo.setBounds(310, 175, 45, 45);
        btnModificar.setBounds(360, 175, 45, 45);
        btnGuardar.setBounds(410, 175, 45, 45);
        btnCancelar.setBounds(460, 175, 45, 45);
        btnBorrar.setBounds(510, 175, 45, 45);
        btnBuscar.setBounds(560, 175, 45, 45);

        //Ubicacion de la tabla
        scrollTable.setBounds(110, 240, 500, 200);

        //Eventos Internos del Formulario
        //Interface
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
        //Eventos de los botones

        btnPrimero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPrimeroAction(e);
            }
        });
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAnteriorAction(e);
            }
        });
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSiguienteAction(e);
            }
        });
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUltimoAction(e);
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNuevoAction(e);
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnModificarAction(e);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardarAction(e);
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarAction(e);
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBorrarAction(e);
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuscarAction(e);
            }
        });

    }

    private void formInternalOpened(InternalFrameEvent e) {
        cargarTabla();
        mostrarRegistro();
        deshabilidarCampos();
    }

    private void cargarTabla() {
        String titulos[] = {"ID", "Perfil", "Nombres", "Apellidos",};
        String registro[] = new String[4];
        miTabla = new DefaultTableModel(null, titulos);
        for (int i = 0; i < misDatos.getnumeroUsuarios(); i++) {
            registro[0] = misDatos.getUsuarios()[i].getIdUsuario();
            registro[1] = perfil(misDatos.getUsuarios()[i].getPerfil());
            registro[2] = misDatos.getUsuarios()[i].getNombres();
            registro[3] = misDatos.getUsuarios()[i].getApellidos();
            miTabla.addRow(registro);
        }
        tblTable.setModel(miTabla);
    }

    private void mostrarRegistro() {
        txtIDUsuarios.setText(misDatos.getUsuarios()[userActual].getIdUsuario());
        cbPerfil.setSelectedIndex(misDatos.getUsuarios()[userActual].getPerfil());
        txtNombres.setText(misDatos.getUsuarios()[userActual].getNombres());
        txtApellidos.setText(misDatos.getUsuarios()[userActual].getApellidos());
        txtPassword.setText(misDatos.getUsuarios()[userActual].getClave());
        txtConfirmacionP.setText(misDatos.getUsuarios()[userActual].getClave());
    }

    private String perfil(int id) {
        if (id == 0) {
            return "Administrador";
        } else if (id == 1) {
            return "Empleado";
        } else {
            return "Desconocido";
        }
    }

    private void deshabilidarCampos() {
        //Desabilitar Campos
        txtIDUsuarios.setEnabled(false);
        cbPerfil.setEnabled(false);
        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);
        txtPassword.setEnabled(false);
        txtConfirmacionP.setEnabled(false);
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

        cbPerfil.setEnabled(true);
        txtNombres.setEnabled(true);
        txtApellidos.setEnabled(true);
        txtPassword.setEnabled(true);
        txtConfirmacionP.setEnabled(true);
    }

    private void limpiarCampos() {
        cbPerfil.setSelectedIndex(-1);
        txtIDUsuarios.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtPassword.setText("");
        txtConfirmacionP.setText("");
    }

    private void btnPrimeroAction(ActionEvent e) {
        userActual = 0;
        mostrarRegistro();
    }

    private void btnAnteriorAction(ActionEvent e) {
        if (userActual == 0)
            return;
        userActual--;
        mostrarRegistro();
    }

    private void btnSiguienteAction(ActionEvent e) {
        if (userActual == misDatos.getnumeroUsuarios() - 1)
            return;
        userActual++;
        mostrarRegistro();
    }

    private void btnUltimoAction(ActionEvent e) {
        userActual = misDatos.getnumeroUsuarios() - 1;
        mostrarRegistro();
    }

    private void btnNuevoAction(ActionEvent e) {
        txtIDUsuarios.setEnabled(true);
        txtIDUsuarios.requestFocusInWindow();
        txtIDUsuarios.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtPassword.setText("");
        txtConfirmacionP.setText("");
        habilitarCampos();
        isNew = true;
    }

    private void btnModificarAction(ActionEvent e) {
        habilitarCampos();
        txtIDUsuarios.setEnabled(false);
        cbPerfil.requestFocusInWindow();
        isNew = false;
    }

    private void btnGuardarAction(ActionEvent e) {
        if (txtIDUsuarios.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID de usuario");
            txtIDUsuarios.requestFocusInWindow();
            return;
        }

        if (txtNombres.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El usuario debe tener al menos un Nombre y un Apellido");
            txtNombres.requestFocusInWindow();
            return;

        } else if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "El usuario debe tener al menos un Nombre y un Apellido");
            txtApellidos.requestFocusInWindow();
        }

        String password = String.valueOf(txtPassword.getPassword());
        String paswordP = String.valueOf(txtConfirmacionP.getPassword());

        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe crear una contraseña");
            txtPassword.requestFocusInWindow();
            return;
        } else if (paswordP.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una clave de confirmacion");
            txtConfirmacionP.requestFocusInWindow();
            return;
        }
        if (!password.equals(paswordP)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            txtPassword.requestFocusInWindow();
            txtConfirmacionP.requestFocusInWindow();
            txtPassword.setText("");
            txtConfirmacionP.setText("");
            return;

        }
        int pos = misDatos.posicionUsuario(txtIDUsuarios.getText());
        if (isNew && pos != -1) {
            JOptionPane.showMessageDialog(this, "Usuario ya existe");
            txtIDUsuarios.requestFocusInWindow();
            return;


        }
        Usuario newUser = new Usuario(txtIDUsuarios.getText(), txtNombres.getText(), txtApellidos.getText()
                , password, cbPerfil.getSelectedIndex());

        String mensaje = "";
        if (isNew) {
            mensaje = misDatos.nuevoUsuarios(newUser);

        } else {
            mensaje = misDatos.modficarUsuarios(newUser, pos);
        }
        JOptionPane.showMessageDialog(this, mensaje);
        cargarTabla();
        deshabilidarCampos();


        deshabilidarCampos();
        limpiarCampos();
    }

    private void btnCancelarAction(ActionEvent e) {

        mostrarRegistro();
        limpiarCampos();
        deshabilidarCampos();
    }

    private void btnBorrarAction(ActionEvent e) {
        int rta = JOptionPane.showConfirmDialog(this, "Estas seguro de que deseas borrar el Usuario ?");
        if (rta != 0)
            return;
        String msg = misDatos.eliminarUsuarios(userActual);
        JOptionPane.showMessageDialog(this, msg);
        userActual = 0;
        cargarTabla();
        mostrarRegistro();


    }

    private void btnBuscarAction(ActionEvent e) {
        String idUsuario = JOptionPane.showInputDialog(this, "Ingrese el ID del usuario que desea buscar: ");
        if (idUsuario.equals("")) {
            return;
        }
        int pos = misDatos.posicionUsuario(idUsuario);
        if (pos == -1) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            return;
        }
        userActual = pos;
        mostrarRegistro();
    }
}
