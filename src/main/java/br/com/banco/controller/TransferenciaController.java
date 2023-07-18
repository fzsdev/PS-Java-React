package br.com.banco.controller;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferService service;

    @GetMapping
    public Page<Transferencia> findTransferencias(
            @RequestParam(value = "minDate", defaultValue = "" ) String minDate,
            @RequestParam(value = "maxDate", defaultValue = "" ) String maxDate,
            Pageable pageable
    ) {
        return service.findTransferencias(minDate, maxDate, pageable);
    }

}