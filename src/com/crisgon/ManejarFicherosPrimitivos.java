package com.crisgon;

import java.io.*;

public class ManejarFicherosPrimitivos {

    private File fichero;

    public ManejarFicherosPrimitivos(File fichero) {
        this.fichero = fichero;
    }

    //DataInputStream lectura de datos
    //DataOutputStream escritura de datos

    public void leerDataInput() {

        try {
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);

            String s;
            while ((s = dis.readUTF()) != null) {
                System.out.println(s);
            }

        } catch (IOException e ){
            //Lanza un EOFException que hay que capturar.
            e.printStackTrace();
        }
    }

    public void escribirDataOutput() {

        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF("Esto es una prueba");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
