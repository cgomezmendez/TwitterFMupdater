

import entity.App;
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
public class Main {
    public static void main(String... args){
        EntityManager manejadorEntidades = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();
        List<App> listaApps = manejadorEntidades.createQuery("Select id from App id").getResultList();
        
        
        
    }
}
