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
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author cgomezmendez
 */
public class TwitterModel {
Twitter twitterInstance;
    public TwitterModel() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true)
     .setOAuthConsumerKey("7kWmWEmtRW4WeVcQ9oFjQ")
      .setOAuthConsumerSecret("mRmEfixe6Gn02Ap6cs1JXdejN7CmKTVsMG7fK1Nhtc")
    .setOAuthAccessToken("489793575-C1Og7qCDqqMCfwg99ngEq7JIUbHeGJb8kFLw8OS0")
  .setOAuthAccessTokenSecret("7hjsBLQ0OFLqdWovzkxyj0cfwU6HjliCZtOaFouko");
TwitterFactory tf = new TwitterFactory(cb.build());
twitterInstance = tf.getInstance();
    }
    
    Twitter twitter = TwitterFactory.getSingleton();
    Status estado;
    public void actualizarEstado(StatusUpdate ultimoEstado ){
        try {
            estado = twitter.updateStatus(ultimoEstado);
        } catch (TwitterException ex) {
           
        }
        

    }
    
}
