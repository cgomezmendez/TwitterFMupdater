package com;



import com.controller.ActualizadorController;
import com.controller.AppController;
import com.controller.CloseMenuController;
import com.controller.StartMenuController;
import com.controller.StopMenuController;
import com.controller.TrayIconController;
import com.controller.TwitterPrimeraConfController;
import com.model.TwitterModel;
import com.view.MainWindowView;
import com.view.PrimeraConfiguracionView;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private static AppController app = new AppController();
    private static ActualizadorController actualizador;
    private static MainWindowView ventana;
    static  private TrayIcon trayIcon;
    static private boolean configuracionIsActiva;
    static private TwitterModel twitter;
    public static void main(String... args){
        try {
            AppController.retornaPrimeraVez();
        }
        catch (NullPointerException e){
            crearPrograma();
        }
        if (AppController.retornaPrimeraVez()==false){
            JLabel bienvenida = new JLabel("Bienvenido a TwitterFMUpdater 2.0,presione OK para continuar", new ImageIcon("aveazul.png"), 0);
            JOptionPane ventanita = new JOptionPane();
            ventanita.setSize(400,400);
            JOptionPane.showMessageDialog(ventana, bienvenida, "Bienvenido a TwitterFMUpdater 2.0", JOptionPane.INFORMATION_MESSAGE);
            AppController.guardarPrimeraVez();
            
        }
        ventana = new MainWindowView();
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(ventana);
            ventana.pack();
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.out.println("problema look and feeel");
        }
        PrimerUsoAutentificacionTwitter();
        AppController.guardarEstado(true);
        Thread hiloActualizador = new Thread(actualizador);
        hiloActualizador.start();
        Image icon = Toolkit.getDefaultToolkit().getImage(Image.class.getResource("/images/tray.png"));
        ventana.setVisible(true);
        trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(Image.class.getResource("/images/tray.png")));
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

    public static AppController getApp() {
        return app;
    }

    public static void setApp(AppController app) {
        Main.app = app;
    }


    public static boolean isConfiguracionIsActiva() {
        return configuracionIsActiva;
    }

    public static void setConfiguracionIsActiva(boolean configuracionIsActiva) {
        Main.configuracionIsActiva = configuracionIsActiva;
    }
    
    public static void crearPrograma(){
            boolean licenciaIsValida = false;
            String licencia;
            while (!licenciaIsValida){
            licencia = JOptionPane.showInputDialog(null,"Introduzca Su Numero De Licencia","TwitterFMUpdater 2.0",JOptionPane.QUESTION_MESSAGE);
            if (licencia.equals("UM3S5Y-PD530-RS04E-EY3DH")){
                licenciaIsValida = true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Licencia invalida","TwitterFMUpdater 2.0",JOptionPane.ERROR_MESSAGE);
            }
            }
 
            AppController.crearAPP();

    }
    public static void PrimerUsoAutentificacionTwitter(){
                TwitterPrimeraConfController controladorVentanaAutentificacion = new TwitterPrimeraConfController();
        PrimeraConfiguracionView ventanaAutentificacion = new PrimeraConfiguracionView();
        controladorVentanaAutentificacion.setVentana(ventanaAutentificacion);
        ventanaAutentificacion.getGuardarTwitterPrimeraConf().addActionListener(controladorVentanaAutentificacion);
        twitter = new TwitterModel();
        controladorVentanaAutentificacion.setTwitter(twitter);
        try {
            ventanaAutentificacion.getNavegador().setPage(twitter.getPeticionToken().getAuthenticationURL());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventanaAutentificacion.setVisible(true);
        int i;
        while (twitter.isAutentificado()==false){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualizador = new ActualizadorController(twitter);
    }
}
