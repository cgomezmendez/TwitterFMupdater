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
    public TwitterModel() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("ZAtD1lB2ufYhnkHMIxgUJg")
                .setOAuthConsumerSecret("sPkOitS4ujCYJ9kCkWATRUrKRs0OExlyaUoPo5UNRrc")
                .setOAuthAccessToken("998735437-aaP2D7ENuCbuPHXYEehfqxqLyqb4a7cmx3Oe72o4")
                .setOAuthAccessTokenSecret("FhLev0n4fXujIPY8yjR1UHs96WGScmGcK3Gxd0XW3Q8");
        twitter = new TwitterFactory(cb.build()).getInstance();
    }

    public void actualizarEstado(StatusUpdate ultimoEstado ){
        try {
            twitter.updateStatus(ultimoEstado);
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

    
}
