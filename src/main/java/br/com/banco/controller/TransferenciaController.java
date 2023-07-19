package br.com.banco.controller;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferService service;

    @Autowired
    public TransferenciaController(TransferService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Transferencia> findTransferencias(
            @RequestParam(value = "minDate", required = false) LocalDate minDate,
            @RequestParam(value = "maxDate", required = false) LocalDate maxDate,
            Pageable pageable
    ) {
        return service.findTransferencias(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transferencia> findTransferenciaById(@PathVariable Long id) {
        Optional<Transferencia> transferencia = service.findTransferenciaById(id);
        return transferencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/operadores")
    public Page<Transferencia> findTransferenciaByOperadores(
            @RequestParam(value = "operadores") String operadores,
            Pageable pageable
    ) {
        return service.findTransferenciaByOperadores(operadores, pageable);
    }
}
