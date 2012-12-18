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
        String mensajeAntesCancion = Main.getVentana().getjTextField3().getText();
        Main.getVentana().getjTextField3().setText("");
        String mensajeAntesArtista = Main.getVentana().getjTextField2().getText();
        Main.getVentana().getjTextField2().setText("");
        String mensajeFinal = Main.getVentana().getjTextField1().getText();
        Main.getVentana().getjTextField1().setText("");
        List<String> mensajes = new ArrayList<>();
        mensajes.add(mensajeAntesCancion);
        mensajes.add(mensajeAntesArtista);
        mensajes.add(mensajeFinal);
        MensajesController mensajeControler = new MensajesController();
        mensajeControler.guardarEnDataBase(mensajes);
        minutos = (int) Main.getVentana().getSpinerMinutos().getValue();
        segundos = (int) Main.getVentana().getSpinerSegundos().getValue();
        AppController app = new AppController();
        app.guardarRetraso(minutos, segundos);
        boolean[] checkboxes = new boolean[5];
        checkboxes[0] = Main.getVentana().getPreCancionCheckBox().isSelected();
        checkboxes[1] = Main.getVentana().getCancionCheckBox().isSelected();
        checkboxes[2] = Main.getVentana().getPreArtistaCheckBox().isSelected();
        checkboxes[3] = Main.getVentana().getArtistaCheckBox().isSelected();
        checkboxes[4] = Main.getVentana().getFinalCheckBox().isSelected();
        AppController.guardarCheckBoxMensajes(checkboxes);
        
    }
    
}
