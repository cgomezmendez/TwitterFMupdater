

import entity.Prueba;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/*
 * 
 * 
 */

/**
 *
 * @author cgomezmendez
 */
public class Start {
    public static void main(String... args){
        EntityManager manejadorEntidades = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();
        List resultList = manejadorEntidades.createNativeQuery("SELECT nombre FROM prueba nombre").getResultList();
    }
}
