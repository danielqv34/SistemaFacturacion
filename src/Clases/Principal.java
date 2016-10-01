package Clases;
import  Formularios.frmLogin;

import javax.swing.*;

/**
 * Created by DanielQuirozV on 10/21/2015.
 */
public class Principal {
    public static  void main (String agrs[]){
        Datos misDatos = new Datos();//Creacion del Objeto Datos//Pasamos un obejto de una clase a otra como un atributo
        AplicattionController datosController = new AplicattionController();
        frmLogin FormLogin = new frmLogin();
        FormLogin.setDatos(misDatos);//El formulario Datos se lo paso al Login
        FormLogin.setVisible(true);
        FormLogin.setLocationRelativeTo(null);
    }
}
