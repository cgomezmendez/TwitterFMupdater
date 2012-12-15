/*
 * 
 * 
 */
package com.controller;

import com.Main;
import com.model.TwitterModel;
import com.model.XmlModel;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.StatusUpdate;

/**
 *
 * @author cgomezmendez
 */
public class ActualizadorController implements Runnable{
private static boolean correr = true;
private int tiempoParado;
private int segundos;
private int minutos;
private TwitterModel twitter;
MensajesController mensajes = new MensajesController();
    public static boolean isCorrer() {
        return correr;
    }

    public static void setCorrer(boolean aCorrer) {
        correr = aCorrer;
    } 

    public ActualizadorController(TwitterModel iTwitter) {
        twitter = iTwitter;
    }
    
    @Override
    public void run() {
        boolean presentado = false;
        AppController app = new AppController();
        System.out.println("inicio actualizador");
        System.out.println(app.retornarEstado());
        while (true){
            if (app.retornarEstado()){
                System.out.println("actualizando");
                ArrayList resultados;
                String rutaXML = new AppController().obtenerDesdeBD().get(0);
                XmlModel xml = new XmlModel(rutaXML);
                resultados = xml.obtenerInfo();
                String tituloCancion =(String) resultados.get(0);
                String nombreArtista =(String) resultados.get(1);
                List<String> mensajesObtenidos = mensajes.obtenerDesdeBD();
                String mensajeAntesCancion = mensajesObtenidos.get(1);
                String mensajeAntesArtista = mensajesObtenidos.get(0);
                String mensajeFinal = mensajesObtenidos.get(2);
                String estadoString = "";
                if (AppController.getCheckboxMensajes()[0]){
                    estadoString = mensajeAntesCancion;
                }
                if (AppController.getCheckboxMensajes()[1]){
                    estadoString = estadoString.concat(" ").concat(tituloCancion);
                }
                if (AppController.getCheckboxMensajes()[2]){
                    estadoString = estadoString.concat(" ").concat(mensajeAntesArtista);
                }
                if (AppController.getCheckboxMensajes()[3]){
                    estadoString = estadoString.concat(" ").concat(nombreArtista);
                }
                if (AppController.getCheckboxMensajes()[4]){
                    estadoString = estadoString.concat(" ").concat(mensajeFinal);
                }
                StatusUpdate actualizacionEstado = new StatusUpdate(estadoString); 
               twitter.actualizarEstado(actualizacionEstado); 
               if (app.getRetraso("minutos") !=0 | app.getRetraso("segundos") != 0){
                   tiempoParado = (app.getRetraso("minutos") *60) + app.getRetraso("segundos");
                    try {
                        Thread.sleep(TimeUnit.MILLISECONDS.convert(tiempoParado, TimeUnit.SECONDS));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ActualizadorController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
               if (Main.getVentana().isVisible()==false & !presentado){
                   presentado = true;
                   Main.getTrayIcon().displayMessage("Info:", "Haga click en cualquier momento para volver a abrir la ventana,el programa se esta ejecutando en segundo plano", TrayIcon.MessageType.INFO);
               }
               if (presentado & Main.getVentana().isVisible()){
                   presentado = false;
               }
            }
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
}
