package Clases;

import javax.swing.*;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by DanielQuirozV on 10/21/2015.
 */
public class Datos {
    //Atributos
    private int MaxUser = 50;
    private Usuario myUsers[] = new Usuario[MaxUser];
    private int contUser = 0;

    private int MaxClients = 150;
    private Clientes myClientes[] = new Clientes[MaxClients];
    private int contClients = 0;


    private int MaxProducts = 500;
    private Productos myProducts[] = new Productos[MaxProducts];
    private  int contProdutcs = 0;


    public  Datos() {
        //Llamo a lso metodos  para mostrarlos en las tablas
       //El metodo Cargar usuaruios muestra todos los usuarios en la tabla Usuarios
        cargarUsuarios();
        //El metodo Cargar clientes muestra todos los Clientes en la tabla Clientes
        cargarClientes();

    }


    public boolean validarUsuario(String usuario, String pass) {
        if (usuario.equalsIgnoreCase("Daniel") && pass.equals("abc123") || (usuario.equalsIgnoreCase("Massiel")
                && pass.equals("abc123"))) {
            return true;
        } else {
            return false;
        }
    }
  //Usuarios
    private void cargarUsuarios() {
        //El metodo Cargar Usuarios para crear los usuarios
        Usuario miUsuario;

        miUsuario = new Usuario("001", "Daniel", "Quiroz", "abc123", 0);
        myUsers[contUser] = miUsuario;
        contUser++;

        miUsuario = new Usuario("002", "Massiel", "Quiroz", "abc123", 1);
        myUsers[contUser] = miUsuario;
        contUser++;

        miUsuario = new Usuario("003", "Carlos", "Quiroz", "abc123", 1);
        myUsers[contUser] = miUsuario;
        contUser++;
    }

    public int getnumeroUsuarios() {
        return contUser;
    }
    public Usuario[] getUsuarios() {
        return myUsers;
    }

    //For para capturar del Usuario en el arreglo myUser , si lo encuentra devuelve la posicion si no devuelve -1
    public int posicionUsuario(String idUsuario) {
        for (int i = 0; i < contUser; i++) {
            if (myUsers[i].getIdUsuario().equals(idUsuario))
                return i;

        }
        return -1;
    }

  //Metodo para crear Nuevos Usuarios
    public String nuevoUsuarios(Usuario newUser) {
        if (contUser == MaxUser) {
            return ("Numero maximo de usuarios alcanzado");
        }
        myUsers[contUser] = newUser;
        contUser++;

        return "Usuario Agregado Correctamente";
    }
    public String modficarUsuarios(Usuario miUsuario,int pos){
        myUsers[pos].setPerfil(miUsuario.getPerfil());
        myUsers[pos].setNombres(miUsuario.getNombres());
        myUsers[pos].setApellidos(miUsuario.getApellidos());
        myUsers[pos].setClave(miUsuario.getClave());

        return " Datos del usuario Modificados Correctamente";
    }
    public String eliminarUsuarios(int pos){
        for(int i = pos; i < contUser -1; i++){
            //Aqui estoy pasando los eventos
         myUsers[i] = myUsers[i + 1];
        }
        contUser--;
        return  "Usuario Eliminado Correctamente";
    }

    //Clientes

    private void cargarClientes(){
     Clientes miClient;

        miClient = new Clientes("001",0,"Juan A.","Peña Rodriguez","c/ Santiago ,Gazcue","809-539-1002",0,
                new Date(1995,8,28), new Date(2015,11,29));
        myClientes[contClients] = miClient;
        contClients++;

        miClient = new Clientes("002",2," Antonio."," Rodriguez","c/ Uruguay ,Gazcue","809-539-1003",3,
                new Date(1995,8,28), new Date(2015,11,29));
        myClientes[contClients] = miClient;

        miClient = new Clientes("003",1,"Ana","Valdez Rodriguez","av/ Bolivar ,Gazcue","809-539-1202",2,
                new Date(1995,8,28), new Date(2015,11,29));
        myClientes[contClients] = miClient;
        contClients++;

        miClient = new Clientes("004",1,"Altagracia","Valdez ","av/ Bolivar ,Gazcue","809-539-1202",4,
                new Date(1995,8,28), new Date(2015,11,29));
        myClientes[contClients] = miClient;
        contClients++;

        miClient = new Clientes("005",0,"Carlos","Quiroz","av/ Gregoio Luperon","809-539-1202",2,
                new Date(1995,8,28), new Date(2015,11,29));
        myClientes[contClients] = miClient;
        contClients++;

    }
    public int getnumeroClientes(){
        return contClients;
    }
    public Clientes [] getMyClientes(){
        return  myClientes;
    }
    //For para capturar del Usuario en el arreglo MyClients , si lo encuentra devuelve la posicion si no devuelve -1

    public int posicionCliente(String idCliente) {
        for (int i = 0; i < contClients; i++) {
            if (myClientes[i].getIdCliente().equals(idCliente))
                return i;

        }
        return -1;
    }
    public String nuevoCliente(Clientes newClient) {
        if (contClients == MaxClients) {
            return ("Numero maximo de Clientes alcanzado");
        }
        myClientes[contClients] = newClient;
        contClients++;

        return "Cliente Agregado Correctamente";
    }
    public String modficarClientes(Clientes myCLient,int pos){
        myClientes[pos].setTipoIdenty(myCLient.getTipoIdenty());
        myClientes[pos].setNombres(myCLient.getNombres());
        myClientes[pos].setApellidos(myCLient.getApellidos());
        myClientes[pos].setDireccion(myCLient.getDireccion());
        myClientes[pos].setCuidad(myCLient.getCuidad());
        myClientes[pos].setFechaIngreso(myCLient.getFechaIngreso());

        return " Datos del Cliente Modificados Correctamente";
    }
    public String eliminarCliente(int pos){
        for(int i = pos; i < contClients -1; i++){
            //Aqui estoy pasando los eventos
            myClientes[i] = myClientes[i + 1];
        }
        contClients--;
        return  "Cliente Eliminado Correctamente";
    }


}
