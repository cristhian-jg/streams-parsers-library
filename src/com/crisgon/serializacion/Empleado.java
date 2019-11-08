package com.crisgon.serializacion;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;
import java.util.GregorianCalendar;

//La clase del objeto que se va a serializar, se le implementa Serializable.

@XStreamAlias("employee")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @XStreamAsAttribute
    private String nombre;
    private String apellido;
    private double sueldo;

    public Empleado(String nombre, String apellido, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
