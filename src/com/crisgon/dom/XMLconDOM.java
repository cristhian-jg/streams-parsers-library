package com.crisgon.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLconDOM {

    private File fichero;

    private ArrayList<String> nombres;
    private ArrayList<String> apellidos;
    private ArrayList<Double> sueldos;

    public XMLconDOM(File fichero) {
        this.fichero = fichero;
        this.nombres = new ArrayList<>();
        this.apellidos = new ArrayList<>();
        this.sueldos = new ArrayList<>();
        rellenarArrays();
    }

    public void escribir() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element eRaiz = doc.createElement("empleados");
            doc.appendChild(eRaiz);

            for (int i = 0;i<nombres.size();i++) {
                Element eEmpleado = doc.createElement("empleado");
                eRaiz.appendChild(eEmpleado);

                Attr attr = doc.createAttribute("id");
                attr.setValue(""+(i+1));
                eEmpleado.setAttributeNode(attr);

                Element eNombre = doc.createElement("nombre");
                eNombre.appendChild(doc.createTextNode(nombres.get(i)));
                eEmpleado.appendChild(eNombre);

                Element eApellido = doc.createElement("apellido");
                eApellido.appendChild(doc.createTextNode(apellidos.get(i)));
                eEmpleado.appendChild(eApellido);

                Element eSueldo = doc.createElement("sueldo");
                eSueldo.appendChild(doc.createTextNode(String.valueOf(sueldos.get(i))));
                eEmpleado.appendChild(eSueldo);
            }

            /*
            // Se define el elemento raíz del documento
            Element eRaiz = doc.createElement("empleados");
            doc.appendChild(eRaiz);

            // Se define el nodo que contendrá los elementos
            Element eEmpleado = doc.createElement("empleado");
            eRaiz.appendChild(eEmpleado);

            // Crear atributos para un nodo
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            eEmpleado.setAttributeNode(attr);

            // Se define cada uno de los elementos y se le asigna un valor
            Element eNombre = doc.createElement("nombre");
            eNombre.appendChild(doc.createTextNode("Cristhian"));
            eEmpleado.appendChild(eNombre);

            Element eApellido = doc.createElement("apellido");
            eApellido.appendChild(doc.createTextNode("González"));
            eEmpleado.appendChild(eApellido);

            Element eSueldo = doc.createElement("sueldo");
            eSueldo.appendChild(doc.createTextNode("1200"));
            eEmpleado.appendChild(eSueldo);

            */

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleados.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public void leer() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fichero);

            // Accede al nodo raíz y elimina nodos vacíos y combina adyacentes si es que los hay
            doc.getDocumentElement().normalize();

            // Se almacenan los nodos para luego mostrar la cantidad de ellos con el método getLength()
            NodeList nList = doc.getElementsByTagName("empleado");
            System.out.println("Numero de empleados:" + nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Empleado ID: " + eElement.getAttribute("id"));
                    System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Apellido: " + eElement.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.println("Sueldo: " + eElement.getElementsByTagName("sueldo").item(0).getTextContent());

                }
            }


        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }

    public void rellenarArrays() {

        //Rellenar nombres
        nombres.add("Cristhian");
        nombres.add("Johanna");
        nombres.add("Javier");
        nombres.add("Ligia");

        //Rellenar apellidos
        apellidos.add("González");
        apellidos.add("González");
        apellidos.add("González");
        apellidos.add("González");

        //Rellenar sueldos
        sueldos.add(1200.99);
        sueldos.add(1200.99);
        sueldos.add(1200.99);
        sueldos.add(1200.99);
    }
}
