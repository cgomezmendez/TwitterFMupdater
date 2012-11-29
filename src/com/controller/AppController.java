/*
 * 
 * 
 */
package com.controller;

import entity.App;
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
    
}
