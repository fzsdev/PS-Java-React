package br.com.banco.entity;

import org.modelmapper.ModelMapper;

public class ContaDTO {
    private Long id;
    private String nomeResponsavel;

    public ContaDTO(Conta conta) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(conta, this);
    }

    public ContaDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}