/*
 * 
 * 
 */
package com.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author cgomezmendez
 */
public class XmlModel extends DefaultHandler implements ImprimibleModel{
    Logger logs = Logger.getLogger("Xml");
    String nombreArchivo;
    FileReader archivoXML;
    
    public XmlModel(String iNombreArchivo) {
        super();
        nombreArchivo = iNombreArchivo;
    }
    
    @Override
    public ArrayList<String> obtenerInfo() {
        FileReader archivo = new FileReader(nombreArchivo);
        XmlModel manejador = new XmlModel(null);
     
     try {XMLReader lector = XMLReaderFactory.createXMLReader();
         lector.setContentHandler(manejador);
         lector.setErrorHandler(manejador);
     }
     catch (Exception e){
         logs.warning("error con el manejador de sax");
     }
        return null;
    }
    
}
