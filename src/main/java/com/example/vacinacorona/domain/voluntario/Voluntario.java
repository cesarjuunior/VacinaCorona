package com.example.vacinacorona.domain.voluntario;

import com.example.vacinacorona.domain.empresa.Empresa;
import com.example.vacinacorona.domain.paisTeste.PaisTeste;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Data
@Entity
@Table(name = "voluntario")
public class Voluntario {

    @Id
    @Column(name = "idvoluntario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private String idade;

    @Column(name = "comorbidades")
    private String comorbidades;

    @OneToOne
    @JoinColumn(name = "id_pais_teste")
    private PaisTeste paisTeste;
}
