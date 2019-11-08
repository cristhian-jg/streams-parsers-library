package com.crisgon.serializacion;

import java.io.*;
import java.util.ArrayList;

public class ManejarFicherosSerializados {

    private File fichero;
    private ArrayList<Empleado> empleados;

    public ManejarFicherosSerializados(File fichero) {
        this.fichero = fichero;
        this.empleados = new ArrayList<>();
    }

    public void escribirObjectOutput(Empleado e) {

        if (fichero.exists() && fichero.length() > 0) {
            try (MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true))){
                oos.writeObject(e);
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
                oos.writeObject(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        empleados.add(e);
    }

    public void leerObjectInput() {

        Empleado e;

        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                e = (Empleado) ois.readObject();
                empleados.add(e);
            }
        } catch (IOException | ClassNotFoundException ioe) {
            //ioe.printStackTrace();
        }
    }

    public void imprimir() {
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println(empleados.get(i));
        }
    }
}
