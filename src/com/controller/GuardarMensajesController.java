/*
 * 
 * 
 */
package com.controller;

import com.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgomezmendez
 */
public class GuardarMensajesController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String mensajeAntesCancion = Main.getVentana().getjTextField3().getText();
        Main.getVentana().getjTextField3().setText("");
        String mensajeAntesArtista = Main.getVentana().getjTextField2().getText();
        Main.getVentana().getjTextField2().setText("");
        String mensajeFinal = Main.getVentana().getjTextField1().getText();
        Main.getVentana().getjTextField1().setText("");
        List<String> mensajes = new ArrayList<String>();
        mensajes.add(mensajeAntesCancion);
        mensajes.add(mensajeAntesArtista);
        mensajes.add(mensajeFinal);
        MensajesController mensajeControler = new MensajesController();
        mensajeControler.guardarEnDataBase(mensajes);
    }
    
}
