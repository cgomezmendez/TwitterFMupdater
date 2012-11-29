package com;



import com.controller.ActualizadorController;
import com.view.MainWindowView;
import entity.App;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/*
 * 
 * 
 */

/**
 *
 * @author cgomezmendez
 */
public class Main {
    private static ActualizadorController actualizador;
    private static MainWindowView ventana;
    public static void main(String... args){
            ventana = new MainWindowView();
            actualizador = new ActualizadorController();
            Thread hiloActualizador = new Thread(actualizador);
            Image icon = Toolkit.getDefaultToolkit().createImage("tray.png");
            ventana.setVisible(true);
            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("tray.png"));
            trayIcon.setImageAutoSize(true);
            ventana.setIconImage(icon);
        try {
            SystemTray.getSystemTray().add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        hiloActualizador.start();
        
    }

    public static MainWindowView getVentana() {
        return ventana;
    }

    public static void setVentana(MainWindowView aVentana) {
        ventana = aVentana;
    }

    public static ActualizadorController getActualizador() {
        return actualizador;
    }

    public static void setActualizador(ActualizadorController aActualizador) {
        actualizador = aActualizador;
    }
}
