/*
 * 
 * 
 */
package com.model;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
/**
 *
 * @author cgomezmendez
 */
public class TwitterModel {
    Twitter twitter = TwitterFactory.getSingleton();
    Status estado;
    public void actualizarEstado(StatusUpdate ultimoEstado ){
        try {
            estado = twitter.updateStatus(ultimoEstado);
        } catch (TwitterException ex) {
           
        }
        

    }
    
}
