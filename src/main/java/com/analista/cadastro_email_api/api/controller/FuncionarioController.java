package com.analista.cadastro_email_api.api.controller;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.model.FuncionarioId;
import com.analista.cadastro_email_api.domain.repository.FuncionarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RequestMapping("/funcionarios")
@AllArgsConstructor
@RestController
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{empresa}/{filial}/{matricula}")
    public ResponseEntity<Funcionario> buscar(@PathVariable String empresa, @PathVariable String filial, @PathVariable String matricula) {

        FuncionarioId funcionarioId = new FuncionarioId(empresa, filial, matricula);
        Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);

        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        }

        return ResponseEntity.notFound().build();
    }
}
