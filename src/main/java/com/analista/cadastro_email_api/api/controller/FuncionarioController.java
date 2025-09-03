package com.analista.cadastro_email_api.api.controller;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.model.FuncionarioId;
import com.analista.cadastro_email_api.domain.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        }

        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{empresa}/{filial}/{matricula}/email")
    public ResponseEntity<Object> atualizarEmail(@PathVariable String empresa,
                                                 @PathVariable String filial,
                                                 @PathVariable String matricula,
                                                 @RequestBody String novoEmail) {
        FuncionarioId funcionarioId = new FuncionarioId(empresa, filial, matricula);

        return funcionarioRepository.findById(funcionarioId)
                .map(funcionario -> {
                    funcionario.setEmail(novoEmail.trim().replace("\"", ""));
                    funcionarioRepository.save(funcionario);

                    // Retorna 204 NO CONTENT
                    return ResponseEntity.noContent().build();
                })
                // Se não encontrar, retorna 404 NOT FOUND
                .orElse(ResponseEntity.notFound().build());
    }

}
