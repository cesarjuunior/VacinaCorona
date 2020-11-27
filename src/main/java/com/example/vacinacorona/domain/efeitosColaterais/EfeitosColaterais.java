package com.example.vacinacorona.domain.efeitosColaterais;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "efeitos_colaterais")
public class EfeitosColaterais {

    @Id
    @Column(name = "idefeitos_colaterais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEfeitosColaterais;
    private String comum;
    private String incomum;
    private String raro;
    private String descricao;

    @Transient
    private String tipo;
}
