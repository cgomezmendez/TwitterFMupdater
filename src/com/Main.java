package com;



import com.controller.ActualizadorController;
import com.controller.AppController;
import com.controller.CloseMenuController;
import com.controller.StartMenuController;
import com.controller.StopMenuController;
import com.controller.TrayIconController;
import com.view.MainWindowView;
import entity.App;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.PopupMenu;
import java.awt.RenderingHints;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


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
    static  private TrayIcon trayIcon;
    public static void main(String... args){
                ventana = new MainWindowView();
        AppController app = new AppController();
        if (app.retornaPrimeraVez()==false){
            JLabel bienvenida = new JLabel("Bienvenido a TwitterFMUpdater 2.0,presione OK para continuar", new ImageIcon("aveazul.png"), 0);
            JOptionPane ventanita = new JOptionPane();
            ventanita.setSize(400,400);
            ventanita.showMessageDialog(ventana, bienvenida, "Bienvenido a TwitterFMUpdater 2.0", JOptionPane.INFORMATION_MESSAGE);
            app.guardarPrimeraVez();
            
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException  | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            try {UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());}
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException a){
                
            }
        }
            actualizador = new ActualizadorController();
            Thread hiloActualizador = new Thread(actualizador);
            Image icon = Toolkit.getDefaultToolkit().createImage("tray.png");
            ventana.setVisible(true);
            trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage("tray.png"));
            trayIcon.setImageAutoSize(true);
            ventana.setIconImage(icon);
        try {
            trayIcon.addActionListener(new TrayIconController());
            MenuItem detener = new  MenuItem("Detener");
            MenuItem Iniciar = new MenuItem("Iniciar");
            MenuItem cerrar = new MenuItem("Cerrar");
            detener.addActionListener(new StopMenuController());
            Iniciar.addActionListener(new StartMenuController());
            cerrar.addActionListener(new CloseMenuController());
            PopupMenu menu = new PopupMenu("Menu");
            menu.insert(cerrar, 0);
            menu.insert(Iniciar, 1);
            menu.insert(detener, 2);
            trayIcon.setPopupMenu(menu);
            trayIcon.setToolTip("TwitterUpdater 2.0");
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

    public static TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public static void setTrayIcon(TrayIcon aTrayIcon) {
        trayIcon = aTrayIcon;
    }
}
