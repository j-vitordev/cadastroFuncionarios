package com.analista.cadastro_email_api.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FuncionarioId implements Serializable {

    private String empresa;
    private String filial;
    private String matricula;
}
