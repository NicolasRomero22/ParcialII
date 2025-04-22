package com.example.ParcialI.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_equipo"
)
public class Equipo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;
    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal")
    @JsonManagedReference("local")
    private List<Partido> partidosComoLocal;

    @OneToMany(mappedBy = "equipoVisita")
    @JsonManagedReference("visita")
    private List<Partido> partidosComoVisitante;

}
