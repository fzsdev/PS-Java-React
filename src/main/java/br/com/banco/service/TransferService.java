package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class TransferService {
    @Autowired
    private TransferRepository repository;

    public Page<Transferencia> findTransferencias(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(3650) : LocalDate.parse(minDate);
        LocalDate max = minDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findTranferencias(min, max, pageable);
    }
}
