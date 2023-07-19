package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> findContas() {
        return repository.findAll();
    }

    public Conta findContaById(Long id) {
        Optional<Conta> contaOptional = repository.findById(id); // Corrigido o nome do objeto para "repository"
        return contaOptional.orElse(null);
    }
}