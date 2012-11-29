
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
public class Main {
    public static void main (String... args){
        EntityManager manejadorEntidades = Persistence.createEntityManagerFactory("ActualizadorEmisoraTwitterPU").createEntityManager();
        List<Prueba> lista = manejadorEntidades.createQuery("select nombre from Prueba nombre", Prueba.class).getResultList();
        for (Prueba prueba : lista) {
            System.out.println(prueba.getNombre());
            System.out.println(prueba.getApellido());
        }
    }
    
}
