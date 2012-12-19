/*
 * 
 * 
 */
package com.model;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cgomezmendez
 */
public class TarjetaRedModel {
    public static String getRedID(){
        try {
            final byte[] address = NetworkInterface.getNetworkInterfaces().nextElement().getHardwareAddress();
            String macAdress = "";
            for (int i = 0; i < address.length; i++) {
                byte b = address[i];
                macAdress = macAdress.concat(String.valueOf(b));
                            }
            return macAdress;
        } catch (SocketException ex) {
            Logger.getLogger(TarjetaRedModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
    