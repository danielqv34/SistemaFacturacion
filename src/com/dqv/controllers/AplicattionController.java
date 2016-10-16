package com.dqv.controllers;



/**
 * Created by DanielQuirozV on 10/31/2015.
 */


public class AplicattionController {
    public boolean validarUsuario(String nombre, String contrasenia) {
        if (nombre.equals("daniel") && contrasenia.equals("abc123")) {
            return true;
        } else {
            return false;
        }
    }


}

