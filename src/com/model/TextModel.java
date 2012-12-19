/*
 * 
 * 
 */
package com.model;

import com.controller.AppController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.StatusUpdate;

/**
 *
 * @author cgomezmendez
 */
public class TextModel {
    static FileInputStream entrada;
    static BufferedReader lector;
    static String tituloYArtista;
    static File archivo;
    static String[] arregloTituloYArtista = new String[2];
    public static String[] getInfoCancion(){
        String[] info = new String[2];
        archivo = new File(AppController.getRutaArchivo());
        try {
            lector = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tituloYArtista = lector.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        info[0] = tituloYArtista.split("\\+")[0];
        try {
            lector.close();
        } catch (IOException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tituloYArtista.split("\\+").length == 2){
            info[1] = tituloYArtista.split("\\+")[1];
        }
        else {
            info[1] = " ";
        }
        return info;
    }
    public static void postearPromo(TwitterModel twitter){
        String promo = "";
        DateFormat formatoFecha = new SimpleDateFormat("yy-MM-dd");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Date fecha = new Date();
        String fechaHoy = formatoFecha.format(fecha);
        String rutaArchivo = "C:".concat(File.separator.concat("Jazler RadioStar 2".concat(File.separator.concat("Logs".concat(File.separator.concat("Jingles").concat(File.separator.concat(fechaHoy).concat(".txt")))))));
        archivo = new File(rutaArchivo);
        try {
            lector = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String str;
            while ((str = lector.readLine())!=null){
                promo = str;
            }
        } catch (IOException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (promo.subSequence(0, 5).equals(formatoHora.format(fecha))){
            String jingle = promo.subSequence(9, promo.length()).toString();
            String regex = "";
            jingle = jingle.replace(" ( JINGLE )", "");
            jingle = jingle.replace(" - ","");
            StatusUpdate estado = new StatusUpdate(jingle);
            twitter.actualizarEstado(estado);
            
        }
        try {
            lector.close();
        } catch (IOException ex) {
            Logger.getLogger(TextModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
