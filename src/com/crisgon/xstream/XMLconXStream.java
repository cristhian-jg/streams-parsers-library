package com.crisgon.xstream;

import com.crisgon.serializacion.Empleado;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLconXStream {

    private File fichero;

    private ArrayList<Empleado> empleados;

    public XMLconXStream(File fichero) {
        this.fichero = fichero;
        this.empleados = new ArrayList<>();
    }

    public void serializar() {

        Empleado empleado1 = new Empleado("Cristhian", "González", 1200);
        Empleado empleado2 = new Empleado("Johanna", "González", 1200);

        empleados.add(empleado1);
        empleados.add(empleado2);

        try {
            XStream xs = new XStream();
            FileOutputStream fos = new FileOutputStream(fichero);
            xs.alias("employee", Empleado.class);
            xs.useAttributeFor(Empleado.class, "nombre");
            xs.toXML(empleados, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deseralizar() {

        XStream xs = new XStream();

        try {
            FileInputStream origen = new FileInputStream(fichero);
            xs.processAnnotations(Empleado.class);
            xs.allowTypesByRegExp(new String[]{".*"});

            ArrayList<Empleado> empleadosRecuperados = (ArrayList<Empleado>) xs.fromXML(origen);

            for (int  i= 0;i<empleadosRecuperados.size();i++) {
                System.out.println(empleadosRecuperados.get(i).toString());
            }

            //for (int i = 0; i < alumnos.size(); i++)
            //    System.out.println(alumnos.get(i).toString());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
