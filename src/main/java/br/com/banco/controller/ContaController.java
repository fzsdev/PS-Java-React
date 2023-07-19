package br.com.banco.controller;

import br.com.banco.entity.Conta;
import br.com.banco.entity.ContaDTO;
import br.com.banco.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContaController(ContaService contaService, ModelMapper modelMapper) {
        this.contaService = contaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ContaDTO> findContas() {
        List<Conta> contas = contaService.findContas();
        return contas.stream().map(ContaDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> findContaById(@PathVariable Long id) {
        Conta conta = contaService.findContaById(id);
        if (conta != null) {
            ContaDTO contaDto = new ContaDTO(conta);
            return ResponseEntity.ok(contaDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

