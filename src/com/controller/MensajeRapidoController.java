/*
 * 
 * 
 */
package com.controller;

import com.Main;
import com.view.MainWindowView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import twitter4j.StatusUpdate;

/**
 *
 * @author cgomezmendez
 */
public class MensajeRapidoController implements ActionListener{
    MainWindowView ventana;

    public MensajeRapidoController(MainWindowView ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje = ventana.getTextBoxMensajeRapido().getText();
        Main.getActualizador().getTwitter().actualizarEstado(new StatusUpdate(mensaje));
        ventana.getTextBoxMensajeRapido().setText("");
    }
    
}
