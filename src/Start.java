
import com.controller.ActualizadorController;
import com.view.MainWindowView;
import com.view.VentanaBienvenidaView;
import entity.App;
import entity.AppPK;
import entity.Mensajes;
import entity.Twitter;
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
        EntityManager manejadorEntidades = Persistence.createEntityManagerFactory("probandojpa").createEntityManager();
    }
}
