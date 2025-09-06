package com.analista.cadastro_email_api.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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

    @JsonProperty(access = Access.READ_ONLY)
    @EqualsAndHashCode.Include
    @EmbeddedId
    private FuncionarioId id;

    @JsonProperty(access = Access.READ_ONLY)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@empresa\\.com$", message = "O email deve terminar com @empresa.com")
    private String email;

    @JsonProperty(access = Access.READ_ONLY)
    private String cargo;

}
