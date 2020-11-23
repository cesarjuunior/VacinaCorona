package com.example.vacinacorona.domain.vacina;

import com.example.vacinacorona.domain.fasesVacina.FasesVacina;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @Column(name = "idvacina")
    private Long id;

    @Column(name = "nome_vacina")
    private String nomeVacina;

    @Column(name = "estoque")
    private String estoque;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_fase_vacina")
    private FasesVacina fasesVacina;


}
