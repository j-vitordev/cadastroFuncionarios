package com.analista.cadastro_email_api.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    private String cargo;

}
