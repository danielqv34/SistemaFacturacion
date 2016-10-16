package com.dqv.forms;

import com.dqv.controllers.AplicattionController;
import com.dqv.clases.Datos;
import com.dqv.clases.backgrounDesktop;
import com.dqv.controllers.UserController;
import com.dqv.entities.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DanielQuirozV on 10/21/2015.
 */
public class frmPrincipal extends JFrame {
    //Objetos
    private JMenuBar menuFact;
    private JMenu menuArchivo;
    private JMenu menuMovimiento;
    private JMenu menuAyuda;
    //Menu Archivos
    private JMenuItem mnuArchivoClientes;
    private JMenuItem mnuArchivoProductos;
    private JMenuItem mnuArchivoUsuarios;
    private JSeparator mnuArchivoSeparador1;
    private JMenuItem mnuArchivoCambioClave;
    private JMenuItem mnuArchivoCambioUsuario;
    private JSeparator mnuArchivoSeparado2;
    private JMenuItem mnuArchivoSalir;
    //Menu Movimientos
    private JMenuItem menuMovimientoNuevaFactura;
    private JMenuItem menuMovimientoReporteFacturas;
    //Menu Ayuda
    private JMenuItem menuAyudaAcercaDe;
    private JMenuItem menuAyudaHelp;

    private JDesktopPane DpEscritorio;

    //Atributos
    private Datos misDatos;
    private UserController userController;



    private Usuario usuario;


