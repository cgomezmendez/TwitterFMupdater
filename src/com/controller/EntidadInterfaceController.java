/*
 * 
 * 
 */
package com.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author cgomezmendez
 */
interface EntidadInterfaceController {
    public static final EntityManager MANEJADORENTIDADES = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();
        void guardarEnDataBase(List<String> entrada);
        List<String> obtenerDesdeBD();
}
