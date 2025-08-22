package com.mbank.dto;

import com.mbank.entity.Veiculo;

public class VeiculoDTO {

    private Integer id;
    private Integer codigo;
    private String modelo;
    private String observacao;

    public VeiculoDTO() {super();}

    public VeiculoDTO(final Veiculo veiculo) {
        super();
        this.id = veiculo.getId();
        this.codigo = veiculo.getCodigo();
        this.modelo = veiculo.getModelo();
        this.observacao = veiculo.getObservacao();
    }

    public VeiculoDTO(final Integer id, final Integer codigo, final String modelo, final String observacao) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.observacao = observacao;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
