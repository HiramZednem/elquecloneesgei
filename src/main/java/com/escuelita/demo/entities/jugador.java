package com.escuelita.demo.entities;

import javax.persistence.*;

@Entity
public class jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //not null, autoincrement, unix.... (oye carnal la vas a recibir vacia, es tu pedo, arreglate)
    private Long id;

    private String nombre;

    private int edad;

    private String equipo;

    private String direccion; //ESTO ES ALGO QUE NOSOTROS LOS AFICIONADOS NO PODEMOS SABER














    //PARA QUE PUEDA ENTRAR DE TODOS LADOS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
