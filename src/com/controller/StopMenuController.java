/*
 * 
 * 
 */
package com.controller;

import com.Main;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cgomezmendez
 */
public class StopMenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AppController app = new AppController();
        app.guardarEstado(false);
        Main.getTrayIcon().displayMessage("Info", "El programa se ha parado", TrayIcon.MessageType.INFO);
    }
    
}
