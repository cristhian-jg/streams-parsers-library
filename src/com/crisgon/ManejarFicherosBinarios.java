package com.crisgon;

import java.io.*;

public class ManejarFicherosBinarios {
    File fichero;

    public ManejarFicherosBinarios(File fichero) {
        this.fichero = fichero;
    }

    //FileInputStream lectura de datos
    //FileOutputStream escritura de datos

    public void escribirFileOutput() {
        try {
            FileOutputStream fos = new FileOutputStream(fichero);

            for (int i = 0; i <= 5; i++) {

                fos.write(i);

            }

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerFileInput() {
        try {
            FileInputStream fis = new FileInputStream(fichero);

            int i;
            while ((i = fis.read())!=-1) {
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
