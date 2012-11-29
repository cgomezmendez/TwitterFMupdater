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
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.StatusUpdate;

/**
 *
 * @author cgomezmendez
 */
public class ActualizadorController implements Runnable{

    @Override
    public void run() {
        try {
            MainWindowView ventana = new MainWindowView();
            Image icon = Toolkit.getDefaultToolkit().createImage("tray.png");
            ventana.setVisible(true);
            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("tray.png"));
            trayIcon.setImageAutoSize(true);
            ventana.setIconImage(icon);
            SystemTray.getSystemTray().add(trayIcon);
            while (true){
                ArrayList resultados;
                XmlModel xml = new XmlModel("NowOnAir.xml");
                resultados = xml.obtenerInfo();
                String tituloCancion =(String) resultados.get(0);
                String nombreArtista =(String) resultados.get(1);
                String mensaje =  "ahora suena";
                TwitterModel twitter = new TwitterModel();
                String estadoString = mensaje+" "+tituloCancion+" "+nombreArtista;
                StatusUpdate actualizacionEstado = new StatusUpdate(estadoString); 
               twitter.actualizarEstado(actualizacionEstado); 
            }
        } catch (AWTException ex) {
            Logger.getLogger(ActualizadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
