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
public class StartMenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AppController app = new AppController();
        app.guardarEstado(true);
        Main.getTrayIcon().displayMessage("Info:", "Programa iniciado", TrayIcon.MessageType.INFO);
    }
    
}
