/*
 * 
 * 
 */
package com.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author cgomezmendez
 */
public class ManejadorXmlModel extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("inicio");
    }
    
 
}
