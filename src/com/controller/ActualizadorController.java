/*
 * 
 * 
 */
package com.controller;

import com.model.TwitterModel;
import com.model.XmlModel;
import com.view.MainWindowView;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.StatusUpdate;

/**
 *
 * @author cgomezmendez
 */
public class ActualizadorController implements Runnable{
private static boolean correr = true;
MensajesController mensajes = new MensajesController();

    public static boolean isCorrer() {
        return correr;
    }

    public static void setCorrer(boolean aCorrer) {
        correr = aCorrer;
    }
    @Override
    public void run() {
        while (true){
            while (correr==true){
                ArrayList resultados;
                XmlModel xml = new XmlModel("NowOnAir.xml");
                resultados = xml.obtenerInfo();
                String tituloCancion =(String) resultados.get(0);
                String nombreArtista =(String) resultados.get(1);
                TwitterModel twitter = new TwitterModel();
                List<String> mensajesObtenidos = mensajes.obtenerDesdeBD();
                String mensajeAntesCancion = mensajesObtenidos.get(1);
                String mensajeAntesArtista = mensajesObtenidos.get(0);
                String mensajeFinal = mensajesObtenidos.get(2);
                String estadoString = mensajeAntesCancion+" "+tituloCancion+" "+mensajeAntesArtista+" "+nombreArtista+" "+mensajeFinal;
                StatusUpdate actualizacionEstado = new StatusUpdate(estadoString); 
               twitter.actualizarEstado(actualizacionEstado); 
               System.out.println(estadoString);
            }
            while (correr!=true){
            
            }
        }
    }
    
}
