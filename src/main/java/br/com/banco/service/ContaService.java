package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> findContas() {
        return repository.findAll();
    }

}