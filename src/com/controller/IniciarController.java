/*
 * 
 * 
 */
package com.controller;
import com.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author cgomezmendez
 */
public class IniciarController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AppController app = new AppController();
        app.guardarEstado(true);
        Main.getVentana().getjPanel5().setVisible(true);
        Main.getVentana().getjPanel6().setVisible(false);
    }
    
}
