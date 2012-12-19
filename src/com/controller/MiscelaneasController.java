/*
 * 
 * 
 */
package com.controller;

import com.view.MainWindowView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cgomezmendez
 */
public class MiscelaneasController implements ActionListener{
    MainWindowView ventana;

    public MiscelaneasController(MainWindowView ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AppController.guardarMiscelaneasCheckBoxJingles(ventana.getCheckBoxJingles().isSelected());
    }
    
}
