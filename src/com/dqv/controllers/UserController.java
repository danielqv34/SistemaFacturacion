package com.dqv.controllers;

/**
 * Created by ezequ on 10/2/2016.
 */
public class UserController {

    public boolean validaUsuario(String user, String pass){
        if (user.equalsIgnoreCase("daniel") && pass.equalsIgnoreCase("abc")){
            return true;
        }else{
            return true;
        }
    }
}
