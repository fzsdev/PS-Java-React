package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransferService {
    @Autowired
    private TransferRepository repository;

    public Page<Transferencia> findTransferencias(LocalDate minDate, LocalDate maxDate, Pageable pageable) {
        LocalDate today = LocalDate.now();
        LocalDate min = minDate != null ? minDate : today.minusDays(3650);
        LocalDate max = maxDate != null ? maxDate : today;

        return repository.findTransferencias(min, max, pageable);
    }

    public Optional<Transferencia> findTransferenciaById(Long id) {
        return repository.findById(id);
    }

    public Page<Transferencia> findTransferenciaByOperadores(String operadores, Pageable pageable) {
        return repository.findByOperadores(operadores, pageable);
    }
}
