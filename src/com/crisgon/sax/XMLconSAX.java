package com.crisgon.sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class XMLconSAX {

    public void parsear() {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            LectorXML lector = new LectorXML();
            xr.setContentHandler(lector);
            InputSource is = new InputSource("empleados.xml");
            xr.parse(is);
        } catch (SAXException |
                IOException e) {
            e.printStackTrace();
        }
    }
}
