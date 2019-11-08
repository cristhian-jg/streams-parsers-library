package com.crisgon;

import com.crisgon.dom.XMLconDOM;
import com.crisgon.sax.XMLconSAX;
import com.crisgon.serializacion.Empleado;
import com.crisgon.xstream.XMLconXStream;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {

        File fichero = new File("empleados_xstream.xml");

        //Empleado e1 = new Empleado("Cristhian", "González", 1299.99);
        //Empleado e2 = new Empleado("Johanna", "González", 1299.99);

        //ManejarFicherosTexto mft = new ManejarFicherosTexto(fichero);

        //ManejarAccesoAleatorio maa = new ManejarAccesoAleatorio(fichero);

        //ManejarFicherosBinarios mfb = new ManejarFicherosBinarios(fichero);

        //ManejarFicherosPrimitivos mfp = new ManejarFicherosPrimitivos(fichero);

        //ManejarFicherosSerializados mfs = new ManejarFicherosSerializados(fichero);

        //XMLconDOM xmLconDOM = new XMLconDOM(new File("empleados.xml"));

        //xmLconDOM.escribir();

        //xmLconDOM.leer();

        //XMLconSAX xmLconSAX = new XMLconSAX();

        XMLconXStream xmLconXStream = new XMLconXStream(fichero);

        xmLconXStream.serializar();
        xmLconXStream.deseralizar();

    }
}
