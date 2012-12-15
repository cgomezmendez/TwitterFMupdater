/*
 * 
 * 
 */
package com.controller;

import com.model.TwitterModel;
import com.view.PrimeraConfiguracionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author cgomezmendez
 */
public class TwitterPrimeraConfController implements ActionListener{
    PrimeraConfiguracionView ventana;
    TwitterModel twitter;

    public PrimeraConfiguracionView getVentana() {
        return ventana;
    }

    public void setVentana(PrimeraConfiguracionView ventana) {
        this.ventana = ventana;
    }
    

    public TwitterModel getTwitter() {
        return twitter;
    }

    public void setTwitter(TwitterModel twitter) {
        this.twitter = twitter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        twitter.Loguearse(ventana.getPin().getText());
        ventana.setVisible(false);
        new AppController().guardarEstado(true);
        System.out.println("probando");
    }
    
}
