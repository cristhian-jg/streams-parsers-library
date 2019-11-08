package com.crisgon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ManejarAccesoAleatorio {

    File fichero;

    public ManejarAccesoAleatorio(File fichero) {
        this.fichero = fichero;
    }

    //Suponiendo que la estructura del fichero es String # Integer # Char

    public void escribirRandomAccessFile() {

        //Hay que conocer el formato del archivo y seguirlo.

        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
            raf.seek(raf.length()); //Posicionar el puntero al final del archivo.

            raf.writeUTF("String"); //Escribir un String
            raf.writeInt(1); //Escribir un entero
            raf.writeChar('c'); //Escribir un caracter

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean leerRandomAccessFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw"); //mode r: leer # mode: w escribir # mode: rw leer y escribir
            raf.seek(0); //Pocisionar puntero al principio del archivo

            while (raf.getFilePointer() < raf.length()) {//Devuelve la distancia que ha recorrido el punto
                if (raf.readUTF().equals("String")) {
                    return true;

                    //raf.readInt(); //Se salta este campo al no guardarlo.
                    //raf.readChar();

                    //Volvemos a estar en String.

                    //raf.skipBytes(); //Recorrer la cantidad de bytes que quiero
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void imprimirRandomAccessFile() {
        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
            raf.seek(0);

            while (raf.getFilePointer() < raf.length()) {
                System.out.println(raf.readUTF());
                System.out.println(raf.readInt());
                System.out.println(raf.readChar());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
