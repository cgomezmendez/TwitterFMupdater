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

    @Override
    public void guardarEnDataBase(List<String> entrada) {
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        MANEJADORENTIDADES.getTransaction().begin();
        twitter.setUsuario(entrada.get(0));
        twitter.setPassword(entrada.get(1));
        MANEJADORENTIDADES.getTransaction().commit();
    }

    @Override
    public List<String> obtenerDesdeBD() {
        Twitter twitter = MANEJADORENTIDADES.find(Twitter.class, 1);
        List<String> datos = new ArrayList<>();
        datos.add(0,twitter.getUsuario());
        datos.add(1,twitter.getPassword());
        return datos;
    }
}
