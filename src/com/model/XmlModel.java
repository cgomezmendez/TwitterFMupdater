/*
 * 
 * 
 */
package com.model;

import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author cgomezmendez
 */
public class XmlModel extends DefaultHandler implements ImprimibleModel{

    public XmlModel() {
        super();
    }
    
    @Override
    public ArrayList obtenerInfo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
