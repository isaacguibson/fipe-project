package com.mbank.repository;

import com.mbank.dto.VeiculoDTO;
import com.mbank.entity.Veiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class VeiculoRepository {

    @Inject
    private EntityManager em;

    public Veiculo save(final Veiculo veiculo) {
        return em.merge(veiculo);
    }

    public Veiculo findById(final Integer idVeiculo) {
        return em.find(Veiculo.class, idVeiculo);
    }

    public List<VeiculoDTO> findDTOByMarca(final Integer idMarca) {
        return em.createQuery("SELECT new com.mbank.dto.VeiculoDTO(v.id, v.codigo, v.modelo, v.observacao) FROM Veiculo v WHERE v.marca.id = :idMarca", VeiculoDTO.class)
                .setParameter("idMarca", idMarca)
                .getResultList();
    }
}
