package com.example.ParcialI.Repository;

import com.example.ParcialI.Model.EstadisticasJugador;
import com.example.ParcialI.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {

    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadisticas_jugador e ON j.id_jugador = e.id_jugador " +
            "GROUP BY j.id_jugador " +
            "HAVING SUM(e.goles) > :minGoles", nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("minGoles") int minGoles);
}
