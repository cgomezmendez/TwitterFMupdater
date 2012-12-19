/*
 * 
 * 
 */
package com.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author cgomezmendez
 */
interface EntidadInterfaceController {
    public static final EntityManager MANEJADORENTIDADES = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();
}
