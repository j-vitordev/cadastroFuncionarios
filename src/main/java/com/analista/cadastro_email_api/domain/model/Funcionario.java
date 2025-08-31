package com.analista.cadastro_email_api.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private FuncionarioId id;


    private String nome;
    private String email;
    private String cargo;

}
