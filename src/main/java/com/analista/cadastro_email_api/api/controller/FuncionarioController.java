package com.analista.cadastro_email_api.api.controller;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.model.FuncionarioId;
import com.analista.cadastro_email_api.domain.repository.FuncionarioRepository;
import com.analista.cadastro_email_api.domain.service.RegistroFuncionarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/funcionarios")
@AllArgsConstructor
@RestController
public class FuncionarioController {

    private final RegistroFuncionarioService registroFuncionarioService;
    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{empresa}/{filial}/{matricula}")
    public ResponseEntity<Funcionario> buscar(@PathVariable String empresa, @PathVariable String filial, @PathVariable String matricula) {

        FuncionarioId funcionarioId = new FuncionarioId(empresa, filial, matricula);
        return funcionarioRepository.findById(funcionarioId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }


    @PatchMapping("/{empresa}/{filial}/{matricula}/email")
    public ResponseEntity<Object> atualizarEmail(@Valid @PathVariable String empresa,
                @PathVariable String filial,
                @PathVariable String matricula,
                @RequestBody String novoEmail) {
        FuncionarioId funcionarioId = new FuncionarioId(empresa, filial, matricula);

        boolean atualizado = registroFuncionarioService.atualizarEmail(funcionarioId, novoEmail);
        if (atualizado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }
