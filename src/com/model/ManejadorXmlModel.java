/*
 * 
 * 
 */
package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author cgomezmendez
 */
public class ManejadorXmlModel extends DefaultHandler{
    private String tituloCancion;
    private String nombreArtista;
    private ArrayList<String> resultado = new ArrayList<>();
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (attributes.getLocalName(0).equalsIgnoreCase("title")){
            setNombreArtista(attributes.getValue(0));
            getResultado().add(getNombreArtista());
        }
        if (attributes.getLocalName(0).equalsIgnoreCase("name")){
            setTituloCancion(attributes.getValue(0));
            getResultado().add(getTituloCancion());
        }
    }

    /**
     * @return the tituloCancion
     */
    public String getTituloCancion() {
        return tituloCancion;
    }

    /**
     * @param tituloCancion the tituloCancion to set
     */
    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    /**
     * @return the nombreArtista
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * @param nombreArtista the nombreArtista to set
     */
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    /**
     * @return the resultado
     */
    public ArrayList<String> getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ArrayList<String> resultado) {
        this.resultado = resultado;
    }


 
}
