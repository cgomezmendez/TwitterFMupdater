/*
 * 
 * 
 */
package com.controller;

import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author cgomezmendez
 */
public class NavegadorController implements HyperlinkListener{
    private JEditorPane navegador;

    public NavegadorController(JEditorPane navegador) {
        this.navegador = navegador;
    }
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent Event) {
            if (Event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
      try {
        navegador.setPage(Event.getURL());
      } catch(IOException ioe) {
        // Some warning to user
      }
    }
}
}
