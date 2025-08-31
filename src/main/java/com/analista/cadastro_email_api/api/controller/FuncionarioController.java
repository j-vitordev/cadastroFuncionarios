package com.analista.cadastro_email_api.api.controller;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FuncionarioController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
        TypedQuery<Funcionario> query = manager.
                createQuery("from Funcionario", Funcionario.class);
        return query.getResultList();
    }

}
