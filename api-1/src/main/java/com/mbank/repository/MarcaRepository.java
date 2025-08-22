package com.mbank.repository;

import com.mbank.dto.MarcaDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class MarcaRepository {

    @Inject
    private EntityManager em;

    public List<MarcaDTO> getAll() {
        return em.createQuery("SELECT new com.mbank.dto.MarcaDTO(m.id, m.codigo, m.nome) FROM Marca m", MarcaDTO.class)
                .getResultList();
    }
}
