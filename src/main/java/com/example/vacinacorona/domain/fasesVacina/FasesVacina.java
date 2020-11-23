package com.example.vacinacorona.domain.fasesVacina;

import com.example.vacinacorona.domain.vacina.Vacina;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "fases_vacina")
public class FasesVacina {

    @Id
    @Column(name = "idfases_vacina")
    private Long id;

    @Column(name = "fase1")
    private String fase1;

    @Column(name = "fase2")
    private String fase2;

    @Column(name = "fase3")
    private String fase3;

    @Column(name = "fase4")
    private String fase4;
}
