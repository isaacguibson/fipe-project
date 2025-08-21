package com.mdasdead.entity;

import com.mdasdead.dto.MarcaModeloDTO;
import com.mdasdead.dto.ModeloDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    private Integer codigo;
    private String modelo;
    private String observacao;

    public Veiculo() {
        super();
    }

    public Veiculo(final ModeloDTO modeloDTO) {
        super();
        this.codigo = modeloDTO.getCodigo();
        this.modelo = modeloDTO.getNome();
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
