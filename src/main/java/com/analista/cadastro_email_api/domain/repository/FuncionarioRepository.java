package com.analista.cadastro_email_api.domain.repository;

import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.model.FuncionarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, FuncionarioId> {

    Optional<Funcionario>findByEmail(String email);

}
