/*
 * 
 * 
 */
package com.controller;

import com.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author cgomezmendez
 */
public class SeleccionarArchivoController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("ApproveSelection")){
            File selectedFile = Main.getVentana().getjFileChooser1().getSelectedFile();
            AppController app = new AppController();
            List<String> datos = new ArrayList<>();
            datos.add(selectedFile.getAbsolutePath());
            app.guardarEnDataBase(datos);
            Main.getVentana().getjTabbedPane2().setSelectedIndex(0);
        }
    }
    
}
