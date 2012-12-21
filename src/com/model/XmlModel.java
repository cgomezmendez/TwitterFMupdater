/*
 * 
 * 
 */
package com.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author cgomezmendez
 */
public class XmlModel implements ImprimibleModel{
    static final Logger logs = Logger.getLogger("Xml");
    String nombreArchivo;
    FileReader archivoXML;
    XMLReader lector;
    String tituloCancion;
    String nombreArtista;
    ManejadorXmlModel manejador = new ManejadorXmlModel(); 
    public XmlModel(String iNombreArchivo) {
        nombreArchivo = iNombreArchivo;
    }
    
    @Override
    public ArrayList<String> obtenerInfo() {
        try {
            archivoXML = new FileReader(nombreArchivo);
        } catch (FileNotFoundException ex) {
           return null;
        }
 
     try {lector = XMLReaderFactory.createXMLReader();
         lector.setContentHandler(manejador);
         lector.setErrorHandler(manejador);
     }
     catch (Exception e){
         logs.warning("error con el manejador de sax");
     }
        try {
            lector.parse(new InputSource(archivoXML));
        } catch (IOException | SAXException ex) {
            
        }
        while (manejador.getResultado().size()<2){
            
        }
        return manejador.getResultado();
    }
    

}

