package com.escuelita.demo.controllers;

import com.escuelita.demo.controllers.dtos.request.CrearJugadorPeticion;
import com.escuelita.demo.controllers.dtos.responses.CrearActualizacionDeJugador;
import com.escuelita.demo.controllers.dtos.responses.CrearJugadorAficionado;
import com.escuelita.demo.services.interfaces.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jugador")
public class JugadorController {

    @Autowired
    IJugadorService service;

    /*
      FORMAS DE JALAR ARCHIVOS:
      @RequestBody --> Jalar archivito
      @PathVariable --> jugador/id
      @RequestParam --> ?nombre="juan"?edad="17"
    */

    //CREATE
    @PostMapping
    CrearJugadorAficionado crearJugador(@RequestBody CrearJugadorPeticion jugadorPeticion ){
        return service.crearJugador(jugadorPeticion);

    }

    //READ
    @GetMapping("{id}")
    CrearJugadorAficionado verJugador(@PathVariable Long id){
        return service.verJugador(id);
    }

    @GetMapping
    List<CrearJugadorAficionado> verJugadores (){
        return service.verJugadores();
    }

    //UPDATE
    @PutMapping("{id}")
    CrearActualizacionDeJugador frijol( @PathVariable Long id, @RequestBody CrearJugadorPeticion jugadorPeticion ){
        return service.actualizarJugador(id, jugadorPeticion);
    }

    //DELETE
    @DeleteMapping("{id}")
    void borrarJugador(@PathVariable Long id){
        service.borrarJugador(id);
    }
}
