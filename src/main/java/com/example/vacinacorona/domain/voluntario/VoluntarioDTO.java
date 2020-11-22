package com.example.vacinacorona.domain.voluntario;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class VoluntarioDTO {

    private Long idVoluntario;
    private String nome;
    private String idade;
    private String comorbidades;

    public VoluntarioDTO(){}

    public VoluntarioDTO(Long idVoluntario, String nome, String idade, String comorbidades) {
        this.idVoluntario = idVoluntario;
        this.nome = nome;
        this.idade = idade;
        this.comorbidades = comorbidades;
    }
}
