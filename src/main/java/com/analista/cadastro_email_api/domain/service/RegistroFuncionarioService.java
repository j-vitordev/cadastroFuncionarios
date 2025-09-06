package com.analista.cadastro_email_api.domain.service;

import com.analista.cadastro_email_api.domain.exception.FuncionarioExcepion;
import com.analista.cadastro_email_api.domain.model.Funcionario;
import com.analista.cadastro_email_api.domain.model.FuncionarioId;
import com.analista.cadastro_email_api.domain.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistroFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional
    public boolean atualizarEmail(FuncionarioId funcionarioId, String novoEmail) {

        String emailLimpo = novoEmail.trim().replace("\"", "");

        Optional<Funcionario> existente = funcionarioRepository.findByEmail(emailLimpo);
        if (existente.isPresent() && !existente.get().getId().equals(funcionarioId)) {
            throw new FuncionarioExcepion("Email já está em uso por outro funcionário");
        }

        return funcionarioRepository.findById(funcionarioId)
                .map(funcionario ->  {
                    funcionario.setEmail(novoEmail.trim().replace("\"", ""));
                    funcionarioRepository.save(funcionario);
                    return true;

                })

                .orElse(false);
    }

}
