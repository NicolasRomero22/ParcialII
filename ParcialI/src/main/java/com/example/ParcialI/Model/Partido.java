package com.example.ParcialI.Model;

import com.fasterxml.jackson.annotation.*;
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
        property = "id_partido"
)
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;
    private LocalDate fecha;
    private String estadio;
    private int goles_local;
    private int goles_visita;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    @JsonBackReference("local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    @JsonBackReference("visita")
    private Equipo equipoVisita;

    @OneToMany(mappedBy = "partido")
    @JsonManagedReference("partido-estadisticas")
    private List<EstadisticasJugador> estadisticas;
}
