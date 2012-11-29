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
        datos.add(0,lugarArchivoXml);
        return datos;
    }
    
}
