package com.mbank.dto;

import com.mbank.entity.Marca;

public class MarcaDTO {

    private Integer codigo;
    private String nome;

    public MarcaDTO() {super();}

    public MarcaDTO(final Marca marca) {
        super();
        this.codigo = marca.getCodigo();
        this.nome = marca.getNome();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
