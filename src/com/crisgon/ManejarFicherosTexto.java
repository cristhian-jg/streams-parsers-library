package com.crisgon;

import java.io.*;

public class ManejarFicherosTexto {

    private File fichero;

    public ManejarFicherosTexto(File fichero) {
        this.fichero = fichero;
    }

    public String leerFichero() {

        int i;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(fichero);
            while ((i = fr.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public boolean escribirFichero() {

        boolean anyadido = false;
        String s = "\nEsto es una prueba";
        char[] c = s.toCharArray();

        try {
            FileWriter fw = new FileWriter(fichero, true);
            for (int i = 0; i < c.length; i++) {
                fw.write(c[i]);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        anyadido = true;
        return anyadido;
    }

    public void leerFicheroBuffer() {
        String s;
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirFicheroBuffer() {
        try {
        FileWriter fw = new FileWriter(fichero, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.newLine();
        bw.write("Esto es una linea añadida con Buffer");
        bw.close();
        fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
