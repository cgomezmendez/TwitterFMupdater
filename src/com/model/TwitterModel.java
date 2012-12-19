/*
 * 
 * 
 */
package com.model;
import com.controller.TwitterController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author cgomezmendez
 */
public class TwitterModel {
    Twitter twitter;
    AccessToken tokenAcceso;
    RequestToken peticionToken;
    private boolean autentificado = false;
    public TwitterModel() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("QF1MyYWBYcViM1fZNVNqPQ")
                .setOAuthConsumerSecret("sUDJeFWlEPnqXaiBA1x4rZyaUdJ267aw8FLW3qXYe7g");

        twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            peticionToken = twitter.getOAuthRequestToken();
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Loguearse(String pin){
        if (!pin.equals("nada")) {
        try {
            tokenAcceso = twitter.getOAuthAccessToken(peticionToken, pin);
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> datos = new ArrayList<>();
        datos.add(0,peticionToken.getToken());
        datos.add(1,peticionToken.getTokenSecret());
        TwitterController controlador = new TwitterController();
        TwitterController.guardarEnDataBase(datos);
        autentificado = true;
        }
        
        else {
            TwitterController controlador = new TwitterController();
            ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAccessToken(TwitterController.obtenerDesdeBD().get(0))
                .setOAuthAccessTokenSecret(TwitterController.obtenerDesdeBD().get(1))
                .setOAuthConsumerKey("WHvCEQEbaBDcOKpX6itoIw")
                .setOAuthConsumerSecret("sKMsMQs43H3vFL6V6fKxRvcL8u52EeJj2wiiBAcJSG0");
                twitter = new TwitterFactory(cb.build()).getInstance();
                
        }
        
    }

    public void actualizarEstado(StatusUpdate ultimoEstado ){
        try {
            twitter.updateStatus(ultimoEstado);
            TwitterController.guardarUltimoEstado(ultimoEstado.getStatus());
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public AccessToken getTokenAcceso() {
        return tokenAcceso;
    }

    public void setTokenAcceso(AccessToken tokenAcceso) {
        this.tokenAcceso = tokenAcceso;
    }

    public RequestToken getPeticionToken() {
        return peticionToken;
    }

    public void setPeticionToken(RequestToken peticionToken) {
        this.peticionToken = peticionToken;
    }

    public boolean isAutentificado() {
        return autentificado;
    }

    public void setAutentificado(boolean autentificado) {
        this.autentificado = autentificado;
    }
    
    
}
