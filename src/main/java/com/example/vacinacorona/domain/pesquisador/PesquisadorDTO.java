package com.example.vacinacorona.domain.pesquisador;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter @Setter
public class PesquisadorDTO {

    private Long id;

    private String nome;

    private Integer idade;

    private String email;

    private String cargo;
}
