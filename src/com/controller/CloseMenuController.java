/*
 * 
 * 
 */
package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cgomezmendez
 */
public class CloseMenuController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(99);
    }
    
}
