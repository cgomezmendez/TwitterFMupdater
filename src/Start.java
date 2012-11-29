
import com.controller.ActualizadorController;
import com.view.MainWindowView;
import com.view.VentanaBienvenidaView;


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
        Thread hiloServer = new Thread(new ActualizadorController());
        hiloServer.start();
    }
}