    //Constructor
    public frmPrincipal() {
        //Propieades del Formulario
        setTitle("Sistema de Facturacion");
        setResizable(true);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Iconos Menu Principal
        Icon icoArchivo = new ImageIcon(getClass().getResource("/com/dqv/images/file.png"));
        Icon icoMovimientos = new ImageIcon(getClass().getResource("/com/dqv/images/movement.png"));
        Icon icoAyuda = new ImageIcon(getClass().getResource("/com/dqv/images/help.png"));

        //Iconos Menu Archivo
        Icon icoClientes = new ImageIcon(getClass().getResource("/com/dqv/images/client.png"));
        Icon icoProductos = new ImageIcon(getClass().getResource("/com/dqv/images/products.png"));
        Icon icoUsuarios = new ImageIcon(getClass().getResource("/com/dqv/images/user.png"));
        Icon icoClave = new ImageIcon(getClass().getResource("/com/dqv/images/password.png"));
        Icon icoCambioUser = new ImageIcon(getClass().getResource("/com/dqv/images/userChange.png"));
        Icon icoSalir = new ImageIcon(getClass().getResource("/com/dqv/images/exit.png"));

        //Iconos Menu Movimientos
        Icon icoNuevaFacutra = new ImageIcon(getClass().getResource("/com/dqv/images/newbill.png"));
        Icon icoReporteFactura = new ImageIcon(getClass().getResource("/com/dqv/images/report.png"));

        //Iconos Menu Ayuda
        Icon icoAcercaDe = new ImageIcon(getClass().getResource("/com/dqv/images/about.png"));
        Icon icoHelp = new ImageIcon(getClass().getResource("/com/dqv/images/info.png"));


        //Creacion de Objetos

        menuFact = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuMovimiento = new JMenu("Movimientos");
        menuAyuda = new JMenu("Ayuda");

        //Menu Archivo
        mnuArchivoClientes = new JMenuItem("Clientes");
        mnuArchivoProductos = new JMenuItem("Productos");
        mnuArchivoSeparador1 = new JSeparator();
        mnuArchivoUsuarios = new JMenuItem("Usuarios");
        mnuArchivoCambioClave = new JMenuItem("Cambio de Clave");
        mnuArchivoCambioUsuario = new JMenuItem("Cambio de Usuario");
        mnuArchivoSeparado2 = new JSeparator();
        mnuArchivoSalir = new JMenuItem("Salir");
        //Menu Movimiento
        menuMovimientoNuevaFactura = new JMenuItem("Nueva Factura");
        menuMovimientoReporteFacturas = new JMenuItem("Reporte de Facturas");
        //Menu Movimiento
        menuAyudaAcercaDe = new JMenuItem("Acerca de");
        menuAyudaHelp = new JMenuItem("Ayuda");
        DpEscritorio = new backgrounDesktop();

        //Imagen al Desktop
        ((backgrounDesktop) DpEscritorio).setImagen("/com/dqv/images/background.jpg");

        //Adicion deIconos
        menuArchivo.setIcon(icoArchivo);
        menuMovimiento.setIcon(icoMovimientos);
        menuAyuda.setIcon(icoAyuda);
        //Menu Archivo
        mnuArchivoClientes.setIcon(icoClientes);
        mnuArchivoProductos.setIcon(icoProductos);
        mnuArchivoUsuarios.setIcon(icoUsuarios);
        mnuArchivoCambioClave.setIcon(icoClave);
        mnuArchivoCambioUsuario.setIcon(icoCambioUser);
        mnuArchivoSalir.setIcon(icoSalir);
        //Menu Movimiento
        menuMovimientoNuevaFactura.setIcon(icoNuevaFacutra);
        menuMovimientoReporteFacturas.setIcon(icoReporteFactura);
        //Menu Movimiento
        menuAyudaAcercaDe.setIcon(icoAcercaDe);
        menuAyudaHelp.setIcon(icoHelp);

        //Adicion de menu Archivos
        menuArchivo.add(mnuArchivoClientes);
        menuArchivo.add(mnuArchivoProductos);
        menuArchivo.add(mnuArchivoSeparador1);
        menuArchivo.add(mnuArchivoUsuarios);
        menuArchivo.add(mnuArchivoCambioClave);
        menuArchivo.add(mnuArchivoCambioUsuario);
        menuArchivo.add(mnuArchivoSeparado2);
        menuArchivo.add(mnuArchivoSalir);
        menuFact.add(menuArchivo);
        //Adicion de menu Movimientos
        menuMovimiento.add(menuMovimientoNuevaFactura);
        menuMovimiento.add(menuMovimientoReporteFacturas);
        menuFact.add(menuMovimiento);
        //Adicion de menu Ayuda
        menuAyuda.add(menuAyudaAcercaDe);
        menuAyuda.add(menuAyudaHelp);
        menuFact.add(menuAyuda);

        setJMenuBar(menuFact);
        setContentPane(DpEscritorio);

        //Eventos de los Menus
        mnuArchivoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAClientesAction(e);
            }
        });
        mnuArchivoProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAProductosAction(e);
            }
        });
        mnuArchivoUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAUsuariosAction(e);
            }
        });
        mnuArchivoCambioClave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAChangePassAction(e);
            }
        });
        mnuArchivoCambioUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAChangeUserAction(e);
            }
        });
        mnuArchivoSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAExitAction(e);
            }
        });

        menuMovimientoNuevaFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMNuevaFacturaAction(e);
            }
        });
        menuMovimientoReporteFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMReporteAction(e);
            }
        });

        menuAyudaAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAAboutAction(e);
            }
        });
        menuAyudaHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAHelpAction(e);
            }
        });

    }

    //Eventos por cada Menu
    private void menuAClientesAction(ActionEvent e) {
        //Ventana Clientes
        frmClientes myClients = new frmClientes();
        DpEscritorio.add(myClients);
        myClients.setDatos(misDatos);
        myClients.show();
    }

    private void menuAProductosAction(ActionEvent e) {
        //Ventana Productos
        frmProductos myProducts = new frmProductos();
        DpEscritorio.add(myProducts);
        myProducts.show();
    }

    //Eventos del Formulario del frmUsuarios
    private void menuAUsuariosAction(ActionEvent e) {
        //Ventana Usuarios
        frmUsuarios myUsers = new frmUsuarios();
        DpEscritorio.add(myUsers);
        myUsers.setDatos(misDatos);//Antes de mostrar al frmPrincipal le paso el metodo y el obejto
        myUsers.show();
    }

    private void menuAChangePassAction(ActionEvent e) {
        //Cambio de Contraseña
        frmCambioClave changePass = new frmCambioClave();
        DpEscritorio.add(changePass);
        changePass.show();
    }

    private void menuAChangeUserAction(ActionEvent e) {
        //Cambio de Usuario
        frmCambioUser changeUser = new frmCambioUser();
        DpEscritorio.add(changeUser);
        changeUser.show();

    }

    private void menuAExitAction(ActionEvent e) {
        //Termina la aplicacion
        System.exit(0);
    }

    private void menuMNuevaFacturaAction(ActionEvent e) {

    }

    private void menuMReporteAction(ActionEvent e) {

    }

    private void menuAAboutAction(ActionEvent e) {

    }

    private void menuAHelpAction(ActionEvent e) {

    }



    //Metodos SET
    public void setDatos(Datos datos) {
        misDatos = datos;
    }

    public void setDatosController(UserController datosController) {
        this.userController = datosController;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
