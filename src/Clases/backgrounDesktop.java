package Clases;

/**
 * Created by DanielQuirozV on 10/24/2015.
 */
import  java.awt.Graphics;
import  java.awt.Image;
import  javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class backgrounDesktop extends JDesktopPane{

    private Image imagen;

    public backgrounDesktop(){

    }
    public backgrounDesktop(String nombreImagen){
        if(nombreImagen !=null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        }
    }
    public backgrounDesktop(Image imagenInicial){
        if(imagenInicial !=null){
            imagen = imagenInicial;
        }
    }
    public  void setImagen(String nombreImagen){
        if(nombreImagen != null){
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        }else {
            imagen= null;
        }
        repaint();
    }
    @Override
    public void paint(Graphics g){
        if(imagen !=null){
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
        }else{
            setOpaque(true);
        }
           super.paint(g);
    }

}