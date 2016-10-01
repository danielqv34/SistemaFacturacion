package Formularios;

import Clases.AplicattionController;
import Clases.Datos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DanielQuirozV on 10/21/2015.
 */
public class frmLogin extends JFrame{
    //Objetos del Formulario

    private JLabel lblUsuario;
    private JLabel lblPass;
    private JLabel lblImg;
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private JButton bAceptar;
    private JButton bCancelar;
    //Atributos
    private  Datos misDatos;

    public void setDatosControllerLogin(AplicattionController datosControllerLogin) {
        this.datosControllerLogin = datosControllerLogin;
    }

    private AplicattionController datosControllerLogin;

    //Metodos
    public void setDatos(Datos datos){
        misDatos = datos;
    }


    //Constructor
    public frmLogin(){
        //Propiedades del Formulario
        setTitle("Ingresar al Sistema");
        setResizable(false);
        setSize(500,200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Iconos
        Icon icoAceptar = new ImageIcon(getClass().getResource("/images/accept.png"));
        Icon icoCancel = new ImageIcon(getClass().getResource("/images/cancel.png"));
        Icon iconAdmin = new ImageIcon(getClass().getResource("/images/login.png"));

        //Creo objetos del Formulario
        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(10);
        lblPass = new JLabel("Contraseña:");
        txtPass = new JPasswordField(10);
        bAceptar = new JButton(icoAceptar);
        bCancelar = new JButton(icoCancel);
        lblImg = new JLabel(iconAdmin);
        //Propiedades de los Objetos
        bAceptar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        bAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
        bAceptar.setToolTipText("Ingresa al Sistema");

        bCancelar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        bCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        bCancelar.setToolTipText("Cancelar Operacion");

        //Adicion de Objetos al Formulario
        add(lblUsuario);
        add(txtUsuario);
        add(lblPass);
        add(txtPass);
        add("Ingresar",bAceptar);
        add("Cancelar",bCancelar);
        add(lblImg);

        //Ubicacion de Obejtos en el Form;

        lblUsuario.setBounds (20,20,120,20);
        txtUsuario.setBounds (120,20,150,20);
        lblImg.setBounds (300,20,128,128);

        lblPass.setBounds(20,45,100,20);
        txtPass.setBounds(120,45,150,20);

        bAceptar.setBounds(20,80,100,50);
        bCancelar.setBounds(130,80,100,50);


        //Event Listeners
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bAceptarAction(e);
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bCancelarAction(e);
            }
        });


    }
    private void bAceptarAction(ActionEvent event){
        //Valido que el usuario existe
        if(!datosControllerLogin.validarUsuario(txtUsuario.getText(), new String(txtPass.getPassword()))){
            JOptionPane.showMessageDialog(rootPane,"Usuario o Contraseña son incorrectos");
            txtUsuario.setText("");
            txtPass.setText("");
            txtUsuario.requestFocusInWindow();
            txtPass.requestFocusInWindow();
            return;
        }
        //Si la validacion es correcta
        frmPrincipal miFirst = new frmPrincipal();
        setVisible(false);
        miFirst.setDatos(misDatos);
        miFirst.setDatosController(datosControllerLogin);
        miFirst.setExtendedState(JFrame.MAXIMIZED_BOTH);
        miFirst.setVisible(true);


    }
    private  void bCancelarAction(ActionEvent event){
        System.exit(0);
    }

}
