package br.com.banco.entity;

import java.util.ArrayList;
import java.util.List;

public class ContaDTOConverter {

    public static ContaDTO convertToDTO(Conta conta) {
        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setId(conta.getId());
        contaDTO.setNomeResponsavel(conta.getNomeResponsavel());
        return contaDTO;
    }

    public static List<ContaDTO> convertToListDTO(List<Conta> contas) {
        List<ContaDTO> contaDTOs = new ArrayList<>();
        for (Conta conta : contas) {
            ContaDTO contaDTO = convertToDTO(conta);
            contaDTOs.add(contaDTO);
        }
        return contaDTOs;
    }
}
