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
private int minutos;
private int segundos;
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensajeAntesCancion = Main.getVentana().getFieldMensajeAntesCancion().getText();
        String mensajeAntesArtista = Main.getVentana().getFieldMensajeArtista().getText();
        String mensajeFinal = Main.getVentana().getFieldMensajeFinal().getText();
        List<String> mensajes = new ArrayList<>();
        mensajes.add(0,mensajeAntesCancion);
        mensajes.add(1,mensajeAntesArtista);
        mensajes.add(2,mensajeFinal);
        MensajesController mensajeControler = new MensajesController();
        MensajesController.guardarEnDataBase(mensajes);
        minutos = (int) Main.getVentana().getSpinerMinutos().getValue();
        segundos = (int) Main.getVentana().getSpinerSegundos().getValue();
        AppController app = new AppController();
        AppController.guardarRetraso(minutos, segundos);
        boolean[] checkboxes = new boolean[5];
        checkboxes[0] = Main.getVentana().getPreCancionCheckBox().isSelected();
        checkboxes[1] = Main.getVentana().getCancionCheckBox().isSelected();
        checkboxes[2] = Main.getVentana().getPreArtistaCheckBox().isSelected();
        checkboxes[3] = Main.getVentana().getArtistaCheckBox().isSelected();
        checkboxes[4] = Main.getVentana().getFinalCheckBox().isSelected();
        AppController.guardarCheckBoxMensajes(checkboxes);
        
    }
    
}
