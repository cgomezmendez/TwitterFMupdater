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
public class DetenerController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        ActualizadorController.setCorrer(false);
        Main.getVentana().getjPanel5().setVisible(false);
        Main.getVentana().getjPanel6().setVisible(true);
    }
    
}
