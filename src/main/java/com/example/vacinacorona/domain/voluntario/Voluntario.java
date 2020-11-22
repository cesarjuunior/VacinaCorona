package com.example.vacinacorona.domain.voluntario;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Data
@Entity
@Table(name = "voluntario")
public class Voluntario {

    @Id
    @Column(name = "idvoluntario")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private String idade;

    @Column(name = "comorbidades")
    private String comorbidades;
}
