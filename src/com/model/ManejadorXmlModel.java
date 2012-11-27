/*
 * 
 * 
 */
package com.model;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author cgomezmendez
 */
public class ManejadorXmlModel extends DefaultHandler{
        public void startDocument ()
    {
	System.out.println("Inicio Documento");
    }


    public void endDocument ()
    {
	System.out.println("Final Documento");
    }


    public void startElement (String uri, String name,
			      String qName, Attributes atts)
    {
	if ("".equals (uri))
	    System.out.println("Elemento Inicial: " + qName);
	else
	    System.out.println("Elemento Inicial: {" + uri + "}" + name);
    }


    public void endElement (String uri, String name, String qName)
    {
	if ("".equals (uri))
	    System.out.println("Elemento Final: " + qName);
	else
	    System.out.println("Elemento Final:   {" + uri + "}" + name);
    }


    public void characters (char ch[], int start, int length)
    {
	System.out.print("Characters:    \"");
	for (int i = start; i < start + length; i++) {
	    switch (ch[i]) {
	    case '\\':
		System.out.print("\\\\");
		break;
	    case '"':
		System.out.print("\\\"");
		break;
	    case '\n':
		System.out.print("\\n");
		break;
	    case '\r':
		System.out.print("\\r");
		break;
	    case '\t':
		System.out.print("\\t");
		break;
	    default:
		System.out.print(ch[i]);
		break;
	    }
	}
	System.out.print("\"\n");
    }
}
