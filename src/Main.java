

import com.view.VentanaBienvenidaView;
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
    static private VentanaBienvenidaView bienvenida = new VentanaBienvenidaView();
    public static void main(String... args){
        EntityManager manejadorEntidades = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();

        
        
    }
}
