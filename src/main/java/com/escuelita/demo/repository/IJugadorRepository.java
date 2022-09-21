package com.escuelita.demo.repository;

import com.escuelita.demo.entities.jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadorRepository extends JpaRepository<jugador, Long> {
    //T = El dato que estas trabajando, y el ID = Tipo de dato de la ID



}
