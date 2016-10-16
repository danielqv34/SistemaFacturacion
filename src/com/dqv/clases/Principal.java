package com.dqv.clases;
import com.dqv.controllers.AplicattionController;
import com.dqv.controllers.UserController;
import com.dqv.forms.frmLogin;

/**
 * Created by DanielQuirozV on 10/21/2015.
 */
public class Principal {
    public static  void main (String agrs[]){
        Datos misDatos = new Datos();//Creacion del Objeto Datos//Pasamos un obejto de una clase a otra como un atributo
        UserController datosController = new UserController();


        frmLogin FormLogin = new frmLogin();
        FormLogin.setUserController(datosController);//El formulario Datos se lo paso al Login
        FormLogin.setVisible(true);
        FormLogin.setLocationRelativeTo(null);

    }
}
