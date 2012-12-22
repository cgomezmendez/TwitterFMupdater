/*
 * 
 * 
 */
package com.controller;

import com.Main;
import com.model.TextModel;
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
public class ActualizadorController extends Thread{
private static boolean correr = true;
private int tiempoParado;
private int segundos;
private int minutos;
private TwitterModel twitter;
private XmlModel xml = null;
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
        while (true){
            if (AppController.retornarEstado()){
                ArrayList resultados;
                String rutaXML = AppController.getRutaArchivo();
                String tituloCancion = "";
                String nombreArtista = "";
                if (AppController.getRutaArchivo().contains("xml")){
                                    if (AppController.getMiscelaneasCheckBox()){
                    if (TextModel.getPromo(twitter)){
                                            try {
                                                this.sleep(5000);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(ActualizadorController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                        continue;
                    }
                }
                xml = new XmlModel(rutaXML);
                resultados = xml.obtenerInfo();
                if (resultados==null){
                    continue;
                }
                
                tituloCancion =(String) resultados.get(0);
                nombreArtista =(String) resultados.get(1);
                }
                if (AppController.getRutaArchivo().contains("txt")){
                    nombreArtista = TextModel.getInfoCancion()[0];
                    if (TextModel.getInfoCancion().length==2){
                    tituloCancion = TextModel.getInfoCancion()[1];
                    }
                }
                List<String> mensajesObtenidos = MensajesController.obtenerDesdeBD();
                String mensajeAntesCancion = mensajesObtenidos.get(0);
                String mensajeAntesArtista = mensajesObtenidos.get(1);
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
                if (!estadoString.equalsIgnoreCase(mensajeAntesCancion.concat("".concat(mensajeFinal)))){
                if (!estadoString.equalsIgnoreCase(TwitterController.obtenerUltimoEstado())){
                    TwitterController.guardarUltimoEstado(estadoString);
                StatusUpdate actualizacionEstado = new StatusUpdate(estadoString); 
               twitter.actualizarEstado(actualizacionEstado);
                }
                }
               if (AppController.getRetraso("minutos") !=0 | AppController.getRetraso("segundos") != 0){
                   tiempoParado = (AppController.getRetraso("minutos") *60) + AppController.getRetraso("segundos");
                    try {
                        this.sleep(TimeUnit.MILLISECONDS.convert(tiempoParado, TimeUnit.SECONDS));
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
               xml = null;
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

    public int getTiempoParado() {
        return tiempoParado;
    }

    public void setTiempoParado(int tiempoParado) {
        this.tiempoParado = tiempoParado;
    }

    public TwitterModel getTwitter() {
        return twitter;
    }

    public void setTwitter(TwitterModel twitter) {
        this.twitter = twitter;
    }

    public XmlModel getXml() {
        return xml;
    }

    public void setXml(XmlModel xml) {
        this.xml = xml;
    }

    public MensajesController getMensajes() {
        return mensajes;
    }

    public void setMensajes(MensajesController mensajes) {
        this.mensajes = mensajes;
    }
    
}
