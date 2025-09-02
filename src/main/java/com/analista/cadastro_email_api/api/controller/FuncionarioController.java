package com.analista.cadastro_email_api.api.controller;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.repository.FuncionarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

}
