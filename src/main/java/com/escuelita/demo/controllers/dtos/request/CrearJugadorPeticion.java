package com.escuelita.demo.controllers.dtos.request;

public class CrearJugadorPeticion {

    private String nombre;

    private int edad;

    private String equipo;

    private String direccion; //ESTO ES ALGO QUE NOSOTROS LOS AFICIONADOS NO PODEMOS SABER



















    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
