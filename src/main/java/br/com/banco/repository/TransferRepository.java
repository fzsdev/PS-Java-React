package br.com.banco.repository;

import br.com.banco.entity.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TransferRepository extends JpaRepository<Transferencia, Long> {
    @Query("SELECT obj FROM Transferencia obj " +
            "WHERE obj.dataTransferencia BETWEEN :min and :max ORDER BY obj.dataTransferencia DESC")
    Page<Transferencia> findTransferencias(LocalDate min, LocalDate max, Pageable pageable);


    @Query("SELECT obj FROM Transferencia obj " +
            "WHERE obj.nomeOperadorTransacao = :operadores")
    Page<Transferencia> findByOperadores(String operadores, Pageable pageable);
}

