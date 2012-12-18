/*
 * 
 * 
 */
package com.controller;

import entity.App;
import entity.Mensajes;
import entity.Twitter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cgomezmendez
 */
public class AppController implements EntidadInterfaceController{
EntityManager manejadorEntidades = getMANEJADORENTIDADES();
    public static EntityManager getMANEJADORENTIDADES() {
        return MANEJADORENTIDADES;
    }

    @Override
    public void guardarEnDataBase(List<String> entrada) {
        App app = manejadorEntidades.find(App.class, 1);
        manejadorEntidades.getTransaction().begin();
        app.setXmlLocation(entrada.get(0));
        manejadorEntidades.getTransaction().commit();
    }

    @Override
    public List<String> obtenerDesdeBD() {
        App app = MANEJADORENTIDADES.find(App.class,1);
        List<String> datos = new ArrayList<>();
        String lugarArchivoXml = app.getXmlLocation();
        String activo = app.getActivo().toString();
        datos.add(0,lugarArchivoXml);
        datos.add(1,activo);
        return datos;
    }
    
    public void guardarEstado(boolean estado){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        app.setActivo(estado);
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public boolean retornarEstado(){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        boolean activo = app.getActivo().booleanValue();
        return activo;
        
    }
    
    public boolean retornaPrimeraVez(){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        return app.getEjecutado();
    }
    
    public void guardarPrimeraVez(){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        app.setEjecutado(Boolean.TRUE);
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public void crearAPP(){
        MANEJADORENTIDADES.getTransaction().begin();
        Mensajes mensajes = new Mensajes(1);
        Twitter twitter = new Twitter(1);
        App app = new App(1);
        MANEJADORENTIDADES.persist(mensajes);
        MANEJADORENTIDADES.persist(twitter);
        MANEJADORENTIDADES.persist(app);
        app.setEjecutado(Boolean.FALSE);
        app.setActivo(Boolean.FALSE);
        app.setSegundosRetraso(0);
        app.setMinutosRetraso(0);
        app.setPreCancion(Boolean.TRUE);
        app.setCancion(Boolean.TRUE);
        app.setPreArtista(Boolean.TRUE);
        app.setArtista(Boolean.TRUE);
        app.setUltimo(Boolean.TRUE);
        mensajes.setMensajeInicial("ahora suena: ");
        mensajes.setMensajeArtista("");
        mensajes.setMensajeFinal("");
        twitter.setPassword(null);
        twitter.setPassword(null);
        app.setXmlLocation("C:".concat(File.pathSeparator).concat("Jazler RadioStar 2").concat(File.pathSeparator).concat("Exports"));
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public void guardarRetraso(int minutos,int segundos){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        app.setMinutosRetraso(minutos);
        app.setSegundosRetraso(segundos);
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public int getRetraso(String tipo){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        if (tipo.equals("minutos")){
            return app.getMinutosRetraso();
        }
        if (tipo.equals("segundos")){
            return app.getSegundosRetraso();
        }
        return 0;
    }
    
    public static boolean[] getCheckboxMensajes(){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        boolean[] checkBoxes = new  boolean[5];
        checkBoxes[0] = app.getPreCancion();
        checkBoxes[1] = app.getCancion();
        checkBoxes[2] = app.getPreArtista();
        checkBoxes[3] = app.getArtista();
        checkBoxes[4] = app.getUltimo();
        return checkBoxes;
    }
    
    public static void guardarCheckBoxMensajes(boolean[] checkBoxes){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        app.setPreCancion(checkBoxes[0]);
        app.setCancion(checkBoxes[1]);
        app.setPreArtista(checkBoxes[2]);
        app.setArtista(checkBoxes[3]);
        app.setUltimo(checkBoxes[4]);
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public static String getIdMaquina(){
        App app = MANEJADORENTIDADES.find(App.class, 1);
        if (app.getIdMaquina().isEmpty()){
            return "no";
        }
        return app.getIdMaquina();
    }
}
