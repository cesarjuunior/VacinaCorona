package com.example.vacinacorona.domain.pesquisador;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Data
@Table(name = "pesquisadores")
public class Pesquisador {

    @Id
    @Column(name = "idpesquisadores")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "email")
    private String email;

    @Column(name = "cargo")
    private String cargo;
}
