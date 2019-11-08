package com.crisgon.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LectorXML extends DefaultHandler {

    public LectorXML() {
        super();
    }

    @Override
    public void startDocument() {
        //System.out.println("<-- Comienzo documento XML -->");
    }

    @Override
    public void endDocument() {
        //System.out.println("<-- Final documento XML -->");
    }

    @Override
    public void startElement(String uri,
                             String name, String qname,
                             Attributes attributes) {
        //System.out.printf("\tPrincipio elemento: %s %n", name);
        //System.out.println(qnam);
    }

    @Override
    public void endElement(String uri,
                           String name,
                           String qname) {
        //System.out.printf("\tFin elemento: %s %n", name);
        //System.out.println(name);
    }

    @Override
    public void characters(char[] c,
                           int index,
                           int lenght) {
        String s = new String(c, index, lenght);
        s = s.replaceAll("[\t\n]", "");
        //System.out.printf("\tCaracteres: %s %n", s);
        System.out.println(s);
    }
}
