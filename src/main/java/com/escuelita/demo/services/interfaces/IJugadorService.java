package com.escuelita.demo.services.interfaces;

import com.escuelita.demo.controllers.dtos.request.CrearJugadorPeticion;
import com.escuelita.demo.controllers.dtos.responses.CrearActualizacionDeJugador;
import com.escuelita.demo.controllers.dtos.responses.CrearJugadorAficionado;

import java.util.List;

public interface IJugadorService {

    //LO QUE REGRESAS ............. (LO QUE RECIBO)
    //CREATE
    CrearJugadorAficionado crearJugador(CrearJugadorPeticion jugador);

    //READ
    CrearJugadorAficionado verJugador(Long id);
    List<CrearJugadorAficionado> verJugadores ();


    //UPDATE
    CrearActualizacionDeJugador actualizarJugador ( Long id, CrearJugadorPeticion jugadorPeticion);


    //DELETE
    void borrarJugador(Long id);
}
