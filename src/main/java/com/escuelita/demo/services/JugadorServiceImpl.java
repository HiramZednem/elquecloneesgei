package com.escuelita.demo.services;

import com.escuelita.demo.controllers.dtos.request.CrearJugadorPeticion;
import com.escuelita.demo.controllers.dtos.responses.CrearActualizacionDeJugador;
import com.escuelita.demo.controllers.dtos.responses.CrearJugadorAficionado;
import com.escuelita.demo.entities.jugador;
import com.escuelita.demo.repository.IJugadorRepository;
import com.escuelita.demo.services.interfaces.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements IJugadorService {

    @Autowired
    IJugadorRepository repository;

    //CREATE
    @Override
    public CrearJugadorAficionado crearJugador(CrearJugadorPeticion jugadorPeticion) {
        /*
            Recibo un objeto de tipo peticion            (con todos los datos)
            necesito transformar mi peticion a un jugador (para guardarlo en la base de datos)
            y despues a jugadorAficionado              (para mostrarlo y que no vean cosas que no)
        */

        /*
            Recibo mi jugador peticion (este wey no tiene id)
            Creo un jugador tipo jugador por que este tiene una id, aunque esta vacia, pero ya con eso la
            entidad se encarga


         */

        jugador jugadorBaseDatos = repository.save(crearJugadorNuevo(jugadorPeticion));
        return deJugadorAJugadorAficionado(jugadorBaseDatos);
    }

    //READ
    @Override
    public CrearJugadorAficionado verJugador(Long id) {
        Optional<jugador> jugadorBaseDatosOpcional = repository.findById(id);

        if ( jugadorBaseDatosOpcional.isPresent() ){
            jugador jugadorBaseDatos = jugadorBaseDatosOpcional.get();
            return deJugadorAJugadorAficionado(jugadorBaseDatos);

        }
        throw new RuntimeException("Oye CARNAL, ese wey no esta");
    }

    @Override
    public List<CrearJugadorAficionado> verJugadores() {

        List<CrearJugadorAficionado>  listaJugadoresAficionados  = new ArrayList<>();
        List<jugador> listaTodosJugadores = repository.findAll();

        for ( int i=0; i< listaTodosJugadores.size() ;i++ ){
            listaJugadoresAficionados.add(deJugadorAJugadorAficionado(listaTodosJugadores.get(i)));
        }
        return listaJugadoresAficionados;
    }


    //UPDATE
    @Override
    public CrearActualizacionDeJugador actualizarJugador(Long id, CrearJugadorPeticion jugadorPeticion) {
        Optional<com.escuelita.demo.entities.jugador> jugadorOpcional = repository.findById(id);

        if ( jugadorOpcional.isPresent() ){
            jugador jugadorNuevo = crearJugadorNuevo(jugadorPeticion);

            //ESTE PASO ES EL MAS IMPORTANTE
            jugadorNuevo.setId(jugadorOpcional.get().getId());
            repository.save(jugadorNuevo);

            return deJugadorAActualizarJugador( jugadorNuevo );
        }
        throw new RuntimeException("Oye carnal el dato no esta");
    }

    //DELETE
    @Override
    public void borrarJugador(Long id) {
        repository.deleteById(id);
    }

    private CrearJugadorAficionado deJugadorAJugadorAficionado ( jugador jugadorBaseDatos ){
        CrearJugadorAficionado jugadorAficionado = new CrearJugadorAficionado();
        jugadorAficionado.setNombre(jugadorBaseDatos.getNombre() );
        jugadorAficionado.setEdad(jugadorBaseDatos.getEdad());
        jugadorAficionado.setEquipo(jugadorBaseDatos.getEquipo());
        return jugadorAficionado;
    }
    private jugador crearJugadorNuevo ( CrearJugadorPeticion jugadorPeticion ){
        jugador jugadorNuevo = new jugador();
        jugadorNuevo.setNombre(jugadorPeticion.getNombre());
        jugadorNuevo.setEdad(jugadorPeticion.getEdad());
        jugadorNuevo.setEquipo(jugadorPeticion.getEquipo());
        jugadorNuevo.setDireccion(jugadorPeticion.getDireccion());
        return jugadorNuevo;
    }
    private CrearActualizacionDeJugador deJugadorAActualizarJugador( jugador jugadorNuevo ){

        CrearActualizacionDeJugador actualizacionDeJugador = new CrearActualizacionDeJugador();

        actualizacionDeJugador.setNombre(jugadorNuevo.getNombre());
        actualizacionDeJugador.setEdad(jugadorNuevo.getEdad());
        actualizacionDeJugador.setEquipo(jugadorNuevo.getEquipo());
        actualizacionDeJugador.setDireccion(jugadorNuevo.getDireccion());

        return actualizacionDeJugador;

    }
}
