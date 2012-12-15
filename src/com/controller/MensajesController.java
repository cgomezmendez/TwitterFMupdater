/*
 * 
 * 
 */
package com.controller;

import entity.Mensajes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author cgomezmendez
 */
public class MensajesController implements EntidadInterfaceController{
EntityManager manejadorEntidades = getMANEJADORENTIDADES();
    public static EntityManager getMANEJADORENTIDADES() {
        return MANEJADORENTIDADES;
    }

    @Override
    public void guardarEnDataBase(List<String> entrada) {
        Mensajes mensajes = manejadorEntidades.find(Mensajes.class, 1);
        
        manejadorEntidades.getTransaction().begin();
        mensajes.setMensajeInicial(entrada.get(0));
        manejadorEntidades.getTransaction().commit();
        manejadorEntidades.getTransaction().begin();
        mensajes.setMensajeArtista(entrada.get(1));
        manejadorEntidades.getTransaction().commit();
        manejadorEntidades.getTransaction().begin();
        mensajes.setMensajeFinal(entrada.get(2));
        manejadorEntidades.getTransaction().commit();
        
    }
    
    @Override
    public List<String> obtenerDesdeBD(){
        Mensajes mensajes = manejadorEntidades.find(Mensajes.class, 1);
        String mensajeInicial = mensajes.getMensajeInicial();
        String mensajeArtista = mensajes.getMensajeArtista();
        String mensajeFinal = mensajes.getMensajeFinal();
        List<String> datos = new ArrayList<>();
        datos.add(0,mensajeInicial);
        datos.add(1,mensajeArtista);
        datos.add(2,mensajeFinal);
        return datos;
    }
    
    
    
}
