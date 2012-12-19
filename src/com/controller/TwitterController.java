/*
 * 
 * 
 */
package com.controller;

import entity.Twitter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgomezmendez
 */
public class TwitterController implements EntidadInterfaceController{

    public static void guardarEnDataBase(List<String> entrada) {
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        twitter.setUsuario(entrada.get(0));
        twitter.setPassword(entrada.get(1));
        MANEJADORENTIDADES.getTransaction().commit();
    }

    public static List<String> obtenerDesdeBD() {
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        List<String> datos = new ArrayList<>();
        datos.add(0,twitter.getUsuario());
        datos.add(1,twitter.getPassword());
        datos.add(2,twitter.getUltimoTweet());
        return datos;
    }
    
    public static void guardarUltimoEstado(String ultimoEstado){
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        twitter.setUltimoTweet(ultimoEstado);
        MANEJADORENTIDADES.getTransaction().commit();
    }
    
    public static String obtenerUltimoEstado(){
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        return twitter.getUltimoTweet();
    }
}
