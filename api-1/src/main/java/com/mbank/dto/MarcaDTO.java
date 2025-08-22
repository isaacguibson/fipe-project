package com.mbank.dto;

import com.mbank.entity.Marca;

public class MarcaDTO {

    private Integer id;
    private Integer codigo;
    private String nome;

    public MarcaDTO() {super();}

    public MarcaDTO(final Marca marca) {
        super();
        this.id = marca.getId();
        this.codigo = marca.getCodigo();
        this.nome = marca.getNome();
    }

    public MarcaDTO(final Integer id, final Integer codigo, final String nome) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
